package com.service;


import com.pojo.City;

import java.util.List;

public interface CityService  {

//    查询所有
    List<City> findAll();

    void save(City city);

    List<City> findAllJSON();

    void delete(String id);

}
