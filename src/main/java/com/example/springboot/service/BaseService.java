package com.example.springboot.service;

import com.example.springboot.dao.BaseDao;
import com.example.springboot.pojo.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T extends Serializable,ID extends Number,dao extends BaseDao<T,ID>> {



   /**
    * 根据主键查找
    * @param id
    * @return
    */
   T findById(ID id);

   /**
    * 查看全部数据
    * @return
    */
   List<T> findAll();

   /**
    * 多条件查找
    * @param spc
    * @param pageable
    * @return
    */
   List<T> findBySpecification(Specification<T> spc, Pageable pageable);

   /**
    * 添加
    * @param t
    * @return
    */
   T  add(T t);

   /**
    *删除
    * @param id
    * @return
    */
   void del(ID id);

   /**
    * 更新
    * @param t
    * @return
    */
   T save(T t);



}
