package org.ggf.aop;

import java.lang.annotation.*;

/**
 * @author ggf
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TimesListen {
}
