/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepniere.entitys;

/**
 *
 * @author ASUS
 */
public class Livre  extends Produit{
    private int id_plante;
    private String titre;
    private String auteur;

    public Livre(){};

    public Livre(String titre, String auteur, String nom, String image, String categorie, int quantite, String description, float prix, int id_user,String dateAjout) {
        super(nom, image, categorie, quantite, description, prix, id_user,dateAjout);
        this.titre = titre;
        this.auteur = auteur;
    }

 
  
    
    
    

    public int getId_plante() {
        return id_plante;
    }

    public void setId_plante(int id_plante) {
        this.id_plante = id_plante;
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
    
    
    
    
}
