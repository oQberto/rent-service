package by.alex.util;

import com.zaxxer.hikari.HikariConfig;
import lombok.NoArgsConstructor;
import lombok.experimental.UtilityClass;

import java.sql.Connection;

import static lombok.AccessLevel.PRIVATE;

@UtilityClass
@NoArgsConstructor(access = PRIVATE)
public class ConnectionManager {
    private static final ConnectionManager INSTANCE = new ConnectionManager();
    private static final String USERNAME_KEY = "db.username";
    private static final String PASSWORD_KEY = "db.password";
    private static final String URL_KEY = "db.url";
    private final HikariConfig config = new HikariConfig();

    static {
        config.setJdbcUrl();
    }

    public static Connection getConnection() {
        return null;
    }

    public static ConnectionManager getInstance() {
        return INSTANCE;
    }
}
