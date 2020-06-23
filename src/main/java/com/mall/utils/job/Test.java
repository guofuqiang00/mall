package com.mall.utils.job;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

public class Test {
    public static void main(String[] args) throws SchedulerException {

       //获取一个调度器
        StdSchedulerFactory sf = new StdSchedulerFactory();
        Scheduler scheduler = sf.getScheduler();

       //获得一个任务信息 JobDetails
        JobDetail job = JobBuilder.newJob(MyJob.class)
                .withIdentity("myJob").build();

        ScheduleJob scheduleJob = new ScheduleJob();
        scheduleJob.setCreateTime(new Date());
        scheduleJob.setId(888888888L);

        ScheduleUtils.createScheduleJob(scheduler,scheduleJob);
    }
}
