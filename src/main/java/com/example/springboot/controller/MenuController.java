package com.example.springboot.controller;

import com.example.springboot.service.MenuService;
import com.example.springboot.utils.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main/menu")
public class MenuController extends BaseController {

    @Autowired
    MenuService menuService;

    @RequestMapping("/info")
    public ResponseDto getMenuByToken(String token) throws Exception {
        if(token==null||"".equals(token)){
            throw new Exception("token 不能为空");
        }
        menuService.getMenuList(token);
        return null;
    }
}
