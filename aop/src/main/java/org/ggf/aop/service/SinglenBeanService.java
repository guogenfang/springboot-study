package org.ggf.aop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 *[简要描述]: 
 * @Author ggf
 * @Date 2020/10/25 20:59
 **/
@Service
public class SinglenBeanService implements CommandLineRunner {
    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(applicationContext.getBean("sb1"));
        System.out.println(applicationContext.getBean("sb1"));
        System.out.println(applicationContext.getBean("sb2"));
        System.out.println(applicationContext.getBean("sb2"));
    }
}
