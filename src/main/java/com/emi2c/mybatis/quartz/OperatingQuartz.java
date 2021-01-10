package com.emi2c.mybatis.quartz;

import com.emi2c.mybatis.util.RedisUtil;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * 操作记录处理定时任务
 */
@Component
public class OperatingQuartz implements BaseTaskJob {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        logger.info("Operating 定时任务执行 " + dtf.format(LocalDateTime.now()));

        long size = redisUtil.lGetListSize("operating");
        logger.info("操作记录: {} 条", size);
        List<Object> list = redisUtil.lGet("operating", 0, -1);
        list.forEach(item -> {
            logger.info("开始消费消息记录: {}", item);
        });
    }

}
