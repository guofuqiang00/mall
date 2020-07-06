package com.mall.config.test;

import com.mall.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration2 {

   public TestConfiguration2(){
       System.out.println("TestConfiguration容器启动初始化22222。。。");
   }


}
