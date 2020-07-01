package com.mall.utils.job;

import org.apache.commons.lang.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
/**
 *   使用@Scheduled 注解很方便，但缺点是当我们调整了执行周期的时候，需要重启应用才能生效，
 *    这多少有些不方便。为了达到实时生效的效果，可以使用接口来完成定时任务
 *
 *
 *
 * */

//@Component("DateCopeTask")
//@Configuration("DateCopeTask")
public class DateCopeTask {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private static final  String cronSycn = "0 23/2 13 * * ?";

    private static int num = 0;

    @Scheduled(cron="0/2 * *  * * ? ")
    public void sycnFlight(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String format = dateTimeFormatter.format(now);
        System.err.println("执行静态定时任务时间: " + format);
    }


}
