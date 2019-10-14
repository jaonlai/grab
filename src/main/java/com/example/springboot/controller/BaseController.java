package com.example.springboot.controller;

import com.example.springboot.pojo.User;

import com.example.springboot.utils.RedisKey;
import com.example.springboot.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

public class  BaseController {

    @Value("${spring.profiles.active}")
    protected String env;

    @Autowired
    protected RedisUtils redisUtils;

    protected User userInfo;

    protected User getUserByToken(String token){

        User user=(User) redisUtils.getHash(RedisKey.USER_TOKEN.getKey(),token);
        if(user!=null){
            System.out.println(user);
        }
        System.out.println(user);
        return user;
    }

    public void validException(BindingResult bindingResult) throws Exception {
        if(bindingResult.hasErrors()){
            for(ObjectError error: bindingResult.getAllErrors()){
                throw  new Exception(error.getDefaultMessage());
            }
        }

    }

}
