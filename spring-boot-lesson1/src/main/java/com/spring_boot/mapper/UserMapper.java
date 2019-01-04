package com.spring_boot.mapper;

import com.spring_boot.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by zhouchao on 18/12/29.
 */
public interface UserMapper{


    @Select("select * from user")
    @Results({
            @Result(property = "userSex", column = "user_sex"),
            @Result(property = "nickName", column = "nick_name")
    })
    List<User> getAll();


    @Insert("INSERT INTO user(userName,passWord) VALUES(#{userName}, #{passWord})")
    void insert(User user);

    @Delete("DELETE FROM user WHERE id =#{id}")
    void delete(Long id);

    @Update("UPDATE user SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
    void update(User user);


    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results({
            @Result(property = "userSex",  column = "user_sex"),
            @Result(property = "nickName", column = "nick_name")
    })
    User getOne(Long id);
}
