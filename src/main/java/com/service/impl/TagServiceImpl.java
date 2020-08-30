package com.service.impl;

import com.mapper.TagMapper;
import com.pojo.Tag;
import com.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagMapper tagMapper;

    @Override
    public List<Tag> findAll() {
        return tagMapper.findAll();
    }

    @Override
    public void save(Tag tag) {
        tag.setCreatetime(new Date());
        tagMapper.save(tag);

    }

    @Override
    public List<Tag> findByType(String type) {
        return tagMapper.findByType(type);
    }
}
