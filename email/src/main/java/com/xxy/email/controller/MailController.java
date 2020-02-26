package com.xxy.email.controller;

import com.xxy.email.service.MailService;
import com.xxy.email.vo.MailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * author:胡小宇
 * Date:2020年2月26日 17:15:23
 */
@RestController
public class MailController {

    @Autowired
    private MailService mailService;


    //跳转首页
    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("mail/sendMail");
        mv.addObject("from", mailService.getMailSendFrom());
        return mv;
    }

    //发送短信
    @PostMapping("/mail/send")
    public MailVo sendMail(MailVo mailVo, MultipartFile[] files) {
        mailVo.setMultipartFiles(files);
        return mailService.sendMail(mailVo);
    }
}
