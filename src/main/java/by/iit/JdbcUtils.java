package by.iit;

import uk.org.webcompere.lightweightconfig.ConfigLoader;

import java.util.Properties;

public class JdbcUtils {

    private JdbcUtils() {
    }

    protected static final Properties PROPERTIES = ConfigLoader.loadPropertiesFromResource(
            "school_db.properties");
}
