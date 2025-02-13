package Model;

public class Stock {
    private int id;
    private String nom;
    private int quantity;
    private Float PrixUnite;
    private String Category;
    private String Description;

    // Constructor without ID (for inserting a new stock)
    public Stock(String nom, int quantity, Float prixUnite, String category, String description) {
        this.nom = nom;
        this.quantity = quantity;
        this.PrixUnite = prixUnite;
        this.Category = category;
        this.Description = description;
    }

    // Constructor with ID (for retrieving or updating an existing stock)
    public Stock(int id, String nom, int quantity, float prixUnite, String category, String description) {
        this.id = id;
        this.nom = nom;
        this.quantity = quantity;
        this.PrixUnite = prixUnite;
        this.Category = category;
        this.Description = description;
    }

    // Getter and Setter for ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for Nom
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getter and Setter for Quantity
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Getter and Setter for PrixUnite
    public Float getPrixUnite() {
        return PrixUnite;
    }

    public void setPrixUnite(Float prixUnite) {
        this.PrixUnite = prixUnite;
    }

    // Getter and Setter for Category
    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        this.Category = category;
    }

    // Getter and Setter for Description
    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }
}
