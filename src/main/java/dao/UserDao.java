package dao;

import entity.User;

import java.sql.SQLException;

public interface UserDao {
    User getById(long id) throws SQLException;
}
