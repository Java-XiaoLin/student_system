package com.mapper;

import com.pojo.City;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CityMapper extends BaseDao {

    List<City> findAllJSON();

    City findById(int id);


}
