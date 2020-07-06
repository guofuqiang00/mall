package com.mall.controller;

import com.mall.dao.user.UserMapper;
import com.mall.entity.User;
import com.mall.entity.User2;
import com.mall.utils.QueryPageHelper;
import com.mall.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
    public R selectUser(@RequestParam Map<String,Object> params){
        QueryPageHelper queryPageHelper = new QueryPageHelper(params);
        List<User> users = userMapper.selectUser(queryPageHelper);
        return R.okPage(users);

     /*   int page = Integer.parseInt(params.get("page") + "");
        int limit = Integer.parseInt(params.get("limit") + "");
        IPage<User> pages = new Page<>(page, limit);
        pages.setRecords( userMapper.selectUser(params));
        return R.ok();*/

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

    //mybatis_plus方式
    @RequestMapping("/get")
    public R get(Integer id){
        User2 user2 = userMapper.selectById(id);
        return R.ok().put("user",user2);
    }
    @RequestMapping("/getByIds")
    public R getByIds(@RequestBody long [] ids){
        System.out.println(ids);
        List<Integer> list = Arrays.asList(1, 1);
        List<User2> user2s = userMapper.selectBatchIds(list);
        return R.ok().put("users",user2s);
    }
}
