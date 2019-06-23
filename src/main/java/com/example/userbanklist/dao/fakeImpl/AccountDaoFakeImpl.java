package com.example.userbanklist.dao.fakeImpl;

import com.example.userbanklist.dao.AccountDao;
import com.example.userbanklist.entity.Account;

import java.util.List;

public class AccountDaoFakeImpl extends DaoImpl<Account> implements AccountDao {
    public AccountDaoFakeImpl(List<Account> storage) {
        super(storage);
    }
}
