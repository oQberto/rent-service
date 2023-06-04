package by.alex.dao;

import by.alex.entity.ApartmentPhoto;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ApartmentPhotoDao implements Dao<Integer, ApartmentPhoto> {
    private static final ApartmentPhotoDao INSTANCE = new ApartmentPhotoDao();

    @Override
    public List<ApartmentPhoto> findAll() {
        return null;
    }

    @Override
    public Optional<ApartmentPhoto> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void update(Integer entity) {

    }

    @Override
    public boolean save(ApartmentPhoto entity) {
        return false;
    }

    @Override
    public boolean delete(ApartmentPhoto entity) {
        return false;
    }

    public static ApartmentPhotoDao getInstance() {
        return INSTANCE;
    }
}
