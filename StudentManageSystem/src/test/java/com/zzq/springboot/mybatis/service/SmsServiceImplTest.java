package com.zzq.springboot.mybatis.service;

import com.zzq.springboot.mybatis.domain.Dept;
import com.zzq.springboot.mybatis.domain.Employee;
import com.zzq.springboot.mybatis.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

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
    }

    @Test
    public void addUser() throws Exception {
    }

    @Test
    public void findEmployee() throws Exception {
    }

    @Test
    public void removeEmployeeById() throws Exception {
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
    }

    @Test
    public void findJob() throws Exception {
    }

    @Test
    public void removeJobById() throws Exception {
    }

    @Test
    public void addJob() throws Exception {
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