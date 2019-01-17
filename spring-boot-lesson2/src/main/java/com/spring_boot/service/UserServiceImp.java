package com.spring_boot.service;

import com.spring_boot.aop.DS;
import com.spring_boot.bean.User;
import com.spring_boot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhouchao on 19/1/17.
 */
@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void insert(User user) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public User getOne(Long id) {
        return null;
    }

    @Override
    @DS
    public User getOneUser() {
        return userMapper.getOneUser();
    }
}
