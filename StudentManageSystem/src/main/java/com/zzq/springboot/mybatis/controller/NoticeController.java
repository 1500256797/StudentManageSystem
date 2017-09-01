package com.zzq.springboot.mybatis.controller;

import com.zzq.springboot.mybatis.domain.Notice;
import com.zzq.springboot.mybatis.domain.User;
import com.zzq.springboot.mybatis.service.SmsService;
import com.zzq.springboot.mybatis.util.tag.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

import static com.zzq.springboot.mybatis.util.HrmConstants.USER_SESSION;

/**
 * Created by qqqqqqq on 17-9-1.
 */
@RestController
public class NoticeController {
    @Autowired
    @Qualifier("SmsService")
    private SmsService smsService;

    //处理login请求
    @RequestMapping(value = "/notice/selectNotice")
    public String selectNotice(Model model, Integer pageIndex, @ModelAttribute Notice notice) {
        PageModel pageModel = new PageModel();
        if (pageIndex != null) {
            pageModel.setPageIndex(pageIndex);

        }
        //查询用户信息
        List<Notice> notices = smsService.findNotice(notice, pageModel);
        model.addAttribute("notices", notices);
        model.addAttribute("pageModel", pageModel);

        return "notice/notice";
    }

    //处理添加请求
    @RequestMapping(value = "/notice/previewNotice")
    public String previewNotice(Integer id,
                                Model model) {
        Notice notice = smsService.findNoticeById(id);
        model.addAttribute("notice", notice);
        return "notice/previewNotice";

    }

    //删除
    @RequestMapping(value = "/notice/removeNotice")
    public ModelAndView removeNotice(String ids, ModelAndView modelAndView) {
        //分解id
        String[] idArray = ids.split(",");
        for (String id : idArray) {
            smsService.removeNoticrById(Integer.parseInt(id));

        }
        modelAndView.setViewName("redirect:/notice/selectNotice");
        return modelAndView;

    }

    //添加
    @RequestMapping(value = "/notice/addNotice")
    public ModelAndView addNotice(String flag,
                                  @ModelAttribute Notice notice,
                                  ModelAndView modelAndView,
                                  HttpSession httpSession) {
        if (flag.equals("1")) {
            modelAndView.setViewName("notice/showAddNotice");

        } else {
            User user = (User) httpSession.getAttribute(USER_SESSION);
            notice.setUser(user);
            smsService.addNotice(notice);
            modelAndView.setViewName("redirect:/notice/selectNotice");

        }
        return modelAndView;
    }

    //修改
    @RequestMapping(value = "/notice/updateNotice")
    public ModelAndView updateNotice(String flag,
                                     @ModelAttribute Notice notice,
                                     ModelAndView modelAndView,
                                     HttpSession httpSession) {
        if (flag.equals("1")) {
            Notice notice1 = smsService.findNoticeById(notice.getId());
            modelAndView.addObject("notice ", notice1);
            modelAndView.setViewName("notice/showUpdateNotice");

        } else {
            smsService.modifyNotice(notice);
            modelAndView.setViewName("redirect:/notice/selectNotice");

        }
        return modelAndView;
    }
}
