package com.example.springboot.dao;

import com.example.springboot.pojo.Menu;
import com.example.springboot.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuDao extends BaseDao<Menu,Long> {
}
