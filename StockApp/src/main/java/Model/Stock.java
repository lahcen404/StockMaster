package Model;

public class Stock {

	private int id;
	private String quantity;
	private String PrixUnite;
	private String Category;
	private String Description;
	
	
	
	public Stock(int id, String quantity, String prixUnite, String category, String description) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.PrixUnite = prixUnite;
		this.Category = category;
		this.Description = description;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getPrixUnite() {
		return PrixUnite;
	}
	public void setPrixUnite(String prixUnite) {
		PrixUnite = prixUnite;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
}
