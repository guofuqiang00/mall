package com.mall.utils.job;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

public class TestMyJob {
    public static void main(String[] args) {


        try {
            //获得一个调度器  创建一个scheduler，scheduler负责所有任务的调度。
            SchedulerFactory sf=new StdSchedulerFactory();
            Scheduler scheduler =sf.getScheduler();

            //2、获得一个jobDetail(任务信息)
            //创建一个包含任务信息的jobDetail，指定任务的实现类为MyJob.class，
            //使用withIdentity方法指定任务名称，还可以用第二个参数指定任务的组名
             JobDetail job = JobBuilder.newJob(MyJob.class)
                             .withIdentity("myJob")
                             .build();

             //3、获得一个trigger(触发器)
             //创建一个任务促发器，指定了促发器的名称“trigger1”和促发器的组名“group1”；
             // 设置了促发的时间为当前促发，且每隔40S执行一次，一共执行10次
                Trigger trigger = TriggerBuilder.newTrigger()
                        .withIdentity("trigger1","group1")
                        .startNow()
                        .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(3)
                        .withRepeatCount(6))
                        .build();

            //4、把任务和触发器放在scheduler 中
            Date date = scheduler.scheduleJob(job, trigger);
            System.out.println("返回最后一次执行的时间===>>"+date);

            //5、开始任务调度
             scheduler.start();

             //关闭Scheduler 传入的是true 等待执行完关闭
            //传入的是false的话表示直接关闭Scheduler 不等待Scheduler执行完
            // scheduler.shutdown(false);



        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }
}
