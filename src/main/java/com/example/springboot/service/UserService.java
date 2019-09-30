package com.example.springboot.service;

import com.example.springboot.pojo.User;
import org.springframework.stereotype.Component;

@Component
public interface UserService<UserDao,User,Long> extends BaseService{

    /**
     * 用户登录
     * @param name
     * @param pwd
     * @return User
     */
    public com.example.springboot.pojo.User findUserByName(String name, String pwd) throws Exception;

    /**
     * 用户注册
     * @param user
     * @return
     */
    public com.example.springboot.pojo.User addUser(com.example.springboot.pojo.User user);
}
