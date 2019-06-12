package service.impl;

import dao.AccountDao;
import dao.UserDao;
import entity.Account;
import entity.User;
import exception.UserNotFoundException;
import service.UserService;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private AccountDao accountDao;

    public UserServiceImpl(UserDao userDao, AccountDao accountDao) {
        this.userDao = userDao;
        this.accountDao = accountDao;
    }

    @Override public User getRichestUser() throws SQLException {
        List<Account> list = accountDao.getAll();
        Account richestAccount = list.stream().max(Comparator.comparing(Account::getAccount))
                .orElseThrow(() -> new UserNotFoundException("Richest user not found"));
        return userDao.getById(richestAccount.getUserId());
    }

}
