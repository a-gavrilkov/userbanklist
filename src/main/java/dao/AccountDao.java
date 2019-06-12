package dao;

import entity.Account;

import java.sql.SQLException;
import java.util.List;

public interface AccountDao {
    List<Account> getAll() throws SQLException;
}
