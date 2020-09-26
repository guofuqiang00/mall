package com.mall.controller.example;

import com.mall.dao.user.UserMapper;
import com.mall.entity.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/example")
@CrossOrigin
public class ExampleController {

    //controller里面是根据requestMapping里面值跟参数和对应的请求方式找对应的方法,是可以重载的,

    /**
     *
     * @param list  传一个数组
     * @return list
     */
    @PostMapping("/getParamsByArray")
    public List<Integer> getParamsByArray(@RequestBody List<Integer> list){
       return list;
    }

    /**
     * @description  传一个map
     * @param map
     * @return map
     */
    @PostMapping("/getParamsByMap")
    public Map getParamsByMap(@RequestBody Map<String,Object> map){
        return map;
    }

    /***
     * @description 传2个实体类 User和 UserCopy
     *  {"address":"广州", "phone":"17845695255", "username":"admin"}
     *
     * @param user
     * @return
     */
    @PostMapping("/getUserAndUserCopy")
    public User getUserAndUserCopy(@RequestBody User user){
        String address = user.getUserCopy().getAddress();
        String phone = user.getUserCopy().getPhone();
        System.out.println("address--->"+address);
        System.out.println("phone--->"+phone);
        return user;
    }










}
