package Model;

public class Stock {

	private int id;
	private int quantity;
	private Float PrixUnite;
	private String Category;
	private String Description;
	
	
	
	public Stock( int quantity, Float prixUnite, String category, String description) {
		
		super();
		this.quantity = quantity;
		this.PrixUnite = prixUnite;
		this.Category = category;
		this.Description = description;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public Float getPrixUnite() {
		return PrixUnite;
	}



	public void setPrixUnite(Float prixUnite) {
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
