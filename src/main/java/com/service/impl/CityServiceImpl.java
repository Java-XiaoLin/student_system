package com.service.impl;

import com.mapper.CityMapper;
import com.pojo.City;
import com.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {


    @Autowired
    CityMapper cityMapper;

//    查询所有
    @Override
    public List<City> findAll() {
        return cityMapper.findAll();
    }

//    增加城市
    @Override
    public void save(City city) {
//        处理录入时间
        city.setCreatetime(new Date());
//        处理就业人数
        city.setNumbers(0);
        cityMapper.save(city);

    }

    @Override
    public List<City> findAllJSON() {
        return cityMapper.findAllJSON();
    }

    @Override
    public void delete(String id) {
        cityMapper.delete(id);
    }
}
