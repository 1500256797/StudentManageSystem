package com.zzq.springboot.mybatis.util;

/**
 * hrmConstants 定义了本系统使用的常量
 * Created by qqqqqqq on 17-7-25.
 */
public class HrmConstants {
    //数据库表常量
    public static final String USERTABLE = "user_inf";
    public static final String DEPTTABLE = "dept_inf";
    public static final String JOBTABLE = "job_inf";
    public static final String EMPLOYEETABLE = "employee_inf";
    public static final String NOTICETABLE = "notice_inf";
    public static final String DOCUMENTTABLE = "document_inf";

    //登陆
    public static final String LOGIN = "loginForm";
    //用户的session 对象
    public static final String USER_SESSION = "user_session";

    //默认每页4条数据
    public static final int PAGE_DEFAULT_SIZE = 4;
}
