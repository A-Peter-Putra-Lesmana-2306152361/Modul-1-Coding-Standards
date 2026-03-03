package id.ac.ui.cs.advprog.eshop.repository;

import java.util.List;

public interface BaseRepository<T, ID> {
    T create(T entity);
    List<T> findAll();
    T findById(ID id);
    T update(ID id, T entity);
    void delete(ID id);
}