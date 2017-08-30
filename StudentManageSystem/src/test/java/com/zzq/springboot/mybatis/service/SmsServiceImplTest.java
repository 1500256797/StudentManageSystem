package com.zzq.springboot.mybatis.service;

import com.zzq.springboot.mybatis.domain.Dept;
import com.zzq.springboot.mybatis.domain.Employee;
import com.zzq.springboot.mybatis.domain.Job;
import com.zzq.springboot.mybatis.domain.User;
import com.zzq.springboot.mybatis.util.tag.PageModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by qqqqqqq on 17-8-29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SmsServiceImplTest {
    @Autowired
    @Qualifier("SmsService")
    private SmsService smsService;

    @Test
    public void login() throws Exception {
        User user = smsService.login("11111111", "123123");
        System.out.println(user.toString());
    }


    @Test
    public void findUserById() throws Exception {
        User user = smsService.findUserById(1);
        System.out.println(user.toString());

    }

    @Test
    public void findUser() throws Exception {

    }

    @Test
    public void removeUserById() throws Exception {
    }

    @Test
    public void modifyUser() throws Exception {
        User user = new User();
        user.setLoginname("2222222");
        user.setId(5);
        smsService.modifyUser(user);

    }

    @Test
    public void addUser() throws Exception {
        User user = new User();
        user.setUsername("黄");
        user.setLoginname("11111111");
        user.setPassword("123123");
        user.setStatus(2);
        smsService.addUser(user );
    }

    @Test
    public void findEmployee() throws Exception {
    }

    @Test
    public void removeEmployeeById() throws Exception {
        Employee employee = smsService.findEmployeeById(1);
        System.out.println(employee.toString());
    }

    @Transactional
    @Test
    public void findEmployeeById() throws Exception {
        Employee employee = smsService.findEmployeeById(2);
        System.out.println(employee.toString());
    }

    @Test
    public void addEmployee() throws Exception {
    }

    @Test
    public void modifyEmployee() throws Exception {
    }

    @Test
    public void findDept() throws Exception {
    }

    @Test
    public void findAllDept() throws Exception {
    }

    @Test
    public void removeDeptById() throws Exception {
    }

    @Test
    public void addDept() throws Exception {
        Dept dept = new Dept();
        dept.setName("广告部门");
        dept.setRemark("广告部门发广告");
        smsService.addDept(dept);

    }

    @Test
    public void findDeptById() throws Exception {
        Dept dept = smsService.findDeptById(1);
        System.out.println(dept.toString());
    }

    @Test
    public void modifyDept() throws Exception {
    }

    @Test
    public void findAllJob() throws Exception {
        List<Job> jobs = smsService.findAllJob();
        for (Job job : jobs) {
            System.out.println(job.toString());
        }
    }

    @Test
    public void findJob() throws Exception {
        Job job = new Job();
        PageModel pageModel = new PageModel();
        List<Job> jobs = smsService.findJob(job, pageModel);
        for (Job job1 : jobs) {
            System.out.println(job1.toString());
        }
    }

    @Test
    public void removeJobById() throws Exception {
    }

    @Test
    public void addJob() throws Exception {
        Job job = new Job();
        job.setName("团支书");
        job.setRemark("团支书负责开会");
        smsService.addJob(job);

    }

    @Test
    public void findJobById() throws Exception {
    }

    @Test
    public void modifyJob() throws Exception {
    }

    @Test
    public void findNotice() throws Exception {

    }

    @Test
    public void findNoticeById() throws Exception {
    }

    @Test
    public void removeNoticrById() throws Exception {
    }

    @Test
    public void addNotice() throws Exception {
    }

    @Test
    public void modifyNotice() throws Exception {
    }

    @Test
    public void findDocument() throws Exception {
    }

    @Test
    public void addDocument() throws Exception {
    }

    @Test
    public void findDocumentById() throws Exception {
    }

    @Test
    public void removeDocumentById() throws Exception {
    }

    @Test
    public void modifyDocument() throws Exception {
    }

}