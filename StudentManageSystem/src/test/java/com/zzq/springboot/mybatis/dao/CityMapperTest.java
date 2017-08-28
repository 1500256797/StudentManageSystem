package com.zzq.springboot.mybatis.dao;

import com.zzq.springboot.mybatis.domain.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by qqqqqqq on 17-8-23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CityMapperTest {
    @Autowired
    private CityMapper cityMapper;


    @Test
    public void findByState() throws Exception {
        City city = cityMapper.findByState("CA");
        System.out.println("输出日志：");
        System.out.println(city.toString());

    }

}