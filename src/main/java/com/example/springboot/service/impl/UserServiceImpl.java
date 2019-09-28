package com.example.springboot.service.impl;

import com.example.springboot.dao.BaseDao;
import com.example.springboot.pojo.User;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.http.HTTPException;

@Service("userService")
public class UserServiceImpl<UserDao, User,Long> extends BaseServiceImpl implements UserService {

    @Autowired
    com.example.springboot.dao.UserDao userDao;

    @Override
    public BaseDao getDao() {
        return null;
    }

    @Override
    public com.example.springboot.pojo.User userLogin(com.example.springboot.pojo.User user) {
        user= userDao.findByName(user.getName());
        //用户不存在
        if(user==null){

        }
        return null;
    }
}
