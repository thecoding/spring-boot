package com.spring_boot.bean;

import java.io.Serializable;

/**
 * Created by zhouchao on 19/1/2.
 */
public class Book implements Serializable{

    private long id;
    private String bookName;
    private String bookTitle;
    private String bookSize;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookSize() {
        return bookSize;
    }

    public void setBookSize(String bookSize) {
        this.bookSize = bookSize;
    }
}
