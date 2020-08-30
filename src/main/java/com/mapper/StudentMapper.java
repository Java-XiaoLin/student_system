package com.mapper;

import com.mapper.BaseDao;
import com.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentMapper extends BaseDao<Student,String> {

    List<Student> find(@Param("searchCol") String searchCol,@Param("searchValue") String searchValue);//基于条件查询（mybatis不允许出现方法重载）

    //根据条件查询并且分页
    List<Student> findLikePage(@Param("start") Integer start, @Param("rows") Integer rows, @Param("searchCol") String searchCol, @Param("searchValue") String searchValue);

    //根据不用的条件直接返回学生记录数
    Integer totalCounts(@Param("searchCol") String searchCol,@Param("searchValue") String searchValue);

//    保存学生信息的同时保存标签信息
    void save(Student student,String[]   tagIds);

    //根据小组获取id获取对应的学生信息
    List<Student> findByGroupId(String id);
}
