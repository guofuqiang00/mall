package com.mall.controller;

import com.mall.config.SecurityInterceptor;
import com.mall.dao.user.UserMapper;
import com.mall.entity.User;
import com.mall.model.Response;
import com.mall.utils.MD5Utils;
import com.mall.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Model;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/login")
@Api(tags = "1、登录注册")
public class LoginController {


    @Autowired
    private UserMapper userMapper;

    @ApiOperation(value = "1.3 user")
    @GetMapping("/isLogin")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名称",required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "账户密码", dataType = "String", paramType = "query")
    })
    public Response<User> user(String username,String password,HttpServletRequest request){

        HttpSession session = request.getSession(false);
        Object token = session.getAttribute("SESSIONID");
        System.out.println(token);
        return new Response<>();
    }


    @RequestMapping("/getUser")
    @ResponseBody
    public Map<String,Object> getUser(@SessionAttribute(SecurityInterceptor.SESSION_KEY)String account, Model model){
        Map map = new HashMap();
        List<User> users = userMapper.selectAll();
        map.put("users",users);
        return map;
    }

    //登录
    @RequestMapping("/login")
    public String login(){
        return "login/login";
    }

    /**
     * 用户登陆验证
     * */
    @ApiOperation(value = "1.1 登录")
    @PostMapping("/loginVerify")
    @ResponseBody
    public Map<String,Object> loginVerify(@RequestBody User user, HttpSession session){
        System.out.println("login  1111111111");
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> response = new HashMap<>();
        map.put("username",user.getUsername());
        map.put("password",user.getPassword());
        User verify = userMapper.loginVerify(map);
        System.out.println("verify"+verify);
        if(verify!=null){
           session.setAttribute(SecurityInterceptor.SESSION_KEY,user.getUsername());
            session.setMaxInactiveInterval(30*1);
            response.put("msg","登陆成功");
            response.put("code","200");
        }else{
            response.put("msg","账户或者密码错误");
            response.put("code","202");
        }
        return response;
//        if(user==null){
//            map.put("msg","请输入用户名或密码");
//        }
//        List<User> users = userMapper.selectAll();
//        HttpSession session = request.getSession();
//        Object token = request.getHeader("token");
//        System.out.println("token----?>>>>"+token);
//            if(users!=null){
//                for (int i = 0; i < users.size(); i++) {
//                    if(user.getUsername().equals(users.get(i).getUsername())&&user.getPassword().equals(users.get(i).getPassword())){
//                        System.out.println("token----?>>>>"+token);
//                        session.setAttribute("SESSIONID", MD5Utils.code(user.getUsername()+user.getPassword()));
//                        Cookie cookie=new Cookie("CNAME",user.getUsername());
//                        cookie.setMaxAge(30*100);//这里设置设置有效时间，单位的秒
//                        cookie.setPath("/");//这里是之根目录下所有的目录都可以共享Cookie
//                        session.setMaxInactiveInterval(30*100); //单位秒
//                        map.put("msg","登陆成功");
//                        map.put("code",200);
//                        map.put("data",null);
//                        map.put("SESSIONID",MD5Utils.code(user.getUsername()+user.getPassword()));
//                        break;
//                    }else{
//                        map.put("msg","用户名或密码错误");
//                    }
//                }
//            }
//        return map;
    }


    @RequestMapping("/loginOut")
    @ResponseBody
   public Map<String,Object> loginOut(HttpSession session){
        Map<String,Object> map = new HashMap<>();
        session.removeAttribute(SecurityInterceptor.SESSION_KEY);
        map.put("msg","登出成功");
        map.put("code",200);
        return map;
   }

    /**
     * 用户注册
     * */
    @ApiOperation(value = "1.2 注册")
    @PostMapping("/regist")
    @ResponseBody
    public Map<String,Object> regist(@RequestBody User user){
        System.out.println("user++++>>>"+user);
        Map<String,Object> map = new HashMap<>();
        if(user==null){
            map.put("msg","请输入用户名或者密码");
        }
        if(user!=null){
                User user1 = userMapper.selectUsername(user.getUsername());
                System.out.println(user1);
                if(user1!=null){
                    if(user.getUsername().equals(user1.getUsername())){
                        map.put("msg","用户名已存在");
                        map.put("code",2001);
                    }else{
                        int result = userMapper.insert(user);
                        if(result>0){
                            map.put("msg","注册成功");
                            map.put("code",200);
                        }
                    }
                }else{
                    int result = userMapper.insert(user);
                    if(result>0){
                        map.put("msg","注册成功");
                        map.put("code",200);
                    }
                }

        }else{
            map.put("msg","用户名和密码不能为空");
            map.put("code",2004);
        }
        return map;
    }


}
