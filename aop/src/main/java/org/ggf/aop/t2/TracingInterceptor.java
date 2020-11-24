package org.ggf.aop.t2;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *[简要描述]: 
 * @Author ggf
 * @Date 2020/10/16 10:36
 **/
public class TracingInterceptor implements MethodInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(TracingInterceptor.class);

    @Override
    public Object invoke(MethodInvocation i) throws Throwable {
        LOGGER.info("before method {} is called on {} with args {}", i.getMethod(), i.getThis(), i.getArguments());
        Object ret = i.proceed();
        LOGGER.info("after method {} returns {}", i.getMethod(), ret);
        return ret;
    }
}
