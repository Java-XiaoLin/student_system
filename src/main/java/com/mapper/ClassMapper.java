package com.mapper;

import com.pojo.Clazz;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClassMapper extends BaseDao<Clazz,String>{
}
