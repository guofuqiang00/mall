package com.mall.controller;

import com.github.pagehelper.PageHelper;
import com.mall.config.SecurityInterceptor;
import com.mall.dao.user.UserMapper;
import com.mall.entity.User;
import com.mall.entity.User2;
import com.mall.utils.QueryPageHelper;
import com.mall.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private static int index = 0;

    @Autowired
    private HttpServletRequest request;


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
    public R selectUser(@RequestParam Map<String,Object> params ,HttpSession session){

//        HttpSession session = request.getSession();
//        String sessionid = (String) session.getAttribute("SESSIONID");
//        System.out.println("SESSIONID-------------------??????>>>>"+sessionid);
//        String token = request.getHeader("token");
//        System.out.println("sessionid----->"+sessionid);
//        System.out.println("token----->"+token);
//        if(token!=null&&token.equals(sessionid)){
//            QueryPageHelper queryPageHelper = new QueryPageHelper(params);
//            PageHelper.startPage(1,10);
//            List<User> users = userMapper.selectUser(queryPageHelper);
//            return R.okPage(users);
//        }else{
//            Map<String,Object> map = new HashMap<>();
//            map.put("msg","登入已过期请重新登录");
//            map.put("code","201");
//            return R.ok(map);
//        }

     /*   int page = Integer.parseInt(params.get("page") + "");
        int limit = Integer.parseInt(params.get("limit") + "");
        IPage<User> pages = new Page<>(page, limit);
        pages.setRecords( userMapper.selectUser(params));
        return R.ok();*/
         if(session.getAttribute(SecurityInterceptor.SESSION_KEY)!=null){
             QueryPageHelper queryPageHelper = new QueryPageHelper(params);
             PageHelper.startPage(1,10);
             List<User> users = userMapper.selectUser(queryPageHelper);
             return R.okPage(users);
         }else{
             return R.error(1,"登入已失效 请登录.....");
         }

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
   /* @RequestMapping("/get")
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
    }*/
}
