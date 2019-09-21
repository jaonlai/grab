package com.example.springboot.controller;

import com.example.springboot.pojo.Admins;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController extends BaseController {
    @Autowired
    private Admins admins;

    @RequestMapping(value = "/getAdmin")
    public String getUser() {
        return admins.getName();
    }

}
