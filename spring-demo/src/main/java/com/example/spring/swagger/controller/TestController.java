package com.example.spring.swagger.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mirko
 * @Description
 * @createTime 2021年07月01日 00:49:00
 */
@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping("success")
    public String swaggerTest(){
        return "success";
    }
}
