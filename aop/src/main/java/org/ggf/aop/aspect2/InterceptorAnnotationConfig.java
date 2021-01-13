package org.ggf.aop.aspect2;

import org.ggf.aop.TimesListen;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *[简要描述]: 
 * @Author ggf
 * @Date 2020/10/16 11:08
 **/
@Configuration
public class InterceptorAnnotationConfig {
    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisor3() {
        TracingInterceptor interceptor = new TracingInterceptor();
        AnnotationMatchingPointcut pointcut = new AnnotationMatchingPointcut(null, TimesListen.class);

//        JdkRegexpMethodPointcut pointcut = new JdkRegexpMethodPointcut();
//        pointcut.setPatterns("cn.bellychang.aop.*");

        // 配置增强类advisor
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        advisor.setPointcut(pointcut);
        advisor.setAdvice(interceptor);
        return advisor;
    }
}
