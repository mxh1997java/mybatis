package com.emi2c.mybatis.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * QQ邮箱工具类
 */
@Component
public class EmailUtil {

    @Autowired
    private JavaMailSender mailSender;

    /**
     * 发送检单邮件
     * @param from  发送方
     * @param to    接收方
     * @param subject 主题
     * @param text    内容
     */
    public void sendSimpleMail(String from, String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }

}
