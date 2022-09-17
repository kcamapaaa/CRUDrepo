package com.Vladislav.repository;

import java.util.List;

public interface GenericRepository<T, ID> {
    T getById(ID id);
    List<T> getAll();
    T save(T t);
    void update(T t, Long id);
    void deleteById(ID id);
}
