package com.example.springboot.service;

import com.example.springboot.dao.MenuDao;
import com.example.springboot.dao.UserDao;
import com.example.springboot.pojo.Menu;
import com.example.springboot.pojo.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MenuService extends BaseService<Menu,Long, MenuDao>{

    public List<Menu> getMenuList(String tokn) throws Exception;

}
