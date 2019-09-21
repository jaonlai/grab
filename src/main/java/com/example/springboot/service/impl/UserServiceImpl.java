package com.example.springboot.service.impl;


import com.example.springboot.service.UserService;
import com.example.springboot.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl<UserDao, User,Long> extends BaseServiceImpl implements UserService {

    @Autowired
    com.example.springboot.dao.UserDao userDao;

    @Override
    public BaseDao getDao() {
        return userDao;
    }
}
