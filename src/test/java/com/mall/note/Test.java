package com.mall.note;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test {
    public static void main(String[] args) {
        //获取当前时间的前一天
        LocalDate now = LocalDate.now().minusDays(1);
        LocalDateTime currentDateTime = LocalDateTime.now().minusDays(1).withHour(0).withMinute(0).withSecond(0);
        System.out.println(now);

    }
}
