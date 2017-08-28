package com.zzq.springboot.mybatis.dao;


import com.zzq.springboot.mybatis.domain.Notice;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.zzq.springboot.mybatis.util.HrmConstants.NOTICETABLE;

/**
 * Created by qqqqqqq on 17-8-22.
 */
@Mapper
public interface NoticeDao {
    //动态查询
    @SelectProvider(type = NoticeDynaSqlProvider.class, method = "selectWithParam")
    @Results(
            value = {
                    @Result(id = true, column = "id", property = "id"),
                    @Result(column = "CREATE_DATE", property = "createDate", javaType = Date.class),
                    @Result(column = "USER_ID", property = "user", one = @One(select = "com.zzq.springboot.mybatis.dao.UserDao.selectById", fetchType = FetchType.EAGER))

            }
    )
    List<Notice> selectByPage(Map<String, Object> params);


    @SelectProvider(type = NoticeDynaSqlProvider.class, method = "count")
    Integer count(Map<String, Object> params);

    @Select("select * from " + NOTICETABLE + " where ID =#{id}")
    Notice SelectById(int id);

    //根据id删除
    @Delete("delete from " + NOTICETABLE + " where id =#{id}")
    void deleteById(Integer id);

    //动态插入公告
    @SelectProvider(type = NoticeDynaSqlProvider.class, method = "insertNotice")
    void save(Notice notice);

    //动态修改公告
    @SelectProvider(type = NoticeDynaSqlProvider.class, method = "updateNotice")
    void update(Notice notice);


}
