package com.mall.b;

import com.mall.base.BaseCaseTest;
import com.mall.dao.user.UserMapper;
import com.mall.entity.User;
import com.mall.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test extends BaseCaseTest {

    @Autowired
    private UserMapper userMapper;

    @org.junit.Test
    public void test(){
        User user = new User();
        user.setUsername("root");
        Page<User> page = new Page<>();
        page.setPageCount(1);
        page.setPageSize(10);
        Map<String,Object> map = new HashMap<String, Object>(){{
            put("user",user);
            put("page",page);
        }};
        System.out.println(map);
        List<User> users = userMapper.selectUserByMap(map);
        System.out.println(users);
    }

}
