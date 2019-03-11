/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepniere.entitys;

import java.util.logging.Logger;

/**
 *
 * @author Nassreddine
 */
public class Produit {
     private int id_produit ;
    private  String nom ;
    private  String image;
    private  String categorie ;
    private   int quantite;
    private String description;
    private  float prix;
    private String categorie_produit;
     private String dateAjout;
    private int id_user;
    
    
      public Produit(){};

    public Produit( String nom, String image, String categorie, int quantite, String description, float prix, int id_accessoire, int id_soin, int id_livre, int id_plante) {
        this.nom = nom;
        this.image = image;
        this.categorie = categorie;
        this.quantite = quantite;
        this.description = description;
        this.prix = prix;
    
    }
     public Produit(String nom, String image, String categorie_produit, float prix) {
        this.nom = nom;
        this.image = image;
        this.categorie_produit = categorie_produit;
        this.prix = prix;
    }

    public Produit(String nom, String image, String categorie, int quantite, String description, float prix) {
        this.nom = nom;
        this.image = image;
        this.categorie = categorie;
        this.quantite = quantite;
        this.description = description;
        this.prix = prix;
    }
    
    
   
    public Produit(String nom, String image, String categorie, int quantite, String description, float prix, int id_user,String dateAjout) {
        this.nom = nom;
        this.image = image;
        this.categorie = categorie;
        this.quantite = quantite;
        this.description = description;
        this.prix = prix;
        this.id_user= id_user;
        this.dateAjout=dateAjout;
    }

    public String getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(String dateAjout) {
        this.dateAjout = dateAjout;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getCategorie_produit() {
        return categorie_produit;
    }

    public void setCategorie_produit(String categorie_produit) {
        this.categorie_produit = categorie_produit;
    }
public Produit(int id_produit, String nom, String categorie_produit, float prix) {
        this.id_produit = id_produit;
        this.nom = nom;
        this.categorie_produit = categorie_produit;
        this.prix = prix;
    }

    public Produit(String nom, String categorie_produit, float prix) {
        this.nom = nom;
        this.categorie_produit = categorie_produit;
        this.prix = prix;
    }
    
}
