package by.alex.dao;

import by.alex.entity.Street;
import by.alex.util.ConnectionManager;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class StreetDao implements Dao<Integer, Street> {
    private static final StreetDao INSTANCE = new StreetDao();
    private static final String FIND_BY_ID = """
            SELECT id, name, zip_code
            FROM street
            WHERE id = ?
            """;

    @Override
    public List<Street> findAll() {
        return null;
    }

    @Override
    @SneakyThrows
    public Optional<Street> findById(Integer id) {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Street street = null;

            if (resultSet.next()) {
                street = build(resultSet);
            }
            return Optional.ofNullable(street);
        }
    }

    @Override
    public void update(Integer entity) {

    }

    @Override
    public boolean save(Street entity) {
        return false;
    }

    @Override
    public boolean delete(Street entity) {
        return false;
    }

    public static StreetDao getInstance() {
        return INSTANCE;
    }

    private Street build(ResultSet resultSet) throws SQLException {
        return Street.builder()
                .id(resultSet.getInt("id"))
                .name(resultSet.getString("name"))
                .zipCode(resultSet.getString("zip_code"))
                .build();
    }
}
