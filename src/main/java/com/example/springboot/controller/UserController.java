package com.example.springboot.controller;

import com.example.springboot.pojo.User;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
public class UserController extends BaseController{

    @Autowired
    UserService userService;

    @RequestMapping("/user/pass/login")
    public User userLogin(User user){

        return (User) userService.findById(2L);
    }

    @RequestMapping("/user/error")
    public User userError(User user) throws Exception {
        throw new Exception("error");
    }


}
