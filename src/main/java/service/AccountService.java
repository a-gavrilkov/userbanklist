package service;

import java.sql.SQLException;

public interface AccountService {
    long getSumOfAllAccounts() throws SQLException;
}
