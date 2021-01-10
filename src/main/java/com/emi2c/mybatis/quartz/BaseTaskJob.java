package com.emi2c.mybatis.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 基础任务调度taskJob接口
 */
public interface BaseTaskJob extends Job {

    void execute(JobExecutionContext context) throws JobExecutionException;

}
