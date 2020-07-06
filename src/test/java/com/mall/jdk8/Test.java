package com.mall.jdk8;

import com.mall.entity.User;
import io.swagger.models.auth.In;

import javax.swing.text.html.Option;
import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

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

    //日期
    @org.junit.Test
    public void DateTimeTest() throws InterruptedException {
        Date date = new Date();
        System.out.println(date.getTime());
        Thread.sleep(5);
    }

    @org.junit.Test
    public void ListTest(){

        List<Integer> ls = new ArrayList<>();
        ls.add(66);
        System.out.println(ls);

        List<Integer> list = Arrays.asList(5,4,9,4);
        //Arrays.asList(): 创建之后的list不支持add(),remove()操作 只支持遍历读操作;
        //list.add(88);
        System.out.println(list);



    }


    @org.junit.Test
    public void MapTest(){
        int aHundredMillion = 10000000;

        Map<Integer, Integer> map2 = new HashMap<>(aHundredMillion);
        long s3 = System.currentTimeMillis();
        for (int i = 0; i < aHundredMillion; i++) {
            map2.put(i, i);
        }
        long s4 = System.currentTimeMillis();
        System.out.println("初始化容量为<<<"+aHundredMillion+"，耗时 ： " + (s4 - s3));

    }
}
