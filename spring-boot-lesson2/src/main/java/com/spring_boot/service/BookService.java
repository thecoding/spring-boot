package com.spring_boot.service;

import com.spring_boot.bean.Book;

import java.util.List;

/**
 * Created by zhouchao on 19/1/17.
 */
public interface BookService {

    List<Book> getAll();

    void insert(Book book);

    void delete(Long id);

    void update(Book book);


    Book getOne(Long id);

    Book getOneBook();


}
