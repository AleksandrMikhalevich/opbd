package by.iit;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

    public static void main(String[] args) {
        try (Statement statement = JdbcUtils.getConnection().createStatement()) {
            createQuery(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createQuery(Statement statement) {
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
    }
}
