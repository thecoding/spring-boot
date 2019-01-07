package com.spring_boot.mapper;

import com.spring_boot.bean.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by zhouchao on 19/1/4.
 */
@Mapper
public interface BookMapper {

    @Select("select * from book")
    @Results({
            @Result(property = "bookName", column = "book_name"),
            @Result(property = "bookSize", column = "book_size"),
            @Result(property = "bookTitle", column = "book_title")
    })
    List<Book> getAll();


    @Insert("INSERT INTO book(book_name,book_size,book_title) VALUES(#{bookName}, #{bookSize}, #{bookTitle})")
    void insert(Book book);

    @Delete("DELETE FROM book WHERE id =#{id}")
    void delete(Long id);

    @Update("UPDATE book SET book_name=#{book_name},book_size=#{book_size},book_title=#{book_title} WHERE id =#{id}")
    void update(Book book);


    @Select("SELECT * FROM book WHERE id = #{id}")
    @Results({
            @Result(property = "bookName", column = "book_name"),
            @Result(property = "bookSize", column = "book_size"),
            @Result(property = "bookTitle", column = "book_title")
    })
    Book getOne(Long id);


    @Select("SELECT * FROM book limit 0,1 ")
    @Results({
            @Result(property = "bookName", column = "book_name"),
            @Result(property = "bookSize", column = "book_size"),
            @Result(property = "bookTitle", column = "book_title")
    })
    Book getOneBook();

}
