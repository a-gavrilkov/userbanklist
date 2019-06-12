package dao.fakeImpl;

import dao.AccountDao;
import entity.Account;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AccountDaoFakeImpl implements AccountDao {

    private List<Account> storage;

    public AccountDaoFakeImpl(List<Account> storage) {
        this.storage = storage;
    }

    @Override
    public List<Account> getAll() throws SQLException {
        return new ArrayList<>(storage);
    }
}
