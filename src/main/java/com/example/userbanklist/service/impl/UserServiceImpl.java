package com.example.userbanklist.service.impl;

import com.example.userbanklist.dao.AccountDao;
import com.example.userbanklist.dao.UserDao;
import com.example.userbanklist.entity.Account;
import com.example.userbanklist.entity.User;
import com.example.userbanklist.exception.UserNotFoundException;
import com.example.userbanklist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private AccountDao accountDao;

    @Autowired
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
