package com.emi2c.mybatis.quartz;

import com.emi2c.mybatis.email.EmailUtil;
import com.emi2c.mybatis.httpclient.HttpClientUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class MailQuartz implements BaseTaskJob {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EmailUtil emailUtil;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        logger.info("定时任务执行 " + dtf.format(LocalDateTime.now()));
        String message = HttpClientUtils.getMessage();
        String from = "2485460305@qq.com";
        String to = "18334698204@163.com";
        String subject = "每日邮件(-_-)";
        emailUtil.sendSimpleMail(from, to, subject, message);
    }

}
