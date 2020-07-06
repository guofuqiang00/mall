package com.mall.config.test;

import com.mall.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:applicationContext.xml")
public class TestConfiguration3 {

   public TestConfiguration3(){
       System.out.println("TestConfiguration容器启动初始化33333。。。");
   }

}
