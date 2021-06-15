package com.example.spring.ioc.demo1.domain;

import com.example.spring.ioc.demo1.annotation.Super;
import lombok.Data;
import lombok.ToString;

/**
 * @author Mirko
 * @Description
 * @createTime 2021年06月15日 23:24:00
 */
@Data
@ToString
@Super
public class SuperUser extends User{

    private String address;
}
