package com.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
//泛型1代表操作对象类型，泛型2代表主键类型
public interface BaseDao<T,K> {

    void save(T t);

    void update(T t);

    void delete(K t);

    T findById(K k);

    List<T> findAll();

    List<T> findByPage(@Param("start") Integer start,
                       @Param("rows") Integer rows);

    Long findCounts();
}
