package com.mall.java;

import com.mall.entity.User;
import com.alibaba.fastjson.JSON;
import java.util.HashMap;
import java.util.Map;

public class Test {

    private static String getMemberCode(Integer code){
        String memberCode = "";
        if(code <10){
            memberCode="000000"+code;
        }else if(code > 10 && code <100){
            memberCode="00000"+code;
        }else if(code >100 && code <1000){
            memberCode="0000"+code;
        }else if(code >1000 && code <10000){
            memberCode="000"+code;
        }else if(code >10000 && code <100000){
            memberCode="00"+code;
        }else if(code >100000 && code <1000000){
            memberCode="0"+code;
        }else{
            memberCode=""+code;
        }
        return memberCode;
    }
    public static void main(String[] args) {

        Map<String,Object> map = new HashMap<>();
        map.put("msg","消息");
        User user = JSON.parseObject(JSON.toJSONString(map), User.class);
        System.out.println(user.getMsg());


        String memeberCode = "00001";
        System.out.println(Integer.parseInt(memeberCode));

        System.out.println(Test.getMemberCode(12));

    }
}
