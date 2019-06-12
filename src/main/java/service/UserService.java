package service;

import entity.User;

import java.sql.SQLException;

public interface UserService {
    User getRichestUser() throws SQLException;
}
