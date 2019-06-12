package dao.fakeImpl;

import dao.UserDao;
import entity.User;

import java.sql.SQLException;
import java.util.List;

public class UserDaoFakeImpl implements UserDao {

    private List<User> storage;

    public UserDaoFakeImpl(List<User> storage) {
        this.storage = storage;
    }

    @Override
    public User getById(long id) throws SQLException {
        return storage.stream().filter((x) -> x.getUserId().equals(id)).findFirst().get();
    }
}
