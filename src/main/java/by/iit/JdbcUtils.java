package by.iit;

import uk.org.webcompere.lightweightconfig.ConfigLoader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {

    private JdbcUtils() {
    }

    private static final Properties PROPERTIES = ConfigLoader.loadPropertiesFromResource(
            "school_db.properties");

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(PROPERTIES.getProperty("url"),
                PROPERTIES.getProperty("user"),
                PROPERTIES.getProperty("password"));
    }
}
