package com.example.userbanklist.dao.impl;

import com.example.userbanklist.dao.Dao;
import com.example.userbanklist.entity.AbstractEntity;
import com.example.userbanklist.exception.IdNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public abstract class DaoImpl<T extends AbstractEntity> implements Dao<T> {

    private Class<T> type;
    private SessionFactory sessionFactory;

    protected DaoImpl(Class<T> type, SessionFactory sessionFactory) {
        this.type = type;
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
       return sessionFactory.getCurrentSession();
    }

    @Override
    public T getById(Long id) {
        return Optional
                .ofNullable(getSession().get(type, id))
                .orElseThrow(() -> new IdNotFoundException(id, type));
    }

    @Override
    public List<T> getAll() {
        Session session = getSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(type);
        Root<T> rootEntry = cq.from(type);
        CriteriaQuery<T> all = cq.select(rootEntry);

        TypedQuery<T> allQuery = session.createQuery(all);
        return allQuery.getResultList();
    }
}
