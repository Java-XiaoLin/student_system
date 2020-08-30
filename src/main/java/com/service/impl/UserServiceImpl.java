package com.service.impl;

import com.mapper.UserMapper;
import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public void register(User user) {
        User u = userMapper.findByName(user.getName());
        if (u!=null){
            throw new RuntimeException("当前用户名已被注册");
        }else {
            user.setRegtime(new Date());
            user.setStatus("激活");
            userMapper.save(user);

        }

    }

    @Override
    public User login(User user) {
        User u=userMapper.findByName(user.getName());
        if (u!=null){
            if (u.getPassword().equals(user.getPassword())){
                return u;
            }else {
                throw new RuntimeException("密码输入错误");
            }
        }
        throw new RuntimeException("用户名输入错误，请从新输入");
    }


}
