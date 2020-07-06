package com.mall.config.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

@Configuration
public class TestConfiguration4 {

   public TestConfiguration4(){
       System.out.println("TestConfiguration容器启动初始化44444。。。");
   }

    @Bean
    public String show(){
        return "show is a info";
    }

   @Bean
    public String run(){
       return "there is run ";
   }


}
