package com.example.userbanklist.dao.impl;

import com.example.userbanklist.dao.UserDao;
import com.example.userbanklist.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends DaoImpl<User> implements UserDao {

    protected UserDaoImpl(SessionFactory sessionFactory) {
        super(User.class, sessionFactory);
    }
}
