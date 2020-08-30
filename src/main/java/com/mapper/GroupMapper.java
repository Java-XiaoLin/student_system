package com.mapper;

import com.pojo.Group;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GroupMapper extends BaseDao<Group,String>{

   List<Group> findByClazzId(String id);
}
