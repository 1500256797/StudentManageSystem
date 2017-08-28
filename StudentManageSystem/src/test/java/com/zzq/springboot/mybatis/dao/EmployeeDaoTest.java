package com.zzq.springboot.mybatis.dao;

import com.zzq.springboot.mybatis.domain.Employee;
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
public class EmployeeDaoTest {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DeptDao deptDao;
    @Autowired
    private JobDao jobDao;
    @Test
    public void count() throws Exception {
    }

    @Test
    public void selectByPage() throws Exception {
    }

    @Test
    public void save() throws Exception {
        Employee employee = new Employee();
        employee.setAddress("陕西省安康市");
        employee.setCardId("6172");
        employee.setEducation("本科毕业");
        employee.setEmail("1500256797@qq.com");
        employee.setHobby("打篮球，踢足球");
        employee.setName("张强");
        employee.setParty("共青团员");
        employee.setPhone("18392613319");
        employee.setPostCode("725771");
        employee.setQqNum("1500256797");
        employee.setRace("参加过所有比赛");
        employee.setRemark("很帅，很酷");
        employee.setSex(1);
        employee.setSpeciality("编码 数据结构与算法");

        employee.setDept(deptDao.selectById(4));
        employee.setJob(jobDao.selectById(4));
        employeeDao.save(employee);

    }

    @Test
    public void deleteById() throws Exception {

    }

    @Test
    public void selectById() throws Exception {
        Employee employee = employeeDao.selectById(1);
        System.out.println(employee.toString());
    }

    @Test
    public void update() throws Exception {
        Employee employee = new Employee();
        employee.setId(2);
        employee.setRace("汉");
        employeeDao.update(employee);

    }

}