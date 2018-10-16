package com.yui.system.myemail.com.yui.system.myemail.service;

import com.yui.system.myemail.entity.EmailEntity;
import com.yui.system.myemail.service.EmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author XuZhuohao
 * @date 2018/10/16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailServiceTest {
    @Autowired
    EmailService emailService;

    @Value("${spring.mail.username}")
    private String from;

    @Test
    public void testSendEmail(){
        String iamgeid01 = "t1";
        String iamgeid02 = "t2";
        String content = "<html><body><h1>图片发送</h1><p></p><img src='cid:" + iamgeid01 + "'></img>" +
                "<img src='cid:" + iamgeid02 + "'></img></body></html>";
        EmailEntity emailEntity = new EmailEntity();
        emailEntity.setFrom(from);
        emailEntity.setTo(from);
        emailEntity.setContent(content);
        emailEntity.setImages("t1&D:\\data\\t1.jpg,t2&D:\\data\\t2.gif");
        emailEntity.setFiles("file1&D:\\data\\t1.jpg,file2&D:\\data\\t1.jpg");
        emailEntity.setSubject("邮件发送测试");
        emailService.sendEmail(emailEntity);
    }
}
