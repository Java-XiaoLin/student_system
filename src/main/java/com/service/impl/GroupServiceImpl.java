package com.service.impl;

import com.mapper.GroupMapper;
import com.mapper.StudentMapper;
import com.pojo.Group;
import com.pojo.Student;
import com.pojo.Tag;
import com.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    GroupMapper groupMapper;

    @Autowired
    private StudentMapper studentMapper;
    @Override
    public List<Group> findAll() {
        List<Group> groups= groupMapper.findAll();//查询所有组
        //如果组内的学生个数=组内某个学生的标签之和，这个标签就一定是组标签
        groups.forEach(group -> {
//            定义一个map结构，用来技术
            Map<String,Integer> result = new HashMap<>();
            //根据组拿到一个组全部学生信息，比如1组：张三了，李四，王五
            List<Student> students = studentMapper.findByGroupId(group.getId());
                students.forEach(student -> {
//                        对标签进行遍历，然后计数处理 key:标签  值：标签出现的次数
                    List<Tag> tags = student.getTags();
                        tags.forEach(tag -> {
                            if (result.containsKey(tag.getName())){
                                result.put(tag.getName(),result.get(tag.getName())+1);
                            }else {
                                result.put(tag.getName(),1);
                            }
                        });
                });
//                如果result中标签出现的个数 = 组内学生的个数
                result.forEach((k,v)->{
                    if (students.size()==v){
                        group.getTags().add(k);
                    }
                });
        });
        return groups;
    }

    @Override
    public void save(Group group) {
        groupMapper.save(group);
    }

    @Override
    public List<Group> findByClazzId(String id) {
        return groupMapper.findByClazzId(id);
    }
}
