package com.example.springboot.controller;

import com.example.springboot.pojo.User;

import com.example.springboot.utils.RedisKey;
import com.example.springboot.utils.RedisUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;

public class  BaseController {

    @Value("${spring.profiles.active}")
    protected String env;

    @Autowired
    protected RedisUtils redisUtils;

    protected User userInfo;

    /**
     * 根据token 获取用户信息
     * @return
     * @throws Exception
     */
    protected User getUserByToken(HttpServletRequest httpServletRequest) throws Exception {
        String token = httpServletRequest.getHeader("token");
        String userStr=redisUtils.get(RedisKey.USER_TOKEN.getKey()+":"+token);
        if(userStr!=null){
            System.out.println(userStr);
            ObjectMapper objectMapper = new ObjectMapper();
            User user=objectMapper.readValue(userStr, User.class);
            return user;
        }
        throw new Exception("用户还未登录");
    }

    /**
     * 统一传参异常验证
     * @param bindingResult
     * @throws Exception
     */
    public void validException(BindingResult bindingResult) throws Exception {
        if(bindingResult.hasErrors()){
            for(ObjectError error: bindingResult.getAllErrors()){
                throw  new Exception(error.getDefaultMessage());
            }
        }

    }

}
