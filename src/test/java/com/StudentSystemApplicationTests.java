package com;

import com.mapper.GroupMapper;
import com.pojo.City;
import com.pojo.Clazz;
import com.pojo.Group;
import com.pojo.User;
import com.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class StudentSystemApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    CityService cityService;

    @Autowired
    TagService tagService;

    @Autowired
    ClassService classService;

    @Autowired
    GroupMapper groupMapper;

    @Autowired
    StudentService studentService;
    @Test
    void contextLoads()
    {
        //新特性遍历方法，classService.findAll()方法返回的数组，遍历为clazz对象，然后输出
//       classService.findAll().forEach(clazz -> System.out.println(clazz.toString()));
//        tagService.findByType("学生").forEach(tag -> System.out.println(tag.toString()));
//        Clazz clazz =new Clazz();
//        clazz.setName("6班");
//        clazz.setTagid("4");
//        classService.save(clazz);
//        groupMapper.findAll().forEach(group -> System.out.println(group.toString()));
//        Group group =new Group();
//        group.setName("4组").setContent("hello").setClazzid("2");
//        groupMapper.save(group);
        studentService.findAll().forEach(student -> System.out.println(student.toString()));
    }

}
