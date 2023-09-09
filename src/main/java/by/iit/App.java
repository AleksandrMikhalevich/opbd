package by.iit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    public static void main(String[] args) {
        try (Statement statement = App.getConnection().createStatement()) {
            try (ResultSet resultSet = statement.executeQuery("select * from users")) {
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt(1) + " "
                            + resultSet.getString(2) + " "
                            + resultSet.getString(3) + " "
                            + resultSet.getString(4) + " "
                            + resultSet.getInt(5));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection conn;
        conn = DriverManager.getConnection(JdbcUtils.PROPERTIES.getProperty("url"),
                JdbcUtils.PROPERTIES.getProperty("user"),
                JdbcUtils.PROPERTIES.getProperty("password"));
        return conn;
    }
}
