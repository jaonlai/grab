package com.example.springboot.dao;

import com.example.springboot.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends BaseDao<User,Long> {
    public User findByName(String name);
}
