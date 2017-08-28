package com.zzq.springboot.mybatis.dao;

import com.zzq.springboot.mybatis.domain.User;
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
public class UserDaoTest {

    @Autowired
    private UserDao userDao;
    @Test
    public void selectByLoginnameAndPassword() throws Exception {
    }

    @Test
    public void selectById() throws Exception {
        User user = userDao.selectById(1);

        System.out.println(user.toString());
    }

    @Test
    public void deleteById() throws Exception {
        userDao.deleteById(2);

    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void selectBypage() throws Exception {
    }

    @Test
    public void count() throws Exception {
    }

    @Test
    public void save() throws Exception {
        User user = new User();
        user.setUsername("张三");
        user.setLoginname("123456");
        user.setPassword("1212313");
        user.setStatus(1);
        userDao.save(user);

    }

}