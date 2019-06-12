package dao.impl;

import dao.UserDao;
import entity.User;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserDaoImpl extends DaoImpl implements UserDao {

    private List<User> resultSetToUsers(ResultSet resultSet) throws SQLException {
        List<User> list = new LinkedList<>();
        while (resultSet.next()) {
            User user = new User();
            user.setUserId(resultSet.getLong("userid"));
            user.setName(resultSet.getString("name"));
            user.setSureName(resultSet.getString("sureName"));
            list.add(user);
        }
        return list;
    }

    @Override public User getById(long id) throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM user WHERE userid = ?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            return resultSetToUsers(resultSet).get(0);
        }
    }
}
