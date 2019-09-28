package com.example.springboot.pojo;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoRepositoryBean
public class BasePojo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "create_date")
    private java.util.Date createDate;

    @Column(name = "update_date")
    private java.util.Date updateDate;


}
