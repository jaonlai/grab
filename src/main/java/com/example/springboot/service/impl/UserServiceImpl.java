package com.example.springboot.service.impl;

import com.example.springboot.dao.BaseDao;
import com.example.springboot.dao.UserDao;
import com.example.springboot.pojo.User;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl<UserDao, User,Long> extends BaseServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public BaseDao getDao() {
        return null;
    }
}
