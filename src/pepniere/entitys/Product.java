/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepniere.entitys;

import java.sql.Date;

/**
 *
 * @author Nassreddine
 */
public class Product {
    private int id_produit;
    private String nom;
    private String image;
    private String description;
    private String categorie_produit;
    private int quantite;
    private float prix;
    private String categorie_plante;
    private String type_categorie_plante;
    private String dure_vie_plante;
    private String origin_plante;
    private int poids;
    private String saison;
    private int taille;
    private String couleur;
    private String referance;
    private String marque;
    private String titre;
    private String auteur;
    private String dateAjout;
    private int id_user;


 public Product(int id_produit,String nom, String image, String description, String categorie_produit, int quantite, float prix, String marque,String dateAjout, int id_user) {
        this.id_produit=id_produit;
        this.nom = nom;
        this.image = image;
        this.description = description;
        this.categorie_produit = categorie_produit;
        this.quantite = quantite;
        this.prix = prix;
        this.marque = marque;
        this.dateAjout=dateAjout;
        this.id_user = id_user;
    }

    public Product(int id_produit, String nom, String image, String description, String categorie_produit, int quantite,float prix,
            String categorie_plante, String type_categorie_plante, String dure_vie_plante, String origin_plante, int poids, 
            String saison, int taille, String couleur, String referance, String marque, String titre, String auteur, String dateAjout, int id_user) {
        this.id_produit = id_produit;
        this.nom = nom;
        this.image = image;
        this.description = description;
        this.categorie_produit = categorie_produit;
        this.quantite = quantite;
        this.prix=prix;
        this.categorie_plante = categorie_plante;
        this.type_categorie_plante = type_categorie_plante;
        this.dure_vie_plante = dure_vie_plante;
        this.origin_plante = origin_plante;
        this.poids = poids;
        this.saison = saison;
        this.taille = taille;
        this.couleur = couleur;
        this.referance = referance;
        this.marque = marque;
        this.titre = titre;
        this.auteur = auteur;
         this.dateAjout=dateAjout;
        this.id_user = id_user;
    }

    
 
   

    public Product(int id_produit, String nom, String image, String description, String categorie_produit, int quantite, float prix,
            String categorie_plante, String marque,String dateAjout ,int id_user) {
        this.id_produit = id_produit;
        this.nom = nom;
        this.image = image;
        this.description = description;
        this.categorie_produit = categorie_produit;
        this.quantite = quantite;
        this.prix = prix;
        this.categorie_plante = categorie_plante;
        this.marque = marque;
        this.dateAjout=dateAjout;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategorie_produit() {
        return categorie_produit;
    }

    public void setCategorie_produit(String categorie_produit) {
        this.categorie_produit = categorie_produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getCategorie_plante() {
        return categorie_plante;
    }

    public void setCategorie_plante(String categorie_plante) {
        this.categorie_plante = categorie_plante;
    }

    public String getType_categorie_plante() {
        return type_categorie_plante;
    }

    public void setType_categorie_plante(String type_categorie_plante) {
        this.type_categorie_plante = type_categorie_plante;
    }

    public String getDure_vie_plante() {
        return dure_vie_plante;
    }

    public void setDure_vie_plante(String dure_vie_plante) {
        this.dure_vie_plante = dure_vie_plante;
    }

    public String getOrigin_plante() {
        return origin_plante;
    }

    public void setOrigin_plante(String origin_plante) {
        this.origin_plante = origin_plante;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public String getSaison() {
        return saison;
    }

    public void setSaison(String saison) {
        this.saison = saison;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getReferance() {
        return referance;
    }

    public void setReferance(String referance) {
        this.referance = referance;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(String dateAjout) {
        this.dateAjout = dateAjout;
    }

    @Override
    public String toString() {
        return "Product{" + "id_produit=" + id_produit + ", nom=" + nom + ", image=" + image + ", description=" + description + ", categorie_produit=" 
                + categorie_produit + ", quantite=" + quantite + ", prix=" + prix + ", categorie_plante=" + categorie_plante + ", type_categorie_plante=" 
                + type_categorie_plante + ", dure_vie_plante=" + dure_vie_plante + ", origin_plante=" + origin_plante + ", poids=" + poids + ", saison=" 
                + saison + ", taille=" + taille + ", couleur=" + couleur + ", referance=" + referance + ", marque=" + marque + ", titre=" 
                + titre + ", auteur=" + auteur + ", dateAjout=" + dateAjout + ", id_user=" + id_user + '}';
    }

    
    
    
    
    
}
