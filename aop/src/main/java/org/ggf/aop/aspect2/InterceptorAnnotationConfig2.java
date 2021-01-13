package org.ggf.aop.aspect2;

import org.aopalliance.aop.Advice;
import org.ggf.aop.TimesListen;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 *[简要描述]: 
 * @Author ggf
 * @Date 2020/10/16 17:39
 **/
@Component
public class InterceptorAnnotationConfig2 extends AbstractPointcutAdvisor {

    private final StaticMethodMatcherPointcut pointcut = new StaticMethodMatcherPointcut() {
        @Override
        public boolean matches(Method method, Class<?> targetClass) {
            return method.isAnnotationPresent(TimesListen.class) || targetClass.isAnnotationPresent(TimesListen.class);
        }
    };

    @Override
    public Pointcut getPointcut() {
        return new AnnotationMatchingPointcut(null, TimesListen.class);
    }

    @Override
    public Advice getAdvice() {
        return new TracingInterceptor();
    }
}
