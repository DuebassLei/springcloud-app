package com.gaolei.app.anno;

import java.lang.annotation.*;

/**
 * 定义系统日志注解
 * @author DuebassLei
 * @version 1.0
 * @date 2020/10/14 13:20
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLogAnnotation {
    String value() default "";
}
