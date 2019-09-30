package com.example.springboot.service.impl;

import com.example.springboot.dao.BaseDao;
import com.example.springboot.service.BaseService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@NoRepositoryBean
abstract class BaseServiceImpl<Dao extends BaseDao, T extends Serializable, ID extends Number> implements BaseService<Dao, T, ID> {


    abstract public Dao getDao();

    @Override
    public T findById(ID id) {
        Optional<T> optional = getDao().findById(id);
        return (T) optional.get();
    }

    @Override
    public List<T> findAll() {
        return getDao().findAll();
    }

    @Override
    public List<T> findBySpecification(Specification<T> spc, Pageable pageable) {

        return null;
    }
    @Override
    public T add(T t){
         return (T) getDao().save(t);
    }
    @Override
    public T save(T t){
        return (T) getDao().save(t);
    }

    @Override
    public void del(ID id){
          getDao().deleteById(id);
    }






}
