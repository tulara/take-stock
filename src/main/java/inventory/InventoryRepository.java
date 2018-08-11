package inventory;

import database.IDatabaseConnector;

import java.sql.*;

public class InventoryRepository {
    private Connection connection;
    private static String INSERT = "INSERT INTO inventory(name) VALUES(?)";

    public InventoryRepository(IDatabaseConnector connector){
        this.connection = connector.connect();
    }

    public long insertStock(String name) {
        long id = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, name);
            int affectedRows = statement.executeUpdate();
            if(affectedRows> 0){
                ResultSet results = statement.getGeneratedKeys();
                if(results.next()){
                    id = results.getLong(1);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}
