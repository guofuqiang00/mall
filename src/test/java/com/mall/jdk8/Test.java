package com.mall.jdk8;

import com.mall.entity.User;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

import static java.time.LocalDate.now;

public class Test {

    public static void main(String[] args) {

        LocalDate localDate = now();
        System.out.println(localDate); //2020-06-23
        LocalDate localDate1 = now().minusMonths(1);
        System.out.println(localDate1); //上个月的今天
        LocalDate localDate2 = now().minusMonths(1);


        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        Date date = new Date();
        String format = dateTimeFormatter.format(now);
        System.out.println(format);


        User user = new User();
        user.setUsername("admin");
        String user1 = Optional.ofNullable(user).map(u->u.getUsername()).orElse("Unknow");
        System.out.println(user1);


    }
}
