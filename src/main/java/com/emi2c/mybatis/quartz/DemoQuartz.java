package com.emi2c.mybatis.quartz;

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

@Component
public class DemoQuartz implements BaseTaskJob {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DiaryMapper diaryMapper;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        logger.info("定时任务执行 " + dtf.format(LocalDateTime.now()));

        Diary diary = new Diary();
        String title = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now());
        diary.setTitle(title);
        StringBuffer content = new StringBuffer();
        content.append(" 日期:" + title);
        content.append(" 记录人: 马鑫海");
        content.append(" 内容: 那一年我二十四岁，在我一生的黄金时代。我有好多奢望。我想爱，想吃，还想再一瞬间变成天上半明半暗的云。我来我才知道，生活就是个缓慢受锤的过程，人一天天老下去，奢望也一天天消失，最后变得像挨了锤的牛一样。可是我过二十一岁生日时没有预见到这一点。我觉得自己会永远生猛下去，什么也锤不了我。");
        diary.setContent(content.toString());
        diary.setCreator("maxinhai");
        diary.setCreateTime(LocalDateTime.now());
        int insert = diaryMapper.insert(diary);
    }

}
