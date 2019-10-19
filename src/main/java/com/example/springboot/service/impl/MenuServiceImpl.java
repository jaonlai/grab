package com.example.springboot.service.impl;

import com.example.springboot.dao.MenuDao;
import com.example.springboot.dao.UserDao;
import com.example.springboot.pojo.Menu;
import com.example.springboot.service.MenuService;
import com.example.springboot.utils.RedisKey;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public class MenuServiceImpl extends BaseServiceImpl<Menu,Long, MenuDao> implements MenuService {

    @Autowired
    EntityManager entityManager;

    @Autowired
    MenuDao menuDao;
    @Override
    public MenuDao getDao() {
        return menuDao;
    }

    /**
     * 获取用户的菜单
     * @param token
     * @return
     */
    public List<Menu> getMenuList(String token) throws Exception {
        String userStr=redisUtils.get(RedisKey.USER_TOKEN+":"+token);
        if(userStr==null){
            throw new Exception("用户还未登录");
        }

        return null;
    }
}
