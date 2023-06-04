package by.alex.dao;

import by.alex.entity.Apartment;
import by.alex.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ApartmentDao implements Dao<Integer, Apartment> {

    private static final String FIND_ALL_SQL = """
            SELECT
                id,
                property_type,
                year_built,
                pet_friendly,
                furnished,
                lease_term,
                address,
                apartment_photo
            FROM apartment;
            """;
    private static final String FIND_BY_ID_SQL = """
            SELECT
                id,
                property_type,
                year_built,
                pet_friendly,
                furnished,
                lease_term,
                address,
                apartment_photo
            FROM apartment
            WHERE id = ?
            """;

    @Override
    public List<Apartment> findAll() {
        List<Apartment> apartmentList = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_SQL)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                apartmentList.add(build(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return apartmentList;
    }

    @Override
    public Optional<Apartment> findById(Integer id) {
        Apartment apartment;
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_SQL)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            apartment = build(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(apartment);
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

    private Apartment build(ResultSet resultSet) {
        return null;
    }
}
