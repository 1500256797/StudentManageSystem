package com.zzq.springboot.mybatis.service;

import com.zzq.springboot.mybatis.dao.*;
import com.zzq.springboot.mybatis.domain.*;
import com.zzq.springboot.mybatis.util.tag.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qqqqqqq on 17-8-29.
 */

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)

@Service("SmsService")
public class SmsServiceImpl implements SmsService {
    //依赖注入
    @Autowired
    private UserDao userDao;

    @Autowired
    private DeptDao deptDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private JobDao jobDao;

    @Autowired
    private NoticeDao noticeDao;

    @Autowired
    private DocumentDao documentDao;


    //××××××××××××××××××用户服务层接口实现

    @Override
    public User login(String loginname, String password) {
        System.out.println("login>>>>>>>>>>>>>>>>>>>>>>>>>>");
        return userDao.selectByLoginnameAndPassword(loginname,password);
    }

    @Override
    public User findUserById(Integer id) {
        return userDao.selectById(id);
    }

    @Override
    public List<User> findUser(User user, PageModel pageModel) {
        //当前需要分页的总数据条数
        Map<String, Object> params = new HashMap<>();
        params.put("user", user);
        int recordCount = userDao.count(params);
        pageModel.setRecordCount(recordCount);
        if (recordCount > 0) {
            //开始查询分页数据  查询第几页的数据
            params.put("pageModel", pageModel);
        }
        List<User> users = userDao.selectBypage(params);
        return users;
    }

    @Override
    public void removeUserById(Integer id) {
        userDao.deleteById(id);
    }

    @Override
    public void modifyUser(User user) {
        userDao.update(user);

    }

    @Override
    public void addUser(User user) {
        userDao.save(user);

    }

    @Override
    public List<Employee> findEmployee(Employee employee, PageModel pageModel) {
        //当前需要分页的总数据条数
        Map<String, Object> params = new HashMap<>();
        params.put("employee",employee);
        int recordCount = employeeDao.count(params);
        pageModel.setRecordCount(recordCount);
        if (recordCount > 0) {
            //开始查询分页数据  查询第几页的数据
            params.put("pageModel", pageModel);
        }
        List<Employee> employees  = employeeDao.selectByPage(params);
        return employees;

    }

    @Override
    public void removeEmployeeById(Integer id) {
        employeeDao.deleteById(id);
    }

    @Override
    public Employee findEmployeeById(Integer id) {
        return employeeDao.selectById(id);
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    public void modifyEmployee(Employee employee) {
        employeeDao.update(employee);
    }

    @Override
    public List<Dept> findDept(Dept dept, PageModel pageModel) {
        //当前需要分页的总数据条数
        Map<String, Object> params = new HashMap<>();
        params.put("dept", dept);
        int recordCount = deptDao.count(params);
        pageModel.setRecordCount(recordCount);
        if (recordCount > 0) {
            //开始查询分页数据  查询第几页的数据
            params.put("pageModel", pageModel);
        }
        List<Dept> depts = deptDao.selectByPage(params);
        return depts;
    }

    @Override
    public List<Dept> findAllDept() {
        return deptDao.selectAllDept();
    }

    @Override
    public void removeDeptById(Integer id) {
        deptDao.deleteById(id);

    }

    @Override
    public void addDept(Dept dept) {
        deptDao.save(dept);

    }

    @Override
    public Dept findDeptById(Integer id) {
        return deptDao.selectById(id);
    }

    @Override
    public void modifyDept(Dept dept) {
        deptDao.update(dept);
    }

    @Override
    public List<Job> findAllJob() {
        return jobDao.selectAllJob();
    }

    @Override
    public List<Job> findJob(Job job, PageModel pageModel) {
        //当前需要分页的总数据条数
        Map<String, Object> params = new HashMap<>();
        params.put("job",job);
        int recordCount = jobDao.count(params);
        pageModel.setRecordCount(recordCount);
        if (recordCount > 0) {
            //开始查询分页数据  查询第几页的数据
            params.put("pageModel", pageModel);
        }
        List<Job> jobs = jobDao.selectBypage(params);
        return jobs;
    }

    @Override
    public void removeJobById(Integer id) {
        jobDao.deleteById(id);

    }

    @Override
    public void addJob(Job job) {
        jobDao.save(job);
    }

    @Override
    public Job findJobById(Integer id) {
        return jobDao.selectById(id);
    }

    @Override
    public void modifyJob(Job job) {
        jobDao.update(job);
    }

    @Override
    public List<Notice> findNotice(Notice notice, PageModel pageModel) {
        //当前需要分页的总数据条数
        Map<String, Object> params = new HashMap<>();
        params.put("notice",notice);
        int recordCount = noticeDao.count(params);
        pageModel.setRecordCount(recordCount);
        if (recordCount > 0) {
            //开始查询分页数据  查询第几页的数据
            params.put("pageModel", pageModel);
        }
        List<Notice> notices = noticeDao.selectByPage(params);
        return notices;
    }

    @Override
    public Notice findNoticeById(Integer id) {
        return noticeDao.SelectById(id);
    }

    @Override
    public void removeNoticrById(Integer id) {
        noticeDao.deleteById(id);
    }

    @Override
    public void addNotice(Notice notice) {
        noticeDao.save(notice);
    }

    @Override
    public void modifyNotice(Notice notice) {
        noticeDao.update(notice);
    }

    @Override
    public List<Document> findDocument(Document document, PageModel pageModel) {
        //当前需要分页的总数据条数
        Map<String, Object> params = new HashMap<>();
        params.put("document",document);
        int recordCount = documentDao.count(params);
        pageModel.setRecordCount(recordCount);
        if (recordCount > 0) {
            //开始查询分页数据  查询第几页的数据
            params.put("pageModel", pageModel);
        }
        List<Document>  documents = documentDao.selectByPage(params);
        return documents;
    }

    @Override
    public void addDocument(Document document) {
        documentDao.save(document);
    }

    @Override
    public void findDocumentById(Integer id) {
        documentDao.selectById(id);
    }

    @Override
    public void removeDocumentById(Integer id) {
        documentDao.deleteById(id);
    }

    @Override
    public void modifyDocument(Document document) {
        documentDao.update(document);
    }
}
