package by.alex.util;

import com.zaxxer.hikari.HikariDataSource;
import lombok.experimental.UtilityClass;

import java.sql.Connection;
import java.sql.SQLException;

@UtilityClass
public class ConnectionManager {
    private static final String DRIVER_CLASS_KEY = "db.driver.class";
    private static final String USERNAME_KEY = "db.username";
    private static final String PASSWORD_KEY = "db.password";
    private static final String URL_KEY = "db.url";
    private final HikariDataSource config;

    static {
        config = new HikariDataSource();

        config.setDriverClassName(PropertiesUtil.get(DRIVER_CLASS_KEY));

        config.setJdbcUrl(PropertiesUtil.get(URL_KEY));
        config.setUsername(PropertiesUtil.get(USERNAME_KEY));
        config.setPassword(PropertiesUtil.get(PASSWORD_KEY));
    }

    public static Connection getConnection() throws SQLException {
        return config.getConnection();
    }
}
