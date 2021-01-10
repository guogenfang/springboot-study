package org.ggf.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

/**
 *[简要描述]: 
 * @Author ggf
 * @Date 2020/10/14 22:22
 **/
@SpringBootApplication
public class RedisApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(RedisApplication.class, args);
    }
}
