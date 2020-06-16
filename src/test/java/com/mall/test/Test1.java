package com.mall.test;
import com.mall.MallApplication;

import com.mall.base.BaseCaseTest;
import com.mall.dao.user.UserMapper;
import com.mall.entity.User;
import com.mall.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@ActiveProfiles("dev")
public class Test1 extends BaseCaseTest {
    @Autowired(required = false)
    private UserMapper userMapper;
    @Autowired
    RedisUtil redisUtil;

    @Test
    public void test(){
        redisUtil.del("aa");


    }

}
