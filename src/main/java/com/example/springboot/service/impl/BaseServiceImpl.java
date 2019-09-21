package com.example.springboot.service.impl;

import com.example.springboot.dao.BaseDao;
import com.example.springboot.service.BaseService;

import java.io.Serializable;

abstract class BaseServiceImpl<Dao extends BaseDao,T extends Serializable, ID extends Number>  implements BaseService<Dao ,T ,ID>{


   abstract public Dao getDao();

    @Override
    public T findById(ID id) {
        getDao().findById(id);
        return null;
    }


}
