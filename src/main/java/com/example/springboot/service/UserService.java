package com.example.springboot.service;

import org.springframework.stereotype.Component;

@Component
public interface UserService<UserDao,User,Long> extends BaseService{

    //按用户名查找用户
    public User findUserByName(String name);
}
