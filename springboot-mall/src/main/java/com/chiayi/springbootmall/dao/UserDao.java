package com.chiayi.springbootmall.dao;

import com.chiayi.springbootmall.dto.UserRegisterRequest;
import com.chiayi.springbootmall.model.User;

public interface UserDao {

    User getUserById(Integer userId);

    Integer createUser(UserRegisterRequest userRegisterRequest);
}
