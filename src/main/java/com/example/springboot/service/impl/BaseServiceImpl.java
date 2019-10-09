package com.example.springboot.service.impl;

import com.example.springboot.dao.BaseDao;
import com.example.springboot.pojo.BasePojo;
import com.example.springboot.service.BaseService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@NoRepositoryBean
abstract class BaseServiceImpl<T extends Serializable , ID extends Number,Dao extends BaseDao<T,ID>> implements BaseService<T,ID,Dao> {


    /** 实体类类型 */
    private Class<T> clazz;

    abstract public Dao getDao();

    @Override
    public T findById(ID id) {
        Optional<T> optional = getDao().findById(id);
        return (T) optional.get();
    }

    public BaseServiceImpl() {
        // 使用反射技术得到T的真实类型
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass(); // 获取当前new的对象的 泛型的父类 类型
        this.clazz = (Class<T>) pt.getActualTypeArguments()[0]; // 获取第一个类型参数的真实类型
        System.out.println("-------------------------------clazz ------------------------------------> " + clazz);
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
         return  getDao().save(t);
    }
    @Override
    public T save(T t){
          return  getDao().save(t);
    }

    @Override
    public void del(ID id){
          getDao().deleteById(id);
    }






}
