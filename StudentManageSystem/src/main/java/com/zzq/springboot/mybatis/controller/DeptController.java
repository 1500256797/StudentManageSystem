package com.zzq.springboot.mybatis.controller;

import com.zzq.springboot.mybatis.domain.Dept;
import com.zzq.springboot.mybatis.service.SmsService;
import com.zzq.springboot.mybatis.util.tag.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by qqqqqqq on 17-9-1.
 */
@RestController
public class DeptController {
    //自动注入
    @Autowired
    @Qualifier("SmsService")
    private SmsService smsService;


    //处理login请求
    @RequestMapping(value = "/dept/selectDept")
    public String selectDept(Model model, Integer pageIndex, @ModelAttribute Dept dept) {
        PageModel pageModel = new PageModel();
        if (pageIndex != null) {
            pageModel.setPageIndex(pageIndex);
        }
        //查询用户信息
        List<Dept> depts = smsService.findDept(dept, pageModel);
        model.addAttribute("depts", depts);
        model.addAttribute("pageModel", pageModel);
        return "dept/dept";
    }

    //处理删除部门请求
    @RequestMapping(value = "/dept/removeDept")
    public ModelAndView removeDept(String ids, ModelAndView modelAndView) {
        //分解字符串
        String[] idArray = ids.split(",");
        for (String id : idArray) {
            //根据id删除部门
            smsService.removeDeptById(Integer.parseInt(id));

        }
        //设置客户端跳转到查询请求
        modelAndView.setViewName("redirect:/dept/selectDept");
        //返回mv
        return modelAndView;
    }

    //处理添加请求  flag  1 表示跳转到添加页面  2 表示执行添加操作
    @RequestMapping(value = "/dept/addDept")
    public ModelAndView addDept(String flag,
                                @ModelAttribute Dept dept,
                                ModelAndView modelAndView) {
        if (flag.equals("1")) {
            //设置跳转到添加页面
            modelAndView.setViewName("dept/showAddDept");
        } else {
            //执行添加操作
            smsService.addDept(dept);
            //设置客户端跳转到查询请求
            modelAndView.setViewName("redirect:/dept/selectDept");

        }
        return modelAndView;
    }

    //处理修改部门请求  flag 1 表示跳转到页面  2 表示执行操作
    @RequestMapping(value = "/dept/updateDept")
    public ModelAndView updateDept(String flag,
                                   @ModelAttribute Dept dept,
                                   ModelAndView modelAndView) {
        if (flag.equals("1")) {
            //根据id查询部门
            Dept dept1 = smsService.findDeptById(dept.getId());
            //设置model数据
            modelAndView.addObject("dept", dept1);
            //设置跳转到修改页面
            modelAndView.setViewName("dept/showUpdateDept");

        } else {
            //执行修改操作
            smsService.modifyDept(dept);
            //设置客户端跳转到查询请求
            modelAndView.setViewName("redirect:/dept/selectDept");

        }
        return modelAndView;
    }
}
