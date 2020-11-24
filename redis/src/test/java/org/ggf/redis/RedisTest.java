package org.ggf.redis;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;

/**
 *[简要描述]: 
 * @Author ggf
 * @Date 2020/10/15 15:11
 **/
public class RedisTest extends SpringBootTestConfig {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private RedisTemplate<String, String> stringRedisTemplate;

    @Test
    public void keys() {
        redisTemplate.keys("*").stream().forEach(System.out::println);
    }

    @Test
    public void get() {
        Object obj = redisTemplate.opsForValue().get("ipcourt-open-courtroom-3675");
        System.out.println(obj);
    }

    @Test
    public void createObj() {
        redisTemplate.opsForValue().set("abc", new User(123, "ggf"));
        System.out.println(stringRedisTemplate.opsForValue().get("abc"));
    }

    class User implements Serializable {
        private Integer id;
        private String name;

        public User(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
