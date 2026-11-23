package com.chiayi.springbootmall.dao;

import com.chiayi.springbootmall.dto.UserRegisterRequest;
import com.chiayi.springbootmall.model.User;

public interface UserDao {

    User getUserById(Integer userId);

    User getUserByEmail(String email);

    Integer createUser(UserRegisterRequest userRegisterRequest);


}
