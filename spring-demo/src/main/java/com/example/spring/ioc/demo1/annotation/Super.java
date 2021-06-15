package com.example.spring.ioc.demo1.annotation;

import java.lang.annotation.*;

/**
 * @author Mirko
 * @Description
 * @createTime 2021年06月15日 23:46:00
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Super {
}
