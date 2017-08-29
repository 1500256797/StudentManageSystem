package com.zzq.springboot.mybatis.dao;


import com.zzq.springboot.mybatis.domain.Job;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

import static com.zzq.springboot.mybatis.util.HrmConstants.JOBTABLE;

/**
 * Created by qqqqqqq on 17-7-25.
 */
@Mapper
public interface JobDao {
    @Select("select * from " + JOBTABLE + " where ID = #{id}")
    Job selectById(int id);

    @Select("select * from " + JOBTABLE + " ")
    List<Job> selectAllJob();

    @SelectProvider(type = JobDynaSqlProvider.class, method = "selectWithParam")
    List<Job> selectBypage(Map<String, Object> params);

    @SelectProvider(type = JobDynaSqlProvider.class, method = "count")
    Integer count(Map<String, Object> params);


    //删除
    @Delete("delete from " + JOBTABLE + " where id = #{id}")
    void deleteById(Integer id);


    //动态插入
    @SelectProvider(type = JobDynaSqlProvider.class, method = "insertJob")
    void save(Job job);

    //动态修改部门
    @SelectProvider(type = JobDynaSqlProvider.class, method = "updateJob")
    void update(Job job);




}
