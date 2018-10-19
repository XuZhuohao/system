package com.yui.system.myemail.service.impl;

import com.yui.system.myemail.entity.EmailEntity;
import com.yui.system.myemail.entity.FileEntity;
import com.yui.system.myemail.entity.ImageEntity;
import com.yui.system.myemail.repository.EmailRepository;
import com.yui.system.myemail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Set;

/**
 * @author XuZhuohao
 * @date 2018/10/16
 */
@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;
    private final EmailRepository emailRepository;

    @Autowired
    public EmailServiceImpl(JavaMailSender mailSender, EmailRepository emailRepository) {
        this.mailSender = mailSender;
        this.emailRepository = emailRepository;
    }

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
            emailEntity.setSend(true);
        } catch (Exception e) {
            // TODO: 数据库日志，保存EmailEntity日志
            e.printStackTrace();
            emailEntity.setSend(false);
        }
        emailRepository.save(emailEntity);
        return emailEntity.isSend();
    }
}
