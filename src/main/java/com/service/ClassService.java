package com.service;

import com.pojo.Clazz;
import com.pojo.Tag;

import java.util.List;

public interface ClassService {

    List<Clazz>  findAll();

    void save(Clazz clazz);
}
