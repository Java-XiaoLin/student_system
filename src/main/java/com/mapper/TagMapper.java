package com.mapper;

import com.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TagMapper extends BaseDao<Tag,String> {

    List<Tag> findByType(String type);
}
