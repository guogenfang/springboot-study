package org.ggf.cache;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *[简要描述]: 
 * @Author ggf
 * @Date 2020/10/15 16:56
 **/
public class CacheTest extends SpringBootTestConfig {
    @Autowired
    private TestService testService;

    @Test
    public void findById(){
        testService.findById(1);
        testService.findById(1);
        testService.findById(4);
        testService.findById(5);
    }
}
