package banksql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connections {
    private static final String URL = "jdbc:mysql://localhost:3306/bankjava";
    private static final String USER = "root";
    private static final String PASSWORD = "123456787188";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
