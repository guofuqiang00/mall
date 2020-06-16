/*
package com.mall.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
*/
/**
 *  @Configuration 配置spring并启动spring容器
 *  @Configuation等价于<Beans></Beans>
 *  @Bean等价于<Bean></Bean>
 *  @ComponentScan等价于<context:component-scan base-package="com.xxx.demo"/>
 * *//*

@Configuration
public class CustomClass {

    public static void main(String[] args) {
        System.out.println("sadsadsad------->>");
    }
    Logger log = LoggerFactory.getLogger(RedisConfig.class);
    @Bean
    public void run(){
        log.info("run->>>>>>>");
    }
}

*/
