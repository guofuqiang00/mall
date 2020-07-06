package com.mall.config.test;

import com.mall.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration {

   public TestConfiguration(){
       System.out.println("TestConfiguration容器启动初始化。。。");
   }

   @Bean
    public User user(){
        return new User(1001,"jack","aaa",18);
    }

    @Bean
    public User user2(){
        return new User(1001,"jack","aaa",18);
    }




}
