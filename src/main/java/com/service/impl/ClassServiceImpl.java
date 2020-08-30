package com.service.impl;

import com.mapper.ClassMapper;
import com.pojo.Clazz;
import com.pojo.Tag;
import com.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {


    @Autowired
    ClassMapper classMapper;
    @Override
    public List<Clazz> findAll() {
        return classMapper.findAll();
    }

    @Override
    public void save(Clazz  clazz) {
        classMapper.save(clazz);
    }
}
