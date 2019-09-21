package com.example.springboot.service.impl;

import com.example.springboot.dao.BaseDao;
import com.example.springboot.service.BaseService;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Optional;

//@NoRepositoryBean
abstract class BaseServiceImpl<Dao extends BaseDao,T extends Serializable, ID extends Number>  implements BaseService<Dao ,T ,ID>{


   abstract public Dao getDao();

    @Override
    public T findById(ID id) {
        Optional<T> optional=  getDao().findById(id);
        return (T) optional.get();
    }

    public T findBy


}
