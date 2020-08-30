package com.controller;

import com.pojo.City;
import com.pojo.Tag;
import com.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("tag")
public class TagController {

    @Autowired
    TagService tagService;


//    根据标签的类型查询对应标签信息
    @RequestMapping("findByType")
    @ResponseBody
    public List<Tag> findByType(String type){
        return tagService.findByType(type);
    }

    @RequestMapping("findAll")
    public String findAll(Model model){
        List<Tag> tags= tagService.findAll();
        model.addAttribute("tags",tags);
        return "back/tag/index";
    }

    @RequestMapping("save")
    public String save(Tag tag){
        tagService.save(tag);
        return "redirect:/tag/findAll";
    }

}
