package com.zzq.springboot.mybatis.dao;


import com.zzq.springboot.mybatis.domain.Document;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.zzq.springboot.mybatis.util.HrmConstants.DOCUMENTTABLE;

/**
 * Created by qqqqqqq on 17-8-22.
 */
@Mapper
public interface DocumentDao {
    //动态查询
    @SelectProvider(type = DocumentDynaSqlProvider.class, method = "selectWithParam")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "CREATE_DATE", property = "createDate", javaType = Date.class),
            @Result(column = "USER_ID", property = "user", one = @One(select = "com.zzq.springboot.mybatis.dao.UserDao.selectById", fetchType = FetchType.EAGER))
    })
    List<Document> selectByPage(Map<String, Object> params);


    @SelectProvider(type = DocumentDynaSqlProvider.class, method = "count")
    Integer count(Map<String, Object> params);

    //动态插入文档
    @SelectProvider(type = DocumentDynaSqlProvider.class, method = "insertDocument")
    void save(Document document);

    @Select("select * from " + DOCUMENTTABLE + "where ID =#{id}")
    Document selectById(int id);

    //根据id删除文档
    @Delete("delete from" + DOCUMENTTABLE + "where id =#{id}")
    void deleteById(Integer id);

    //动态修改文档
    @SelectProvider(type = DocumentDynaSqlProvider.class, method = "updateDocument")
    void update(Document document);


}

