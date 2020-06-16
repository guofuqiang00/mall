package com.mall.controller;

import com.mall.dao.user.UserMapper;
import com.mall.entity.User;
import com.mall.utils.Page;
import com.mall.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "/selectUser",method = RequestMethod.GET)
    @ResponseBody
    public R selectUser(@RequestParam Map<String,Object> map){

        Page<User> page = new Page<>();
        page.setPageCount(Integer.valueOf(String.valueOf(map.get("page"))));
        page.setPageSize(Integer.valueOf(String.valueOf(map.get("limit"))));
        List<User> users = userMapper.selectUser(page);
        int count = userMapper.selectUserCount();
        Page<User> page1 = new Page<>();
        page1.setObjects(users);
        page1.setTotalPage(count);
        return R.ok().put("data",page1);
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




}
