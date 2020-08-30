package com.controller;

import com.pojo.City;
import com.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("city")
public class CityController {

    @Autowired
    CityService cityService;

    @RequestMapping("delete")
    public String delete(String id){
        cityService.delete(id);
        return "redirect:/city/findAll";
    }
    @RequestMapping("save")
    public String save(City city){
        cityService.save(city);
        return "redirect:/city/findAll";
    }

    @RequestMapping("findAll")
    public String findAll(Model model){
        List<City> citys = cityService.findAll();
        model.addAttribute("citys",citys);
        return "back/city/index";
    }

    @RequestMapping("findAllJSON")
    @ResponseBody
    public List<City> findAllJSON(){
         return cityService.findAllJSON();
    }
}
