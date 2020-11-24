package org.ggf.aop.config;

import org.ggf.aop.service.SinglenBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 *[简要描述]: 
 * @Author ggf
 * @Date 2020/10/25 20:52
 **/
@Configuration
public class BeanConfig {

    @Bean
    public SinglenBean sb1() {
        System.out.println("sb1 bean config");
        return new SinglenBean("sb1");
    }

    @Bean
    @Scope("prototype")
    public SinglenBean sb2() {
        System.out.println("sb2 bean config");
        return new SinglenBean("sb2");
    }

}
