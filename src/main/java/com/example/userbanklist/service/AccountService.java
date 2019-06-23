package com.example.userbanklist.service;

import java.sql.SQLException;

public interface AccountService {
    long getSumOfAllAccounts() throws SQLException;
}
