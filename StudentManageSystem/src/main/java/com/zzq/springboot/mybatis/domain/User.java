package com.zzq.springboot.mybatis.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by qqqqqqq on 17-7-25.
 */
public class User implements Serializable {
    private Integer id;//id
    private String username;//Yong hu ming
    private String loginname;
    private String password;
    private Integer status;
    private Date createDate;

    //construttor
    public User() {
        super();
    }

    //getter setter


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", loginname='" + loginname + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", createDate=" + createDate +
                '}';
    }
}
