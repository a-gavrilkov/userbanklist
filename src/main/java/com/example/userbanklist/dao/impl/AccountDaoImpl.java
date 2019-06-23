package com.example.userbanklist.dao.impl;

import com.example.userbanklist.dao.AccountDao;
import com.example.userbanklist.entity.Account;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl extends DaoImpl<Account> implements AccountDao {

    @Autowired
    public AccountDaoImpl(SessionFactory sessionFactory) {
        super(Account.class, sessionFactory);
    }
}
