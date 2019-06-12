package service.impl;

import dao.AccountDao;
import entity.Account;
import service.AccountService;

import java.sql.SQLException;
import java.util.List;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override public long getSumOfAllAccounts() throws SQLException {
        List<Account> list = accountDao.getAll();
        return list.stream().mapToLong(Account::getAccount).sum();
    }

}
