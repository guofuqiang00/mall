package com.mall.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.config.RedisConfig;
import com.mall.dao.user.UserMapper;
import com.mall.entity.User;
import com.mall.utils.QueryPageHelper;
import com.mall.utils.R;
import io.swagger.models.parameters.QueryParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private static int index = 0;


    @Autowired(required = false)
    private UserMapper userMapper;

    @RequestMapping("/run")
    public String run(){

        return "run";
    }

    Logger log = LoggerFactory.getLogger(UserController.class);

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

    @RequestMapping(value = "/selectUser",method = RequestMethod.GET)
    @ResponseBody
    public R selectUser(@RequestParam Map<String,Object> map){
        QueryPageHelper queryPageHelper = new QueryPageHelper(map);
        List<User> users = userMapper.selectUser(queryPageHelper);
        return R.okPage(users);
    }

    @RequestMapping(value = "/insertUser")
    public R insertUser(@RequestBody User user){
        int insert = userMapper.insert(user);
        return R.ok().put("num",insert);
    }

    @RequestMapping(value = "/delete")
    public R delete(Integer id){
        int insert = userMapper.deleteByPrimaryKey(id);
        return R.ok().put("num",insert);
    }

    @RequestMapping("/add")
    public void add(){
        System.out.println(UserController.index++);
    }






}
