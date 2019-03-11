/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepniere.entitys;

/**
 *
 * @author Nassreddine
 */
public class Plante extends Produit{
    private  int 	id_plante; 
  private String categoriePlante;
  private String type_categorie;
  private String duree_vie;
  private String origine;
  private int poids ;
  private String saison;
  private int taille ;
  private String couleur;
  
  public Plante(){};
 
    public Plante(String categoriePlante, String type_categorie, String duree_vie, String origine, int poids, String saison, int taille, String couleur, String nom, String image, String categorie, int quantite, String description, float prix, int id_user,String dateAjout) {
        super(nom, image, categorie, quantite, description, prix, id_user,dateAjout);
        this.categoriePlante = categoriePlante;
        this.type_categorie = type_categorie;
        this.duree_vie = duree_vie;
        this.origine = origine;
        this.poids = poids;
        this.saison = saison;
        this.taille = taille;
        this.couleur = couleur;
    }
    public Plante( String categoriePlante, String type_categorie, String duree_vie, String origine, int poids, String saison, int taille, String couleur, String nom, String image, String categorie, int quantite, String description, float prix) {
        super( nom, image, categorie, quantite, description, prix);
        this.categoriePlante = categoriePlante;
        this.type_categorie = type_categorie;
        this.duree_vie = duree_vie;
        this.origine = origine;
        this.poids = poids;
        this.saison = saison;
        this.taille = taille;
        this.couleur = couleur;
    }

    public int getId_plante() {
        return id_plante;
    }

    public void setId_plante(int id_plante) {
        this.id_plante = id_plante;
    }

    public String getCategoriePlante() {
        return categoriePlante;
    }

    public void setCategoriePlante(String categoriePlante) {
        this.categoriePlante = categoriePlante;
    }

    public String getType_categorie() {
        return type_categorie;
    }

    public void setType_categorie(String type_categorie) {
        this.type_categorie = type_categorie;
    }

    public String getDuree_vie() {
        return duree_vie;
    }

    public void setDuree_vie(String duree_vie) {
        this.duree_vie = duree_vie;
    }

    public String getOrigine() {
        return origine;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
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

    
}
