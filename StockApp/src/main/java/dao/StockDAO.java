package dao;

//CRUD DataBase 

public class StockDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/Stock?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "lahcen123";
	
	private static final String INSERT_STOCK_SQL = "INSERT INTO Produits" +
	"(nom,description,quantite_en_stock,prix_unitaire,categorie) VALUES " + 
			"(?,?,?,?,?);";
	
	private static final String SELECT_STOCK_BY_ID = "select id,nom,description,quantite_en_stock,prix_unitaire,categorie FROM Produits WHERE id=?";
	private static final String SELECT_ALL_STOCK = "select * FROM Produits";
	private static final String DELETE_STOCK_SQL = "delete from Produits WHERE id=?";
	private static final String UPDATE_STOCK_SQL = "update Produits SET nom=?,description=?,quantite_en_stock=?,prix_unitaire=?,categorie=? WHERE id=?;";
	
	
	
}
