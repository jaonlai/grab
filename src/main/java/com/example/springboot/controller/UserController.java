package com.example.springboot.controller;

import com.example.springboot.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
public class UserController extends BaseController{

    @RequestMapping("/user/pass/login")
    public User userLogin(User user){


        return null;
    }
}
