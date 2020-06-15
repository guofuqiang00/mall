package com.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/common")
public class CommonController {


    @RequestMapping("/u")
    public String  u(){
        System.out.println("uuuuuu-----------uuuuuuuuuuu");
        return "index";
    }

    @RequestMapping("m")
    @ResponseBody
    public String  m(){
        System.out.println("uuuuuu-----------uuuuuuuuuuu");
        return "shop/user_list";
    }


}
