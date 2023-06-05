package by.alex.dao;

import by.alex.entity.Address;
import by.alex.entity.Apartment;
import by.alex.entity.enums.LeaseTerm;
import by.alex.entity.enums.PropertyType;
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
public class ApartmentDao implements Dao<Integer, Apartment> {
    private static final AddressDao ADDRESS_DAO = AddressDao.getInstance();
    private static final ApartmentDao INSTANCE = new ApartmentDao();
    private static final String FIND_ALL_SQL = """
            SELECT
                id,
                property_type,
                year_built,
                pet_friendly,
                furnished,
                lease_term,
                address
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
                address
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
    @SneakyThrows
    public Optional<Apartment> findById(Integer id) {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_SQL)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Apartment apartment = null;

            if (resultSet.next()) {
                apartment = build(resultSet);
            }
            return Optional.ofNullable(apartment);
        }
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

    private Apartment build(ResultSet resultSet) throws SQLException {
        return Apartment.builder()
                .id(resultSet.getInt("id"))
                .propertyType(PropertyType.valueOf(resultSet.getString("property_type").toUpperCase()))
                .yearBuilt(resultSet.getTimestamp("year_built").toLocalDateTime())
                .petFriendly(resultSet.getBoolean("pet_friendly"))
                .furnished(resultSet.getBoolean("furnished"))
                .leaseTerm(LeaseTerm.valueOf(resultSet.getString("lease_term").toUpperCase()))
                .address(ADDRESS_DAO.findById(
                        resultSet.getInt("address"))
                        .orElse(new Address()))
                .build();
    }

    public static ApartmentDao getInstance() {
        return INSTANCE;
    }
}
