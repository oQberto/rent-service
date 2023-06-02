package by.alex.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T, K> {

    List<K> findAll();

    Optional<K> findById(T id);

    void update(T entity);

    boolean save(K entity);

    boolean delete(K entity);
}
