package com.spring_boot.controller;

import com.spring_boot.aop.DS;
import com.spring_boot.bean.Book;
import com.spring_boot.bean.User;
import com.spring_boot.mapper.BookMapper;
import com.spring_boot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhouchao on 18/12/29.
 */
@RestController
public class UserController {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BookMapper bookMapper;

    @RequestMapping("/getUsers")
//    @DS
    public List<User> getUsers() {
        List<User> users = userMapper.getAll();
        return users;
    }

    @RequestMapping("/getUser")
    public User getUser(@RequestParam(required = false) Long id) {
        User user;
        if (id != null && id > 0) {
            user = userMapper.getOne(id);
        } else {
            user = userMapper.getOneUser();
        }
        return user;
    }

    @RequestMapping("/add")
    public void save(User user) {
        userMapper.insert(user);
    }

    @RequestMapping(value = "update")
    public void update(User user) {
        userMapper.update(user);
    }

    @RequestMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        userMapper.delete(id);
    }


    @RequestMapping("/getUserAndBook")
    public Map getUserAndBook() {
//        @DS
        User user = getFirstUser();

//        @DS(value = "datasource2")
        Book book = getFirstBook();
        Map map = new HashMap();
        map.put("user", user);
        map.put("book", book);
        return null;
    }

    @DS(value = "datasource2")
    private Book getFirstBook() {
        return bookMapper.getOneBook();
    }

    @DS
    private User getFirstUser(){
        return userMapper.getOneUser();
    }


    @RequestMapping(value = "/getBook")
//    @DS(value = "datasource2")
    public Book getBook() {
        return bookMapper.getOneBook();
    }



}
