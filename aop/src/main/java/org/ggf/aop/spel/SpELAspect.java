package org.ggf.aop.spel;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class SpELAspect {
    Logger logger = LoggerFactory.getLogger(SpELAspect.class);

    @Pointcut("@annotation(org.ggf.aop.spel.LogAnnotation)")
    public void logPointCut() {
    }

    @After("logPointCut()")
    public void after(JoinPoint point) {
        //MethodInvocationProceedingJoinPoint
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        MethodSignature signature = (MethodSignature) point.getSignature();
        String methodName = signature.getName();
        LogAnnotation logAnnotation = signature.getMethod().getAnnotation(LogAnnotation.class);
        System.out.println();
    }
}
