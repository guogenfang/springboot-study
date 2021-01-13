package org.ggf.aop.aspect1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * 方法请求监听切面
 * 使用自定义注解（切点）+ @Aspect（切面）构成织入
 * @author ggf
 */
@Aspect
@Component
public class TimeListenAspect {
    Logger logger = LoggerFactory.getLogger(TimeListenAspect.class);

    @Pointcut("@annotation(org.ggf.aop.TimesListen)")
    public void timePointCut() {
    }

    @Around("timePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        String methodName = signature.getName();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        logger.info("before count function exec times method:{}, ", methodName);
        Object result = point.proceed();
        stopWatch.stop();
        logger.info("after count function exec times method:{}, times millis:{}", methodName, stopWatch.getTotalTimeMillis());
        return result;
    }

}
