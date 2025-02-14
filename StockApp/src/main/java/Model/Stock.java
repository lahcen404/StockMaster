package Model;

public class Stock {
    private int id;
    private String nom;
    private String description;
    private int quantity;
    private float prixUnite;
    private String category;

    // Constructor with all 
    public Stock(int id, String nom, int quantity, float prixUnite, String category, String description) {
        this.id = id;
        this.nom = nom;
        this.quantity = quantity;
        this.prixUnite = prixUnite;
        this.category = category;
        this.description = description;
    }

    // Constructor without ID 
    public Stock(String nom, int quantity, float prixUnite, String category, String description) {
        this.nom = nom;
        this.quantity = quantity;
        this.prixUnite = prixUnite;
        this.category = category;
        this.description = description;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrixUnite() {
        return prixUnite;
    }

    public void setPrixUnite(float prixUnite) {
        this.prixUnite = prixUnite;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
