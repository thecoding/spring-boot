package com.spring_boot.bean;

import java.io.Serializable;

/**
 * Created by zhouchao on 18/12/28.
 */
public class User implements Serializable{

    private long id;
    private String userName;
    private String passWord;
    private String nickName;
    private String userSex;


    public User(){

    }

    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    @Override
    public String toString() {
        return "id = " +id + " userName = " + userName + "  passWord = " + passWord + " nickName = " + nickName;
    }
}
