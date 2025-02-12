package Model;

public class Stock {

	private int id;
	private String nom;
	private int quantity;
	private Float PrixUnite;
	private String Category;
	private String Description;
	
	
	
	public Stock( int quantity,String nom, Float prixUnite, String category, String description) {
		
		super();
		this.quantity = quantity;
		this.PrixUnite = prixUnite;
		this.Category = category;
		this.Description = description;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
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
