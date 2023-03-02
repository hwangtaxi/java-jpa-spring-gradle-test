package com.github.teocci.javajpaspringgradle.services;

import java.util.List;

public interface GenericService<T, ID> {
    T save(T entity);
    List<T> findAll();
    T findById(ID id);
    void delete(T entity);
}
