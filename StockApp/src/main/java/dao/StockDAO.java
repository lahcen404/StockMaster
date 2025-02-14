package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Stock;

public class StockDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/Stock?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "lahcen123";

    private static final String INSERT_STOCK_SQL = "INSERT INTO stock (nom, quantity, prixUnite, category, description) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_STOCKS = "SELECT * FROM stock";
    private static final String DELETE_STOCK_SQL = "DELETE FROM stock WHERE id = ?";
    private static final String SELECT_STOCK_BY_ID = "SELECT * FROM stock WHERE id = ?";
    private static final String UPDATE_STOCK_SQL = "UPDATE stock SET nom = ?, quantity = ?, prixUnite = ?, category = ?, description = ? WHERE id = ?";

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public void insertStock(Stock stock) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STOCK_SQL)) {
            preparedStatement.setString(1, stock.getNom());
            preparedStatement.setInt(2, stock.getQuantity());
            preparedStatement.setFloat(3, stock.getPrixUnite());
            preparedStatement.setString(4, stock.getCategory());
            preparedStatement.setString(5, stock.getDescription());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Stock> getAllStocks() {
        List<Stock> stocks = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STOCKS);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                int quantity = resultSet.getInt("quantity");
                float prixUnite = resultSet.getFloat("prixUnite");
                String category = resultSet.getString("category");
                String description = resultSet.getString("description");

                stocks.add(new Stock(id, nom, quantity, prixUnite, category, description));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stocks;
    }

    public void deleteStock(int id) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STOCK_SQL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Stock getStockById(int id) {
        Stock stock = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STOCK_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String nom = resultSet.getString("nom");
                int quantity = resultSet.getInt("quantity");
                float prixUnite = resultSet.getFloat("prixUnite");
                String category = resultSet.getString("category");
                String description = resultSet.getString("description");

                stock = new Stock(id, nom, quantity, prixUnite, category, description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stock;
    }

    public void updateStock(Stock stock) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STOCK_SQL)) {
            preparedStatement.setString(1, stock.getNom());
            preparedStatement.setInt(2, stock.getQuantity());
            preparedStatement.setFloat(3, stock.getPrixUnite());
            preparedStatement.setString(4, stock.getCategory());
            preparedStatement.setString(5, stock.getDescription());
            preparedStatement.setInt(6, stock.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
