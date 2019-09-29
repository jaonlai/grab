package com.example.springboot.service.impl;


import com.example.springboot.service.UserService;
import com.example.springboot.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service("userService")
public class UserServiceImpl<UserDao, User,Long> extends BaseServiceImpl implements UserService {

    @Autowired
    EntityManager entityManager;

    @Autowired
    com.example.springboot.dao.UserDao userDao;

    @Override
    public BaseDao getDao() {
        return userDao;
    }

    private void demo(){

        entityManager.createNamedStoredProcedureQuery("");
    }

    @Override
    public Object findUserByName(String name) {
        return userDao.findByName(name);
    }
}
