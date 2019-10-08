package com.example.springboot.service;

import com.example.springboot.dao.UserDao;
import com.example.springboot.pojo.User;
import com.example.springboot.pojo.UserDetail;
import org.springframework.stereotype.Component;

@Component
public interface UserService extends BaseService<User,Long, UserDao>{

    /**
     * 用户登录
     * @param name
     * @param pwd
     * @return User
     */
    public User findUserByName(String name, String pwd) throws Exception;

    /**
     * 事务新增用户
     * @param user
     * @return
     */
    public User addUserWithTrance(User user, UserDetail userDetail);


}

