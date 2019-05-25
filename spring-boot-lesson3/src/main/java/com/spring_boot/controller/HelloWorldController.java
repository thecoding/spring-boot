package com.spring_boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhouchao on 18/12/28.
 */

@RestController
public class HelloWorldController {


//    @RequestMapping("/")
//    public User getUser(){
//        User user = new User();
//        user.setPassWord("18");
//        user.setUserName("明明");
//        user.setUserSex("男");
//        return user;
//    }

    @RequestMapping("/hello")
    public String getStr(){
        return "hello";
    }
}
