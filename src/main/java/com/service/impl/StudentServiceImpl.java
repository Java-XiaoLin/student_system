package com.service.impl;

import ch.qos.logback.core.db.dialect.DBUtil;
import com.mapper.CityMapper;
import com.mapper.StudentMapper;
import com.mapper.StudentTagMapper;
import com.pojo.City;
import com.pojo.Student;
import com.pojo.StudentTag;
import com.service.StudentService;
import com.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    StudentTagMapper studentTagMapper;

    @Autowired
    CityMapper cityMapper;
    @Override
    public List<Student> findAll() {
        return studentMapper.findAll();
    }

    @Override
    public List<Student> findAll(String searchCol, String searchValue) {
        return studentMapper.find(searchCol,searchValue);
    }

    @Override
    public List<Student> findAll(Integer pageNow, Integer rows, String searchCol, String searchValue) {
        int start = (pageNow-1)*rows;
        return studentMapper.findLikePage(start,rows,searchCol,searchValue);
    }

    @Override
    public Integer totalCounts(String searchCol, String searchValue) {
        return studentMapper.totalCounts(searchCol,searchValue);
    }

    @Override
    public void save(Student student, String[] tagIds) {
//        计算年龄
        int age = DateUtil.getAge(student.getBir());
        student.setAge(age);
//        计算生肖和星座
        String attr = DateUtil.getYear(Integer.valueOf(new SimpleDateFormat("yyyy").format(student.getBir())));
        student.setAttr(attr);
        String starts = DateUtil.getConstellation(student.getBir());
        student.setStarts(starts);
//        保存学生
        studentMapper.save(student);
//        保存学生标签信息
        for (String tagId : tagIds) {
            StudentTag studentTag = new StudentTag();
            studentTag.setStudentid(student.getId());
            studentTag.setTagid(tagId);
            studentTagMapper.save(studentTag);
        }
        //更新添加学生时的就业城市
        City city =(City) cityMapper.findById(student.getCityid());
        city.setNumbers(city.getNumbers()+1);
        cityMapper.update(city);
    }
}
