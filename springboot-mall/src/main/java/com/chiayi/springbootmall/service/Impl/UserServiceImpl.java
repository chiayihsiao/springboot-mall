package com.chiayi.springbootmall.service.Impl;

import com.chiayi.springbootmall.dao.UserDao;
import com.chiayi.springbootmall.dto.UserRegisterRequest;
import com.chiayi.springbootmall.model.User;
import com.chiayi.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }
}
