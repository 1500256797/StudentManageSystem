package com.zzq.springboot.mybatis.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by qqqqqqq on 17-7-25.
 */
public class Notice implements Serializable {
    private Integer id;
    private String title;
    private String content;
    private Date createDate;
    private User user;

    public Notice() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                ", user=" + user +
                '}';
    }
}
