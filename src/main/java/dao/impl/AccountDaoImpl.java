package dao.impl;

import dao.AccountDao;
import entity.Account;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class AccountDaoImpl extends DaoImpl implements AccountDao {

    private List<Account> resultSetToAccounts(ResultSet resultSet) throws SQLException {
        List<Account> list = new LinkedList<>();
        while (resultSet.next()) {
            Account account = new Account();
            account.setAccountId(resultSet.getLong("accountid"));
            account.setUserId(resultSet.getLong("userid"));
            account.setAccount(resultSet.getLong("account"));
            list.add(account);
        }
        return list;
    }

    @Override public List<Account> getAll() throws SQLException {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM account");
            return resultSetToAccounts(resultSet);
        }
    }
}
