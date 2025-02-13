package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Stock;

// CRUD Database

public class StockDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/Stock?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "lahcen123";

    private static final String INSERT_STOCK_SQL = "INSERT INTO Produits (nom, description, quantite_en_stock, prix_unitaire, categorie) VALUES (?, ?, ?, ?, ?);";
    private static final String SELECT_STOCK_BY_ID = "SELECT id, nom, description, quantite_en_stock, prix_unitaire, categorie FROM Produits WHERE id=?";
    private static final String SELECT_ALL_STOCK = "SELECT * FROM Produits";
    private static final String DELETE_STOCK_SQL = "DELETE FROM Produits WHERE id=?";
    private static final String UPDATE_STOCK_SQL = "UPDATE Produits SET nom=?, description=?, quantite_en_stock=?, prix_unitaire=?, categorie=? WHERE id=?;";

    public StockDAO() {}

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Updated Driver
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertStock(Stock stock) throws SQLException { // Renamed method to insertStock
        System.out.println(INSERT_STOCK_SQL);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STOCK_SQL)) {
            preparedStatement.setString(1, stock.getNom());
            preparedStatement.setString(2, stock.getDescription());
            preparedStatement.setInt(3, stock.getQuantity());
            preparedStatement.setFloat(4, stock.getPrixUnite());
            preparedStatement.setString(5, stock.getCategory());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Stock selectStock(int id) {
        Stock stock = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STOCK_BY_ID)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet res = preparedStatement.executeQuery();

            while (res.next()) {
                String nom = res.getString("nom");
                String description = res.getString("description");
                int quantiteEnStock = res.getInt("quantite_en_stock");
                float prixUnitaire = res.getFloat("prix_unitaire");
                String categorie = res.getString("categorie");

                // Fixing parameter order for constructor
                stock = new Stock(id, nom, quantiteEnStock, prixUnitaire, categorie, description);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return stock;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
