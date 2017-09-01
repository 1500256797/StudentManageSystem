package com.zzq.springboot.mybatis.controller;


import com.zzq.springboot.mybatis.domain.User;
import com.zzq.springboot.mybatis.service.SmsService;
import com.zzq.springboot.mybatis.util.tag.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

import java.util.List;

import static com.zzq.springboot.mybatis.util.HrmConstants.USER_SESSION;

/**
 * 处理用户请求控制器
 * Created by qqqqqqq on 17-8-29.
 */
@RestController
public class UserController {

    //自动注入service
    @Autowired
    @Qualifier("SmsService")
    private SmsService smsService;

    //处理登陆请求
    @RequestMapping(value = "/login")
    public ModelAndView login(@RequestParam("loginname") String loginname,
                              @RequestParam("password") String password,
                              HttpSession session,
                              ModelAndView mv) {

        //调用业务逻辑组件判断用户是否可以登陆
        User user = smsService.login(loginname, password);
        if (user != null) {
            //将用户保存到HttpSession
            session.setAttribute(USER_SESSION, user);
            //客户端跳转到main页面
            mv.setViewName("redirect:/main");
        } else {
            //设置登陆失败提示信息
            mv.addObject("message", "用户名或密码错误！");
            //服务器内部跳转到登陆页面
            mv.setViewName("redirect:/loginForm");

        }
        return mv;
    }

    //处理查询请求
    @RequestMapping(value = "/user/selectUser")
    public String selectUser(Integer pageIndex,
                             @ModelAttribute User user,
                             Model model) {
        System.out.println("user = " + user);
        PageModel pageModel = new PageModel();
        if (pageIndex != null) {
            pageModel.setPageIndex(pageIndex);

        }
        //查询用户信息
        List<User> users = smsService.findUser(user, pageModel);
        model.addAttribute("users", users);
        model.addAttribute("pageModel", pageModel);
        return "user/user";
    }

    //处理删除用户请求
    @RequestMapping(value = "/user/removeUser")
    public ModelAndView removeUser(String ids, ModelAndView modelAndView) {

        //分解id字符串
        String[] idArray = ids.split(",");
        for (String id : idArray) {
            //根据id删除  把带引号数字变成正常数字
            smsService.removeUserById(Integer.parseInt(id));

        }
        //设置客户端跳转到查询请求
        modelAndView.setViewName("redirect:/user/SelectUser");
        //返回mv
        return modelAndView;
    }

    //处理修改用户请求  flag 1表示跳转到修改页面 2 执行修改操作
    @RequestMapping(value = "/user/updateUser")
    public ModelAndView updateUser(String flag,
                                   @ModelAttribute User user,
                                   ModelAndView modelAndView) {

        if (flag.equals("1")) {
            //根据id查询用户
            User user1 = smsService.findUserById(user.getId());
            //设置Model数据
            modelAndView.addObject("user", user1);
            //返回修改员工页面
            modelAndView.setViewName("user/showUpdateUser");
        } else {
            //执行修改操作
            smsService.modifyUser(user);

            //设置客户端跳转到查询请求
            modelAndView.setViewName("redirect:/user/selectUser");
        }

        return modelAndView;
    }

    //处理添加请求  flag  1表示跳转到添加页面 2表示执行添加操作
    public ModelAndView addUser(String flag,
                                @ModelAttribute User user,
                                ModelAndView modelAndView) {
        if (flag.equals("1")) {
            //跳转到添加页面
            modelAndView.setViewName("user/showAddUser");

        } else {
            //执行添加操作
            smsService.addUser(user);
            //设置客户端跳转到查询请求
            modelAndView.setViewName("redirect:/user/selectUser");
        }
        return modelAndView;
    }

}
