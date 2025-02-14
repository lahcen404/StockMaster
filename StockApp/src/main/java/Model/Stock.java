package Model;

public class Stock {
    private int id;
    private String nom;
    private String description;
    private int quantiteEnStock;
    private double prixUnitaire;
    private String categorie;

    // Constructor for inserting a new stock
    public Stock(String nom, String description, int quantiteEnStock, double prixUnitaire, String categorie) {
        this.nom = nom;
        this.description = description;
        this.quantiteEnStock = quantiteEnStock;
        this.prixUnitaire = prixUnitaire;
        this.categorie = categorie;
    }

    // Constructor for retrieving/updating an existing stock
    public Stock(int id, String nom, String description, int quantiteEnStock, double prixUnitaire, String categorie) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.quantiteEnStock = quantiteEnStock;
        this.prixUnitaire = prixUnitaire;
        this.categorie = categorie;
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

    public int getQuantiteEnStock() {
        return quantiteEnStock;
    }

    public void setQuantiteEnStock(int quantiteEnStock) {
        this.quantiteEnStock = quantiteEnStock;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
}
