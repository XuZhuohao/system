package com.yui.system.myemail.service.impl;

import com.yui.system.myemail.entity.EmailEntity;
import com.yui.system.myemail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

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
            helper.setFrom(emailEntity.getFrom());
            helper.setTo(emailEntity.getTo());
            helper.setSubject(emailEntity.getSubject());
            helper.setText(emailEntity.getContent(), true);
            // 插入图片
            Map<String, String> images = this.dealWithStrList(emailEntity.getImages());
            for (Map.Entry<String, String> entry : images.entrySet()) {
                String imageName = entry.getKey();
                String image = entry.getValue();
                helper.addInline(imageName, new FileSystemResource(new File(image)));
            }
            // 插入附件
            Map<String, String> files = this.dealWithStrList(emailEntity.getFiles());
            for (Map.Entry<String, String> entry : files.entrySet()) {
                String fileName = entry.getKey();
                String file = entry.getValue();
                helper.addAttachment(fileName, new FileSystemResource(new File(file)));
            }
            // 发送邮件
            mailSender.send(message);
        } catch (Exception e) {
            // TODO: 数据库日志，保存EmailEntity日志
            e.printStackTrace();
        }
        return false;
    }

    private Map<String, String> dealWithStrList(String str){
        String[] maps = str.split(",");
        Map<String, String> result = new HashMap<>(16);
        try {
            for (String map : maps) {
                String[] temp = map.split("&");
                result.put(temp[0],temp[1]);
            }
        } catch (Exception e){
            throw new RuntimeException("解析参数出错：" + str);
        }

        return result;
    }
}
