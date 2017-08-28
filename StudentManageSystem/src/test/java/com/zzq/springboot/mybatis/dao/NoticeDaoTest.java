package com.zzq.springboot.mybatis.dao;

import com.zzq.springboot.mybatis.domain.Notice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by qqqqqqq on 17-8-23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class NoticeDaoTest {
    @Autowired
    private NoticeDao noticeDao;
    @Autowired
    private UserDao userDao;
    @Test
    public void selectByPage() throws Exception {
    }

    @Test
    public void count() throws Exception {
    }

    @Test
    public void selectById() throws Exception {
        Notice notice = noticeDao.SelectById(1);
        System.out.println(notice.toString());
    }

    @Test
    public void deleteById() throws Exception {
    }

    @Test
    public void save() throws Exception {
        Notice notice = new Notice();
        notice.setTitle("放假通知");
        notice.setContent("西安科技大学于28号正式开学");
        notice.setUser(userDao.selectById(1));
        noticeDao.save(notice);

    }

    @Test
    public void update() throws Exception {
        Notice notice = new Notice();
        notice.setId(1);
        notice.setContent("原本是28开学，但校长说，不想来的可以不来");
        noticeDao.update(notice);
    }

}