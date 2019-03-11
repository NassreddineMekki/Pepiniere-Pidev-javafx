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
public class Accessoire extends Produit {
  private  int id_accessoire; 
  private String refrence;
  private String marque;
  private int poids;

  public Accessoire(){};

    public Accessoire(String refrence, String marque, int poids, String nom, String image, String categorie, int quantite, String description, float prix, int id_user,String dateAjout) {
        super(nom, image, categorie, quantite, description, prix, id_user,dateAjout);
        this.refrence = refrence;
        this.marque = marque;
        this.poids = poids;
    }

  

   

 
 
  
  
  
    public int getId_accessoire() {
        return id_accessoire;
    }

    public void setId_accessoire(int id_accessoire) {
        this.id_accessoire = id_accessoire;
    }

    public String getRefrence() {
        return refrence;
    }

    public void setRefrence(String refrence) {
        this.refrence = refrence;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }
  
  
  
    
    
    
}
