package com.mall.controller;

import com.mall.service.TestService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("test")
public class TestController {

//    @Resource(name = "testServiceImpl2") //byName
    @Autowired  //byType
    @Qualifier("testServiceImpl2")  //byName
    private TestService1 testService1;


    @RequestMapping("test1")
    public void test1(){
        System.out.println("test1");
    }

    @RequestMapping("/read")
    public String  read(){
        String read = testService1.read();
        System.out.println(read);
        return read;
    }
}
