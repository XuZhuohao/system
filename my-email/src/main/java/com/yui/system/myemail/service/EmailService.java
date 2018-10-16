package com.yui.system.myemail.service;

import com.yui.system.myemail.entity.EmailEntity;

/**
 * 邮件发送
 *
 * @author XuZhuohao
 * @date 2018/10/16
 */
public interface EmailService {
    boolean sendEmail(EmailEntity emailEntity);
}
