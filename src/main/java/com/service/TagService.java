package com.service;

import com.pojo.Tag;

import java.util.List;

public interface TagService  {

    //    查询所有
    List<Tag> findAll();

    void save(Tag tag);

    List<Tag> findByType(String type);
}
