package com.example.springboot.service;

import com.example.springboot.pojo.User;

public interface UserService extends BaseService{
    /**
     * 用户登录
     * @param user
     * @return
     */
    public User userLogin(User user);
}
