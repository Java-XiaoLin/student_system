package com.service;

import com.pojo.User;

public interface UserService {

    void register(User user);

    User login (User user);
}
