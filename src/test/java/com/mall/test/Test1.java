package com.mall.test;
import com.mall.base.BaseCaseTest;
import com.mall.dao.user.UserMapper;
import com.mall.entity.User;
import com.mall.utils.JedisUtil;
import com.mall.utils.RedisUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.Map;
@ActiveProfiles("dev")
public class Test1 extends BaseCaseTest {
    @Autowired(required = false)
    private UserMapper userMapper;
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    JedisUtil jedisUtil;

    @Test
    public void test(){
        Map<String,Object> map = new HashMap<String, Object>(){{
            put("xsds","下阿斯顿撒旦");
            put("wewe","是的哇的发射点发生");
        }};
        redisUtil.del("aa");
        boolean userMaper = redisUtil.hmset("userMaper", map);
        System.out.println(userMaper);
        JedisPool pool = jedisUtil.getPool();
        Jedis resource = pool.getResource();
        String set = resource.set("ppp", "fffffffffffffsa飒飒飒飒");
        System.out.println(set);

    }


    @Test
    public void regist(){

        User admin = userMapper.selectUsername("admin");
        System.out.println(admin);
    }

}
