package com.zzq.springboot.mybatis.service;

import com.zzq.springboot.mybatis.domain.*;
import com.zzq.springboot.mybatis.util.tag.PageModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by qqqqqqq on 17-8-29.
 */
@Component
public interface SmsService {
    //用户登陆
    User login(String loginname, String password);

    //id查询
    @Transactional
    User findUserById(Integer id);

    //所有
    List<User> findUser(User user, PageModel pageModel);

    //id 删除
    void removeUserById(Integer id);

    //修改
    void modifyUser(User user);

    //add
    void addUser(User user);

    //员工获取
    List<Employee> findEmployee(Employee employee, PageModel pageModel);

    //remove
    void removeEmployeeById(Integer id);

    //find id
    Employee findEmployeeById(Integer id);

    //add
    void addEmployee(Employee employee);

    //modify
    void modifyEmployee(Employee employee);

    //dept find
    List<Dept> findDept(Dept dept, PageModel pageModel);

    //
    List<Dept> findAllDept();

    //remove
    void removeDeptById(Integer id);

    //add
    void addDept(Dept dept);

    //find by id
    Dept findDeptById(Integer id);

    //modify
    void modifyDept(Dept dept);

    //findalljob
    List<Job> findAllJob();

    //
    List<Job> findJob(Job job, PageModel pageModel);

    //remove by id

    void removeJobById(Integer id);

    //add
    void addJob(Job job);


    //find job by  id
    Job findJobById(Integer id);

    //modify
    void modifyJob(Job job);

    //find all notice
    List<Notice> findNotice(Notice notice, PageModel pageModel);

    //find notice id
    Notice findNoticeById(Integer id);

    //remove
    void removeNoticrById(Integer id);

    //add
    void addNotice(Notice notice);

    //modify
    void modifyNotice(Notice notice);

    //find document
    List<Document> findDocument(Document document, PageModel pageModel);

    //add
    void addDocument(Document document);

    //find document id
    Document findDocumentById(Integer id);

    //remove
    void removeDocumentById(Integer id);

    //modify
    void modifyDocument(Document document);

}
