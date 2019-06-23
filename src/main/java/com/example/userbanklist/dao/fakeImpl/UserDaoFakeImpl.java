package com.example.userbanklist.dao.fakeImpl;

import com.example.userbanklist.dao.UserDao;
import com.example.userbanklist.entity.User;

import java.util.List;

public class UserDaoFakeImpl extends DaoImpl<User> implements UserDao {
    public UserDaoFakeImpl(List<User> storage) {
        super(storage);
    }
}