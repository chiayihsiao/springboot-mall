package com.chiayi.springbootmall.rowmapper;

import com.chiayi.springbootmall.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    public User mapRow(ResultSet resiltSet, int i)throws SQLException{
        User user = new User();
        user.setUserId(resiltSet.getInt("user_id"));
        user.setEmail(resiltSet.getString("email"));
        user.setPassword(resiltSet.getString("password"));
        user.setCreatedDate(resiltSet.getTimestamp("created_date"));
        user.setLastModifiedDate(resiltSet.getTimestamp("last_modified_date"));
        return user;
    }
}
