package com.zzq.springboot.mybatis.controller;

import ch.qos.logback.core.util.FileUtil;
import com.zzq.springboot.mybatis.domain.Document;
import com.zzq.springboot.mybatis.domain.User;
import com.zzq.springboot.mybatis.service.SmsService;
import com.zzq.springboot.mybatis.util.tag.PageModel;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import static com.zzq.springboot.mybatis.util.HrmConstants.USER_SESSION;

/**
 * Created by qqqqqqq on 17-9-1.
 */
@RestController
public class DocumentController {
    @Autowired
    @Qualifier("SmsService")
    private SmsService smsService;

    @RequestMapping(value = "/document/selectDocument")
    public String selectDocument(Model model,
                                 Integer pageIndex,
                                 @ModelAttribute Document document) {
        PageModel pageModel = new PageModel();
        if (pageIndex != null) {
            pageModel.setPageIndex(pageIndex);

        }
        List<Document> documents = smsService.findDocument(document, pageModel);
        model.addAttribute("documents", documents);
        model.addAttribute("pageModel", pageModel);
        return "document/document";
    }

    //添加
    @RequestMapping(value = "/document/addDocument")
    public ModelAndView addDocumet(String flag,
                                   @ModelAttribute Document document,
                                   ModelAndView modelAndView,
                                   HttpSession httpSession) throws IOException {
        if (flag.equals("1")) {
            modelAndView.setViewName("document/showAddDocument");

        } else {
            //上传文件路径
            String path = httpSession.getServletContext().getRealPath("/upload");
            //上传文件名
            String fileName = document.getFile().getOriginalFilename();

            //将上传文件保存到一个目标文件中
            document.getFile().transferTo(new File(path + File.separator + fileName));
            //插入数据库  设置fileName
            document.setFileName(fileName);

            //设置关联的User对象
            User user = (User) httpSession.getAttribute(USER_SESSION);
            document.setUser(user);

            //返回
            modelAndView.setViewName("document/selectDocument");
        }
        return modelAndView;
    }


    //删除
    @RequestMapping(value = "/document/removeDocument")
    public ModelAndView removeDocument(String ids, ModelAndView modelAndView) {
        //分解ids
        String[] idArray = ids.split(",");
        for (String id : idArray) {
            //根据id删除
            smsService.removeDocumentById(Integer.parseInt(id));
        }
        modelAndView.setViewName("redirect:/document/selectDocument");
        return modelAndView;
    }

    //修改
    @RequestMapping(value = "/document/updateDocument")
    public ModelAndView updateDocument(String flag,
                                       @ModelAttribute Document document,
                                       ModelAndView modelAndView) {
        if (flag.equals(",")) {
            Document document1 = smsService.findDocumentById(document.getId());
            modelAndView.addObject("document", document1);
            modelAndView.setViewName("document/showUpdateDocument");

        } else {
            smsService.modifyDocument(document);
            modelAndView.setViewName("redirect:/document/selectDocument");

        }
        return modelAndView;
    }


    //文档下载
    @RequestMapping(value = "/document/download")
    public ResponseEntity<byte[]> download(Integer id,
                                           HttpSession httpSession) throws UnsupportedEncodingException {
        //根据id查询文档
        Document document = smsService.findDocumentById(id);
        String fileName = document.getFileName();
        //上传文件路径
        String path = httpSession.getServletContext().getRealPath("/upload");
        //获得要下载文件的File对象
        File file = new File(path + File.separator + fileName);
        //创建springFramework的Httpreaders对象
        HttpHeaders headers = new HttpHeaders();
        //下载现实的文件名
        String downloadName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");

        //通知浏览器打开图片
        headers.setContentDispositionFormData("attachment", downloadName);

        //设置二进制流下载
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);


        //201
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }
}
