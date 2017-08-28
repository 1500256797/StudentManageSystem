package com.zzq.springboot.mybatis.dao;

import com.zzq.springboot.mybatis.domain.Job;
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
public class JobDaoTest {
    @Autowired
    private JobDao jobDao;
    @Test
    public void selectById() throws Exception {
        Job job = jobDao.selectById(1);
        System.out.println(job.toString());
    }


    @Test
    public void selectAllJob() throws Exception {
    }

    @Test
    public void selectBypage() throws Exception {
    }

    @Test
    public void count() throws Exception {
    }

    @Test
    public void deleteById() throws Exception {
    }

    @Test
    public void save() throws Exception {
        Job job = new Job();
        job.setName("老板");
        job.setRemark("老板给人发薪水");
        jobDao.save(job);
    }

    @Test
    public void update() throws Exception {
        Job job = new Job();
        job.setId(1);
        job.setName("职员");
        job.setRemark("别人给他发薪水");
        jobDao.update(job);

    }

}