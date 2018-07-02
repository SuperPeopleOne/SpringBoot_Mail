package com.lenovo.controller;

import javax.annotation.Resource;

import com.lenovo.service.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Tookie
 * @date 2018-06-29
 * @version 1.0.0
 */
@RestController
@RequestMapping(value = "mail")
public class MailController {

    @Resource
    private MailService mailService;


    @Value("${spring.mail.host}")
    private String host;
    @Value("${spring.mail.username}")
    private String username;
    @Value("${spring.mail.password}")
    private String password;
    @Value("${spring.mail.encoding}")
    private String encoding;
    @Value("${spring.mail.port}")
    private Integer port;

    /**
     * Currently, only Text, HTML, and attachment mail content is supported,
     * and multiple people are allowed to send.
     * Please note to add commas when filling in multiple recipients
     *
     * @param to
     * @return
     */
    @RequestMapping(value = "sendHtml/{to}", method = RequestMethod.GET)
    public String sendHtml(@PathVariable String to) throws Exception{
        int status =0;
        status = mailService.getSendHtml(to,host,port,username,password,encoding);
        if (status==1){
            return "Send Mail Success";
        } else {
            return "Send Mail Failed";
        }
    }


    /**
     * Send Text Mail(History Test Demo)
     * @return
     */
    /*@RequestMapping(value = "sendText", method = RequestMethod.GET)
    public String sendText(){
        String content = "<table><tr><td>这是一封测试邮件</td></tr></table>";

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("13521459287@163.com");
        mailMessage.setTo("2568305472@qq.com");
        mailMessage.setSubject("这是测试主题");
        mailMessage.setText(content);

        javaMailSender.send(mailMessage);
        return "success";
    }*/


}
