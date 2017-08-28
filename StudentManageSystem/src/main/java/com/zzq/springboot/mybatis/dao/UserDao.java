package com.zzq.springboot.mybatis.dao;


import com.zzq.springboot.mybatis.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

import static com.zzq.springboot.mybatis.util.HrmConstants.USERTABLE;

/**
 * 为dmain对象定义Dao接口（crub操作）
 * Created by qqqqqqq on 17-7-25.
 */
@Mapper
public interface UserDao {

    //根据登录名 和密码查询员工
    @Select("select *from " + USERTABLE + " where loginname = #{loginname} and password = #{password}")
    User selectByLoginnameAndPassword(
            @org.apache.ibatis.annotations.Param("loginname") String loginname,
            @org.apache.ibatis.annotations.Param("password") String password
    );

    //根据id查询用户
    @Select(" select * from "+USERTABLE+" where id = #{id}")
    User selectById(Integer id);

    //根据id删除
    @Delete("delete from    " + USERTABLE + "   where id = #{id}")
    void deleteById(Integer id);

    //动态修改用户
    @SelectProvider(type = UserDynaSqlProvider.class, method = "updateUser")
    void update(User user);

    //动态查询
    @SelectProvider(type = UserDynaSqlProvider.class, method = "selectWithParam")
    List<User> selectBypage(Map<String, Object> params);


    //根据参数查询用户总数
    @SelectProvider(type = UserDynaSqlProvider.class, method = "count")
    Integer count(Map<String, Object> params);

    //动态插入用户
    @SelectProvider(type = UserDynaSqlProvider.class, method = "insertUser")
    void save(User user);
}
