package by.alex.dao;

import by.alex.entity.Address;
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
public class AddressDao implements Dao<Integer, Address> {
    private static final AddressDao INSTANCE = new AddressDao();
    private static final String FIND_BY_ID_SQL = """
            SELECT
                id,
                street_id,
                city_id,
                house_number
            FROM address
            WHERE id = ?
            """;

    @Override
    public List<Address> findAll() {
        return null;
    }

    @Override
    @SneakyThrows
    public Optional<Address> findById(Integer id) {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_SQL)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Address address = null;

            if (resultSet.next()) {
                address = build(resultSet);
            }
            return Optional.ofNullable(address);
        }
    }

    @Override
    public void update(Integer entity) {

    }

    @Override
    public boolean save(Address entity) {
        return false;
    }

    @Override
    public boolean delete(Address entity) {
        return false;
    }

    private Address build(ResultSet resultSet) throws SQLException {
        return Address.builder()
                .id(resultSet.getInt("id"))
                .street(null)
                .city(null)
                .houseNumber(resultSet.getInt("house_number"))
                .build();
    }

    public static AddressDao getInstance() {
        return INSTANCE;
    }
}
