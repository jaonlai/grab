package com.example.springboot.controller;

import com.example.springboot.pojo.User;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/main")
public class UserController extends BaseController{

    @Autowired
    UserService userService;

    @RequestMapping("/user/pass/login")
    public User userLogin(@Validated(value= User.Login.class) User user, BindingResult bindingResult) throws Exception {
        //验证错误
        this.validException(bindingResult);
        return (User) userService.findUserByName(user.getName(),user.getPwd());
    }

    @RequestMapping("/user/error")
    public User userError(User user) throws Exception {
        throw new Exception("error");
    }




}
