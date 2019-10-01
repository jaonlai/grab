package com.example.springboot.service.impl;


import com.example.springboot.dao.UserDao;
import com.example.springboot.pojo.User;
import com.example.springboot.service.UserService;
import com.example.springboot.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.persistence.EntityManager;
import java.io.Serializable;

@Service("userService")
public class UserServiceImpl  extends BaseServiceImpl<User,Long,UserDao> implements UserService {

    @Autowired
    EntityManager entityManager;

    @Autowired
    UserDao userDao;

    @Override
    public UserDao getDao() {
        return (UserDao) userDao;
    }

    private void demo() {

        entityManager.createNamedStoredProcedureQuery("");
    }

    @Override
    public User findUserByName(String name, String pwd) throws Exception {
        User user = userDao.findByName(name);
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
    public User addUser(User user) {
        return  this.add(user);
    }



}
