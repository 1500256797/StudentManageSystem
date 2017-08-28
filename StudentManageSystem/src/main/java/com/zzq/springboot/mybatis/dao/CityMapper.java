package com.zzq.springboot.mybatis.dao;

/**
 * Created by qqqqqqq on 17-8-23.
 */
//mapper注解

import com.zzq.springboot.mybatis.domain.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author Eddú Meléndez
 */
@Mapper
public interface CityMapper {

    @Select("select * from city where state = #{state}")
    City findByState(@Param("state") String state);

}
