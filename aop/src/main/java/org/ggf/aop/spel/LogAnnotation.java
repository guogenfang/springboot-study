package org.ggf.aop.spel;

import java.lang.annotation.*;

/**
 *[简要描述]: 
 * @Author ggf
 * @Date 2021/1/10 18:15
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {
    String module() default "";

    String operation();

    String log();
}
