package com.mall.controller.aop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aop")
public class AopController {


    @GetMapping("/get")
    public String get(@RequestParam("name")String name){

        System.out.println(name+"面向切面请求-----》》》");

        return name+"面向切面请求";

    }

}
