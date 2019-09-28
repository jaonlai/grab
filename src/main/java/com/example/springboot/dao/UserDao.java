package com.example.springboot.dao;

import com.example.springboot.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao extends BaseDao<User,Long> {
    public User findByName(String name);
}
