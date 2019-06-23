package com.example.userbanklist.dao;

import com.example.userbanklist.entity.AbstractEntity;

import java.util.List;

public interface Dao<T extends AbstractEntity> {
    T getById(Long id);
    List<T> getAll();
}
