package com.example.userbanklist.dao.fakeImpl;

import com.example.userbanklist.dao.Dao;
import com.example.userbanklist.entity.AbstractEntity;
import com.example.userbanklist.exception.IdNotFoundException;

import java.util.ArrayList;
import java.util.List;

public abstract class DaoImpl<T extends AbstractEntity> implements Dao<T> {

    protected List<T> storage;

    public DaoImpl(List<T> storage) {
        this.storage = storage;
    }

    @Override
    public T getById(Long id) {
        return storage.stream().filter((x) -> x.getId().equals(id)).findFirst()
                .orElseThrow(() -> new IdNotFoundException(id, Object.class));
    }

    @Override
    public List<T> getAll() {
        return new ArrayList<>(storage);
    }
}
