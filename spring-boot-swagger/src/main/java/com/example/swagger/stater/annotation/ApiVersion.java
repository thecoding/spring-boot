package com.example.swagger.stater.annotation;

import java.lang.annotation.*;

/**
 * @author Mirko
 * @Description
 * @createTime 2021年07月01日 00:50:00
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiVersion {

    String[] group();
}
