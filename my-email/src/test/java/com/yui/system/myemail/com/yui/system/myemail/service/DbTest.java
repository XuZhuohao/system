package com.yui.system.myemail.com.yui.system.myemail.service;

import com.alibaba.fastjson.JSON;
import com.yui.system.myemail.entity.EmailEntity;
import com.yui.system.myemail.entity.FileEntity;
import com.yui.system.myemail.entity.ImageEntity;
import com.yui.system.myemail.repository.EmailRepository;
import com.yui.system.myemail.repository.FileRepository;
import com.yui.system.myemail.repository.ImageRepository;
import com.yui.system.myemail.service.EmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/**
 * 数据库连接测试
 *
 * @author XuZhuohao
 * @date 2018/10/19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DbTest {
    @Autowired
    private EmailRepository emailRepository;
    @Autowired
    private FileRepository fileRepository;
    @Autowired
    private ImageRepository imageRepository;
    @Value("${spring.mail.username}")
    private String from;
    @Autowired
    EmailService emailService;

    @Test
    public void test1(){
        String imageCid01 = "t1";
        String imageCid02 = "t2";
        String content = "<html><body><h1>图片发送</h1><p></p><img src='cid:" + imageCid01 + "'></img>" +
                "<img src='cid:" + imageCid02 + "'></img></body></html>";
        EmailEntity emailEntity = new EmailEntity();
        emailEntity.setFromUser(from);
        emailEntity.setToUser(from);
        emailEntity.setContent(content);
        emailEntity.setSubject("邮件发送测试");
        /*
        emailEntity.setImages("t1&D:\\data\\t1.jpg,t2&D:\\data\\t2.gif");
        */
        Set<ImageEntity> images = new HashSet<>();
        ImageEntity imageEntity01 = new ImageEntity();
        imageEntity01.setCid(imageCid01);
        imageEntity01.setSrc("D:\\data\\t1.jpg");
//        imageEntity01.setEmailId(1L);
        ImageEntity imageEntity02 = new ImageEntity();
        imageEntity02.setCid(imageCid02);
        imageEntity02.setSrc("D:\\data\\t2.gif");
//        imageEntity02.setEmailId(1L);
        images.add(imageEntity01);
        images.add(imageEntity02);
        emailEntity.setImages(images);

        //emailEntity.setFiles("file1&D:\\data\\t1.jpg,file2&D:\\data\\t1.jpg");
        Set<FileEntity> files = new HashSet<>();
        FileEntity fileEntity01 = new FileEntity();
        fileEntity01.setFileName("t1.jpg");
        fileEntity01.setPath("D:\\data\\t1.jpg");
//        fileEntity01.setEmailId(1L);
        FileEntity fileEntity02 = new FileEntity();
        fileEntity02.setFileName("t2.jpg");
        fileEntity02.setPath("D:\\data\\t1.jpg");
//        fileEntity02.setEmailId(1L);
        files.add(fileEntity01);
        files.add(fileEntity02);
        emailEntity.setFiles(files);

        imageRepository.saveAll(images);
        fileRepository.saveAll(files);
        emailRepository.save(emailEntity);
        emailService.sendEmail(emailEntity);
    }

    @Test
    public void testSendEmailFromDB(){
        Optional<EmailEntity> emailEntity = emailRepository.findById(1L);
        if (!emailEntity.isPresent()){
            throw new RuntimeException("exception of find by id");
        }
        System.out.println(JSON.toJSONString(emailEntity));
        emailService.sendEmail(emailEntity.get());
    }
}
