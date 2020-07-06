package com.mall.config.test;

import com.mall.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

    public static void main(String[] args) {

        //@Configuration注解的spring容器加载方式
        //用AnnotationConfigApplicationContext替换ClassPathXmlApplicationContext
        //ApplicationContext context = new AnnotationConfigApplicationContext();

        AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext();

        //注册配置类
        context.register(TestConfiguration.class);
        context.register(TestConfiguration2.class);
        context.register(TestConfiguration3.class);
        context.register(TestConfiguration4.class);
        context.refresh();

        // 如果加载spring-context.xml文件：
        // ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        //获取bean
        User user =(User)context.getBean("user");
        System.out.println(user);

        //获取xml bean
        User users = (User) context.getBean("usr");
        System.out.println(users);

        //获取run方法生成的Bean
        Object run = context.getBean("run");
        System.out.println(run);


    }
}
