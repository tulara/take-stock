package inventory;

import database.IDatabaseConnector;

import java.sql.*;

public class InventoryRepository {
    private Connection connection;
    private static String INSERT_PRODUCT = "INSERT INTO products(title, author, in_stock) VALUES(?,?,?)";
    private static String INSERT_INVENTORY = "INSERT INTO inventory(product_id, isbn) VALUES(?, ?)";
    private static String SELECT_PRODUCT = "SELECT * FROM products where product_id=?";

    public InventoryRepository(IDatabaseConnector connector){
        this.connection = connector.connect();
    }

    public int insertStock(String title, String author, String isbn) {
        int productId = -1;

        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_PRODUCT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,title);
            statement.setString(2, author);
            statement.setInt(3, 1);

            int affectedRows = statement.executeUpdate();
            if(affectedRows> 0){
                ResultSet results = statement.getGeneratedKeys();
                if(results.next()){
                    productId = results.getInt(1);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_INVENTORY);
            statement.setInt(1, productId);
            statement.setString(2, isbn);

            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return productId;
    }

    public Product getProduct(int productId){
        try {
            PreparedStatement statement= connection.prepareStatement(SELECT_PRODUCT);
            statement.setInt(1,productId);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                return new Product(
                        productId,
                        resultSet.getString("author"),
                        resultSet.getString("title"),
                        resultSet.getInt("in_stock"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
