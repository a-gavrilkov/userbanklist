package com.example.userbanklist.service.impl;

import com.example.userbanklist.dao.AccountDao;
import com.example.userbanklist.entity.Account;
import com.example.userbanklist.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    @Autowired
    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override public long getSumOfAllAccounts() throws SQLException {
        List<Account> list = accountDao.getAll();
        return list.stream().mapToLong(Account::getAccount).sum();
    }

}
