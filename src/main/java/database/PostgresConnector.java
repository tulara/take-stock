package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnector implements IDatabaseConnector {
    private static final String url = "jdbc:postgresql://192.168.99.100:32768/takestock";
    private static final String user = "postgres";
    private static final String password = "mysecretpassword";

    public Connection connect(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("connected to postgres");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }
}
