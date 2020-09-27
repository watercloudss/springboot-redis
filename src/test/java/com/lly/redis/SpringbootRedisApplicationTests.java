package com.lly.redis;

import ch.qos.logback.core.util.TimeUtil;
import com.lly.redis.pojo.User;
import com.lly.redis.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;


@SpringBootTest
class SpringbootRedisApplicationTests {
@Autowired
private RedisTemplate redisTemplate;
@Autowired
private RedisUtil redisUtil;
    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("username","lly");
        System.out.println(redisTemplate.opsForValue().get("username"));
    }

    @Test
    void test1(){
        User user = new User(1,"刘力源",23);
        redisTemplate.opsForValue().set("user",user);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }

    @Test
    void test2(){
        System.out.println(redisUtil.get("user"));
    }
}
