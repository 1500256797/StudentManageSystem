package com.zzq.springboot.mybatis.controller;

import com.zzq.springboot.mybatis.domain.Employee;
import com.zzq.springboot.mybatis.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qqqqqqq on 17-9-1.
 */
@RestController
public class EmployeeController {
    @Autowired
    @Qualifier("SmsService")
    private SmsService smsService;

    public String selectEmployee(Integer pageIndex,
                                 Integer job_id,
                                 Integer dept_id,
                                 @ModelAttribute Employee employee,
                                 Model model) {

        return "ddf";
    }

}
