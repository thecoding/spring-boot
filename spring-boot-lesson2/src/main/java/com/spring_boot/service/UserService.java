package com.spring_boot.service;

import com.spring_boot.bean.User;

import java.util.List;

/**
 * Created by zhouchao on 19/1/17.
 */
public interface UserService {

    List<User> getAll();

    void insert(User user);

    void delete(Long id);

    void update(User user);

    User getOne(Long id);

    User getOneUser();

}
