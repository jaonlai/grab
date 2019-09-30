package com.example.springboot.service.impl;


import com.example.springboot.pojo.User;
import com.example.springboot.service.UserService;
import com.example.springboot.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.persistence.EntityManager;
import java.io.Serializable;

@Service("userService")
public class UserServiceImpl<UserDao extends BaseDao, User extends Serializable, Long extends Number> extends BaseServiceImpl<UserDao, User, Long> implements UserService {

    @Autowired
    EntityManager entityManager;

    @Autowired
    com.example.springboot.dao.UserDao userDao;

    @Override
    public BaseDao getDao() {
        return userDao;
    }

    private void demo() {

        entityManager.createNamedStoredProcedureQuery("");
    }

    @Override
    public com.example.springboot.pojo.User findUserByName(String name, String pwd) throws Exception {
        com.example.springboot.pojo.User user = userDao.findByName(name);
        if (user == null) {
            throw new Exception("用户不存在");
        }
        //密码校验
        String coder = pwd + user.getSlat();
        String coderResult= DigestUtils.md5DigestAsHex(coder.getBytes());
        if(coderResult.equals(user.getPwd())){
            return user;
        }
        throw new Exception("密码错误");
    }

    @Override
    public com.example.springboot.pojo.User addUser(com.example.springboot.pojo.User user) {
        return this.add(user);
    }



}
