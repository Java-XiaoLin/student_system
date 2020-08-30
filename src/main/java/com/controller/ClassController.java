package com.controller;

import com.pojo.Clazz;
import com.service.ClassService;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("clazz")
public class ClassController {

    @Autowired
    ClassService classService;

//    添加班级
    @RequestMapping("save")
    public String save(Clazz clazz){
        classService.save(clazz);
        return "redirect:/clazz/findAll";
    }

    @RequestMapping("findAll")
    public String findAll(Model model){
        List<Clazz> clazzs = classService.findAll();
        model.addAttribute("clazzs",clazzs);
        return "back/clazz/index";
    }

    @RequestMapping("findAllClazzJSON")
    @ResponseBody
    public List<Clazz> finAll(){
        return classService.findAll();
    }
}
