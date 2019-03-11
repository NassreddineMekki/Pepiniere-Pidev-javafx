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
public class Soin extends Produit {
    
   private int id_soin ;
   private String reference ;
   private String marque;
  
   public Soin(){};

    public Soin(String reference, String marque, String nom, String image, String categorie, int quantite, String description, float prix, int id_user,String dateAjout) {
        super(nom, image, categorie, quantite, description, prix, id_user,dateAjout);
        this.reference = reference;
        this.marque = marque;
    }

    
   
 
   
   

    public int getId_soin() {
        return id_soin;
    }

    public void setId_soin(int id_soin) {
        this.id_soin = id_soin;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }
    
   
   
}
