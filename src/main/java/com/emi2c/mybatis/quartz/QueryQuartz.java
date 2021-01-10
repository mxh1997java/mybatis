package com.emi2c.mybatis.quartz;

import com.emi2c.mybatis.command.Condition;
import com.emi2c.mybatis.entity.Diary;
import com.emi2c.mybatis.mapper.DiaryMapper;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class QueryQuartz implements BaseTaskJob {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DiaryMapper diaryMapper;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        logger.info("Query 定时任务执行 " + dtf.format(LocalDateTime.now()));
        Condition condition = new Condition();
        condition.setBeginTime(LocalDateTime.parse("2021-01-08 00:00:00", dtf));
        condition.setEndTime(LocalDateTime.parse("2021-01-10 00:00:00", dtf));
        condition.setIndex(1);
        condition.setPageSize(10);
        List<Diary> diaryList = diaryMapper.findAllByCondition(condition);
        diaryList.forEach(item -> {
            System.out.println(item);
        });
    }

}
