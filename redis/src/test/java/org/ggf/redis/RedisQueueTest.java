package org.ggf.redis;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 *[简要描述]: 
 * @Author ggf
 * @Date 2020/10/15 15:11
 **/
public class RedisQueueTest extends SpringBootTestConfig {

    @Autowired
    private RedisTemplate<String, String> stringRedisTemplate;

    @Test
    public void keys() {
        stringRedisTemplate.keys("*").stream().forEach(System.out::println);
    }

    @Test
    public void put() {
        stringRedisTemplate.opsForList().rightPush("uid-type-vid", "1609075135462");
        stringRedisTemplate.opsForList().rightPush("uid-type-vid", "1609075140710");
        stringRedisTemplate.opsForList().rightPush("uid-type-vid", "1609075150630");
        stringRedisTemplate.opsForList().rightPush("uid-type-vid", "1609075154727");
        stringRedisTemplate.opsForList().rightPush("uid-type-vid", "1609075160562");
        stringRedisTemplate.opsForList().rightPush("uid-type-vid", "1609075165157");
        stringRedisTemplate.opsForList().rightPush("uid-type-vid", "1609075181693");
        stringRedisTemplate.opsForList().rightPush("uid-type-vid", "1609075392306");
        stringRedisTemplate.opsForList().rightPush("uid-type-vid", "1609075392356");
        stringRedisTemplate.opsForList().rightPush("uid-type-vid", "1609075392656");
        stringRedisTemplate.opsForList().rightPush("uid-type-vid", "1609075394756");
    }

    @Test
    public void get() {
        put();
        String value;
        long t = 0;
        long latest = 0;
        while ((value = stringRedisTemplate.opsForList().leftPop("uid-type-vid")) != null) {
            long cur = Long.parseLong(value);
            if (latest == 0) {
                latest = cur;
                continue;
            }
            t += cur % latest;
            latest = cur;
        }
        System.out.println(t);
    }
}
