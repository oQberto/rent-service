package by.alex.dao;

import by.alex.entity.Apartment;
import by.alex.entity.ApartmentPhoto;
import by.alex.util.ConnectionManager;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ApartmentPhotoDao implements Dao<Integer, ApartmentPhoto> {
    private static final ApartmentDao APARTMENT_DAO = ApartmentDao.getInstance();
    private static final ApartmentPhotoDao INSTANCE = new ApartmentPhotoDao();
    private static final String FIND_BY_APARTMENT_ID_SQL = """
            SELECT *
            FROM apartment_photo
            WHERE apartment_id = ?
            """;

    @SneakyThrows
    public List<ApartmentPhoto> findByApartmentId(Integer id) {
        List<ApartmentPhoto> photos = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_APARTMENT_ID_SQL)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                photos.add(build(resultSet));
            }
            return photos;
        }
    }

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

    private ApartmentPhoto build(ResultSet resultSet) throws SQLException {
        return ApartmentPhoto.builder()
                .id(resultSet.getInt("id"))
                .photoPath(resultSet.getString("photo_path"))
                .apartment(APARTMENT_DAO
                        .findById(resultSet.getInt("apartment_id"))
                        .orElse(new Apartment()))
                .build();
    }

    public static ApartmentPhotoDao getInstance() {
        return INSTANCE;
    }
}
