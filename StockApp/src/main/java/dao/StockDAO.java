package dao;

import Model.Stock;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StockDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/Stock?useSSL=false";
    private String jdbcUsername = "root";  
    private String jdbcPassword = "lahcen123"; 

    private static final String INSERT_STOCK_SQL = "INSERT INTO Produits (nom, description, quantite_en_stock, prix_unitaire, categorie) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_STOCK = "SELECT * FROM Produits";
    private static final String SELECT_STOCK_BY_ID = "SELECT * FROM Produits WHERE ID = ?";
    private static final String UPDATE_STOCK_SQL = "UPDATE Produits SET nom = ?, description = ?, quantite_en_stock = ?, prix_unitaire = ?, categorie = ? WHERE ID = ?";
    private static final String DELETE_STOCK_SQL = "DELETE FROM Produits WHERE ID = ?";

    // Connection method
    protected Connection getConnection() {
        Connection connection = null;
        try {
            //Class.forName("com.mysql.jdbc.Driver");
        	Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(connection);
        return connection;
    }

    // Insert stock
    public void insertStock(Stock stock) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STOCK_SQL)) {
            preparedStatement.setString(1, stock.getNom());
            preparedStatement.setString(2, stock.getDescription());
            preparedStatement.setInt(3, stock.getQuantiteEnStock());
            preparedStatement.setDouble(4, stock.getPrixUnitaire());
            preparedStatement.setString(5, stock.getCategorie());
            preparedStatement.executeUpdate();
        }
    }

    // Retrieve all stocks
    public List<Stock> selectAllStock() throws SQLException {
        List<Stock> stocks = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STOCK);
             ResultSet rs = preparedStatement.executeQuery()) {
        	System.out.println( "connected on " + connection );
            while (rs.next()) {
                stocks.add(new Stock(
                    rs.getInt("ID"),
                    rs.getString("nom"),
                    rs.getString("description"),
                    rs.getInt("quantite_en_stock"),
                    rs.getDouble("prix_unitaire"),
                    rs.getString("categorie")
                ));
            }
        }
        return stocks;
    }

    // Retrieve stock by ID
    public Stock selectStock(int id) throws SQLException {
        Stock stock = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STOCK_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                stock = new Stock(
                    rs.getInt("ID"),
                    rs.getString("nom"),
                    rs.getString("description"),
                    rs.getInt("quantite_en_stock"),
                    rs.getDouble("prix_unitaire"),
                    rs.getString("categorie")
                );
            }
        }
        return stock;
    }

    // Update stock
    public void updateStock(Stock stock) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STOCK_SQL)) {
            preparedStatement.setString(1, stock.getNom());
            preparedStatement.setString(2, stock.getDescription());
            preparedStatement.setInt(3, stock.getQuantiteEnStock());
            preparedStatement.setDouble(4, stock.getPrixUnitaire());
            preparedStatement.setString(5, stock.getCategorie());
            preparedStatement.setInt(6, stock.getId());
            preparedStatement.executeUpdate();
        }
    }

    // Delete stock
    public void deleteStock(int id) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STOCK_SQL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }
}
