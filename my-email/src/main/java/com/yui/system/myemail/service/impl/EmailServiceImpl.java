package com.yui.system.myemail.service.impl;

import com.yui.system.myemail.entity.EmailEntity;
import com.yui.system.myemail.entity.FileEntity;
import com.yui.system.myemail.entity.ImageEntity;
import com.yui.system.myemail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;
import java.util.Set;

/**
 * @author XuZhuohao
 * @date 2018/10/16
 */
@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public boolean sendEmail(EmailEntity emailEntity) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(emailEntity.getFromUser());
            helper.setTo(emailEntity.getToUser());
            helper.setSubject(emailEntity.getSubject());
            helper.setText(emailEntity.getContent(), true);
            // 插入图片
            Set<ImageEntity> images = emailEntity.getImages();
            for (ImageEntity image : images) {
                helper.addInline(image.getCid(), new FileSystemResource(new File(image.getSrc())));
            }
            // 插入附件
            Set<FileEntity> files = emailEntity.getFiles();
            for (FileEntity file : files) {
                helper.addAttachment(file.getFileName(), new FileSystemResource(new File(file.getPath())));
            }
            // 发送邮件
            mailSender.send(message);
        } catch (Exception e) {
            // TODO: 数据库日志，保存EmailEntity日志
            e.printStackTrace();
        }
        return false;
    }
}
