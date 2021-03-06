package com.example.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@NoRepositoryBean
public interface  BaseDao<T,ID> extends JpaRepository<T,ID>, JpaSpecificationExecutor<T> {

}
