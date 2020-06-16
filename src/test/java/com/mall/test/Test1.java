package com.mall.test;
import com.mall.MallApplication;

import com.mall.base.BaseCaseTest;
import com.mall.utils.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

public class Test1 extends BaseCaseTest {
    @Autowired
    private RedisUtils redisUtils;

    @Test
    public void test(){

        String aa = redisUtils.get("aa");
        System.out.println(aa);

    }

}
