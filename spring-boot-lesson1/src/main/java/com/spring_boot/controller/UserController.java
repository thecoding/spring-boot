package com.spring_boot.controller;

import com.spring_boot.bean.Book;
import com.spring_boot.bean.User;
import com.spring_boot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zhouchao on 18/12/29.
 */
@RestController
public class UserController {


    private UserMapper userMapper;

    @RequestMapping("/getUsers")
    public List<User> getUsers() {
        List<User> users=userMapper.getAll();
        return users;
    }

    @RequestMapping("/getUser")
    public User getUser(Long id) {
        User user=userMapper.getOne(id);
        return user;
    }

    @RequestMapping("/add")
    public void save(User user) {
        userMapper.insert(user);
    }

    @RequestMapping(value="update")
    public void update(User user) {
        userMapper.update(user);
    }

    @RequestMapping(value="/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        userMapper.delete(id);
    }


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("secondJdbcTemplate")
    JdbcTemplate jdbcTemplate2;


    @RequestMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return jdbcTemplate.query("select * from user", new BeanPropertyRowMapper<>(User.class));
    }

    @RequestMapping("/update28")
    public User update(){
        jdbcTemplate.update("update user set userName = '小李' where id = '28' ");
        return jdbcTemplate.query("select * from user where id = '28' ", new BeanPropertyRowMapper<>(User.class)).get(0);
    }


    @RequestMapping("/addBook")
    public String addBook(){
        Book book = new Book();
        book.setBookName("name");
        book.setBookSize("12m");
        book.setBookTitle("hasRead");
        jdbcTemplate2.update(" insert into book(book_name,book_size,book_title) values (?,?,?)", book.getBookName(),book.getBookSize(),book.getBookTitle());
        return "Y";
    }

    @RequestMapping("/getBooks")
    public List<Book> getBooks(){
        return jdbcTemplate2.query("select id,book_name,book_size,book_title from book",new BeanPropertyRowMapper<Book>(Book.class));
    }

}
