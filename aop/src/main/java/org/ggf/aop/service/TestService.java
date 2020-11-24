package org.ggf.aop.service;

import org.ggf.aop.TimesListen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *[简要描述]: 
 * @Author ggf
 * @Date 2020/10/16 11:12
 **/
@Service
public class TestService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestService.class);

    @TimesListen
    public void test(String name, Integer code) {
        LOGGER.info("test method name:{}, code:{}", name, code);
    }

    public void test2() {
        LOGGER.info("test2 method");

    }
}
