package com.example.springboot.service;

import com.example.springboot.dao.BaseDao;

import java.io.Serializable;

public interface BaseService<Dao extends BaseDao, T extends Serializable,ID extends Number> {
   T findById(ID id);
}
