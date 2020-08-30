package com.service;

import com.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {
    //查询所有
    List<Student> findAll();

    //基于条件查询学生信息
    List<Student> findAll(String searchCol, String searchValue);

    //根据条件分页查询
    List<Student> findAll(Integer pageNow, Integer rows, String searchCol, String searchValue);

    //查询总条数
    Integer totalCounts(String searchCol, String searchValue);

    void save(Student student,String[] tagIds);
}
