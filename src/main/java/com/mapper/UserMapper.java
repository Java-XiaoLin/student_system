package com.mapper;

import com.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    void save(User user);

   User  findByName(String name);
}
