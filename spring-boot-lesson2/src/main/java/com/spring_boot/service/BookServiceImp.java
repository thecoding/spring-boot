package com.spring_boot.service;

import com.spring_boot.aop.DS;
import com.spring_boot.bean.Book;
import com.spring_boot.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhouchao on 19/1/17.
 */
@Service
public class BookServiceImp implements BookService {

    @Autowired
    BookMapper bookMapper;

    @Override
    public List<Book> getAll() {
        return null;
    }

    @Override
    public void insert(Book book) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Book book) {

    }

    @Override
    public Book getOne(Long id) {
        return null;
    }

    @Override
    @DS(value = "datasource2")
    public Book getOneBook() {
        return bookMapper.getOneBook();
    }
}
