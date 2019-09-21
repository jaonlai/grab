package com.example.springboot.controller;

import com.example.springboot.dao.UserDao;
import com.example.springboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {

    protected User getUserByToken(String token){

        return null;
    }

}
