package com.zzq.springboot.mybatis.domain;

import java.io.Serializable;

/**
 * Created by qqqqqqq on 17-7-25.
 */
public class Dept implements Serializable {
    private Integer id;
    private String name;//部门好
    private String remark; //详细描述

    public Dept() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
