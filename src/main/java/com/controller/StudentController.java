package com.controller;

import com.mapper.CityMapper;
import com.pojo.Student;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    StudentService studentService;


//    学生添加
    @RequestMapping("save")
    public String save(Student student,String[] tagIds){
        studentService.save(student,tagIds);
        return "redirect:/student/findAll";
    }

    //学生查询所有 模糊 分页
    @RequestMapping("findAll")
    public String findAll(Integer pageNow,Integer rows,Model model,String searchCol,String searchValue){//soutv快捷键可以快速打印变量
        pageNow=pageNow==null?1:pageNow;
        rows=rows==null?2:rows;
        List<Student> students = studentService.findAll(pageNow,rows,searchCol,searchValue);
//        计算总条数
        Integer counts = studentService.totalCounts(searchCol, searchValue);
//        计算总页数
        Integer totalPage = counts%rows==0?counts/rows:counts/rows+1;
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("pageNow",pageNow);
        model.addAttribute("students",students);
        model.addAttribute("searchValue",searchValue);
        model.addAttribute("searchCol",searchCol);
        return "back/student/index";
    }
}
