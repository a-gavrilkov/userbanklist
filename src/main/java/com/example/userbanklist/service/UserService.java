package com.example.userbanklist.service;

import com.example.userbanklist.entity.User;

import java.sql.SQLException;

public interface UserService {
    User getRichestUser() throws SQLException;
}
