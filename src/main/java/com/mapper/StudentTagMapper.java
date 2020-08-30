package com.mapper;

import com.pojo.StudentTag;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentTagMapper extends BaseDao<StudentTag,String> {
}
