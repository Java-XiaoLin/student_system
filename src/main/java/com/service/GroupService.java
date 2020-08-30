package com.service;

import com.pojo.Group;

import java.util.List;

public interface GroupService  {

    List<Group> findAll();

    void save(Group group);

    List<Group> findByClazzId(String id);
}
