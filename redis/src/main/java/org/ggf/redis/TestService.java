package org.ggf.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 *[简要描述]: 
 * @Author ggf
 * @Date 2020/10/14 22:39
 **/
@Service
public class TestService {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;


}
