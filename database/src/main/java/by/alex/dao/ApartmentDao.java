package by.alex.dao;

import by.alex.entity.Apartment;

import java.util.List;
import java.util.Optional;

public class ApartmentDao implements Dao<Integer, Apartment> {

    @Override
    public List<Apartment> findAll() {
        return null;
    }

    @Override
    public Optional<Apartment> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void update(Integer entity) {

    }

    @Override
    public boolean save(Apartment entity) {
        return false;
    }

    @Override
    public boolean delete(Apartment entity) {
        return false;
    }
}
