package com.controller;

import com.pojo.Group;
import com.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("group")
public class GroupController {

    @Autowired
    GroupService groupService;

    @RequestMapping("findAll")
    public String findAll(Model model){
        List<Group> groups = groupService.findAll();
        model.addAttribute("groups",groups);
        return "back/group/index";
    }

    @RequestMapping("save")
    public String save(Group group){
        groupService.save(group);
        return "redirect:/group/findAll";
    }

    @RequestMapping("findByClazzId")
    @ResponseBody
    public List<Group> findByClazzId(String id){
        return groupService.findByClazzId(id);
    }
}
