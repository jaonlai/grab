package com.example.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  BaseDao<T,ID> extends JpaRepository<T,ID> {
}
