package by.alex.dao;

import by.alex.entity.City;
import by.alex.util.ConnectionManager;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class CityDao implements Dao<Integer, City> {
    private static final CityDao INSTANCE = new CityDao();
    private static final String FIND_ALL_SQL = """
            SELECT id,
                   name
            FROM city
            """;
    @Override
    public List<City> findAll() {
        List<City> cities = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_SQL)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                cities.add(buidCity(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cities;
    }

    @Override
    public Optional<City> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void update(Integer entity) {

    }

    @Override
    public boolean save(City entity) {
        return false;
    }

    @Override
    public boolean delete(City entity) {
        return false;
    }

    private City buidCity(ResultSet resultSet) throws SQLException {
        return City.builder()
                .id(resultSet.getInt("id"))
                .name(resultSet.getString("name"))
                .build();
    }

    public static CityDao getInstance() {
        return INSTANCE;
    }
}
