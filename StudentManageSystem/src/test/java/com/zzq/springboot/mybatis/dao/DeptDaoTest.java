package com.zzq.springboot.mybatis.dao;

import com.zzq.springboot.mybatis.domain.Dept;
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
public class DeptDaoTest {
    @Autowired
    private  DeptDao deptDao;
    @Test
    public void selectByPage() throws Exception {
    }

    @Test
    public void count() throws Exception {
    }

    @Test
    public void selectAllDept() throws Exception {

    }

    @Test
    public void selectById() throws Exception {
        Dept dept =deptDao.selectById(1);
        System.out.println(dept.toString());
    }

    @Test
    public void deleteById() throws Exception {
    }

    @Test
    public void save() throws Exception {
        Dept dept = new Dept();
        dept.setName("研发部");
        dept.setRemark("研发部门是个好部门");
        deptDao.save(dept);

    }

    @Test
    public void update() throws Exception {

    }

}