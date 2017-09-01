package com.zzq.springboot.mybatis.controller;

import com.zzq.springboot.mybatis.domain.Job;
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
public class JobController {
    @Autowired
    @Qualifier("SmsService")
    private SmsService smsService;


    @RequestMapping(value = "/job/selectJob")
    public String selectJob(Model model,
                            Integer pageIndex,
                            @ModelAttribute Job job) {
        PageModel pageModel = new PageModel();
        if (pageIndex != null) {
            pageModel.setPageIndex(pageIndex);

        }
        List<Job> jobs = smsService.findJob(job, pageModel);
        model.addAttribute("jobs", jobs);
        model.addAttribute("pageModel", pageModel);
        return "job/job";
    }

    @RequestMapping(value = "/job/removeJob")
    public ModelAndView removeJob(String ids,
                                  ModelAndView modelAndView) {
        String[] idArray = ids.split(",");
        for (String id : idArray) {
            smsService.removeJobById(Integer.parseInt(id));

        }
        modelAndView.setViewName("redirect:/job/selcetJob");
        return modelAndView;
    }


    @RequestMapping(value = "/job/addJob")
    public ModelAndView addJob(String flag,
                               @ModelAttribute Job job,
                               ModelAndView modelAndView) {
        if (flag.equals("1")) {
            modelAndView.setViewName("job/showAddJob");

        } else {
            smsService.addJob(job);
            modelAndView.setViewName("redirect:/job/selcetJob");

        }
        return modelAndView;
    }


    @RequestMapping(value = "/job/updateJob")
    public ModelAndView updateDept(String flag,
                                   @ModelAttribute Job job,
                                   ModelAndView modelAndView) {
        if (flag.equals("1")) {
            Job job1 = smsService.findJobById(job.getId());
            modelAndView.addObject("job", job1);
            modelAndView.setViewName("job/showUpdateJob");

        } else {
            smsService.modifyJob(job);
            modelAndView.setViewName("redirect:/job/selectJob");

        }
        return modelAndView;
    }
}
