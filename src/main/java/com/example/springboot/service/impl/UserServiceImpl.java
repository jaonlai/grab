package com.example.springboot.service.impl;


import com.example.springboot.dao.UserDao;
import com.example.springboot.dao.UserDetailDao;
import com.example.springboot.pojo.User;
import com.example.springboot.pojo.UserDetail;
import com.example.springboot.service.UserService;
import com.example.springboot.dao.BaseDao;
import com.example.springboot.utils.RedisKey;
import com.example.springboot.utils.UserLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.persistence.EntityManager;
import java.io.Serializable;

@Service("userService")
public class UserServiceImpl  extends BaseServiceImpl<User,Long,UserDao> implements UserService {

    @Autowired
    EntityManager entityManager;

    @Autowired
    UserDao userDao;

    @Autowired
    UserDetailDao userDetailDao;

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

        String coder = pwd ;
        if(user.getSlat()!=null){
            coder+=user.getSlat();
        }
        String coderResult= DigestUtils.md5DigestAsHex(coder.getBytes());
        if(coderResult.equals(user.getPwd())){
            String token = DigestUtils.md5DigestAsHex((user.getId()+user.getName()+System.currentTimeMillis()).getBytes());
            user.setToken(token);
            User basicUser = new User();
            basicUser.setId(user.getId());
            basicUser.setName(user.getName());
            basicUser.setToken(token);
            redisUtils.setHash(RedisKey.USER_TOKEN.getKey(),token,basicUser,7200);
            return user;
        }
        throw new Exception("密码错误");
    }

    @Override
    @Transactional
    public User addUserWithTrance(User user, UserDetail userDetail) {
        user=this.save(user);
        userDetail.setUserId(user.getId());
        userDetail.setMoney(0L);
        userDetail.setUserPoint(0L);
        userDetail.setUserLevel((long) UserLevel.FREE_USER.getLevel());
        userDetailDao.save(userDetail);
        return null;
    }


}
