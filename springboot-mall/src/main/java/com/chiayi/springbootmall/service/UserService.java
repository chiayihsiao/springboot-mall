package com.chiayi.springbootmall.service;

import com.chiayi.springbootmall.dao.UserLoginRequest;
import com.chiayi.springbootmall.dto.UserRegisterRequest;
import com.chiayi.springbootmall.model.User;

public interface UserService {

    User getUserById(Integer userId);

    Integer register(UserRegisterRequest userRegisterRequest);

    User login(UserLoginRequest userLoginRequest);
}
