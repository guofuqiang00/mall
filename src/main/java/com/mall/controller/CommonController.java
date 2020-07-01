package com.mall.controller;

import com.mall.config.rabbitmq.Receiver;
import com.mall.config.rabbitmq.Sender;
import com.mall.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/com")
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

    @Autowired
    private Sender sender;
    @Autowired
    private Receiver receiver;

    @GetMapping("/send")
    @ResponseBody
    public Object send(User user) {
        sender.sendDirectQueue(user);
        return "ok";
    }

    @GetMapping("/receiver")
    @ResponseBody
    public List<User> receiver() {
        return receiver.getMsg();
    }

}
