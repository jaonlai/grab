package com.example.springboot.pojo;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "user")
public class User extends BasePojo implements Serializable {

    public interface Login {
    }

    public interface Create {
    }

    public interface Default {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String account;

    @NotNull(message = "用户名不能为空", groups = Create.class)
	@NotNull(message = "用户名不能为空", groups = Login.class)
    @NotNull(message = "用户名不能为空", groups = Default.class)
    private String name;
    @NotNull(message = "密码不能为空", groups = Create.class)
	@NotNull(message = "密码不能为空", groups = Login.class)
    @NotNull(message = "用户名不能为空", groups = Default.class)
    private String pwd;

    private String token;

    @Column(name = "create_date")
    private java.util.Date createDate;

    @Column(name = "update_date")
    private java.util.Date updateDate;

    private String slat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getSlat() {
        return slat;
    }

    public void setSlat(String slat) {
        this.slat = slat;
    }
}
