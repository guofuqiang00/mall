package com.mall.controller;

import com.mall.dao.user.UserMapper;
import com.mall.entity.User;
import com.mall.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/run")
    public String run(){

        return "run";
    }


    @RequestMapping("select")
    public String select(){

        List<User> users = userMapper.selectAll();
        users.forEach(System.out::println);

        return "ok";
    }
    @RequestMapping("select2")
    public R select2(){

        List<User> users = userMapper.selectAll();
        users.forEach(System.out::println);

        return R.ok().put("users",users);
    }
}
