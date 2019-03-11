/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepniere.entitys;

import static java.sql.JDBCType.NULL;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;



/**
 *
 * @author HP
 */
public class Annonce {

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }
    public int id_annonce;
   public int type;
   public String type_produit;
   public int id_produit;
   

    public Annonce(int type, String type_produit, String description, java.sql.Date date_annonce, float prix, String img_url,int id_produit,int id_user) {
        this.type = type;
        this.type_produit = type_produit;
        this.description = description;
        this.date_annonce = date_annonce;
        this.prix = prix;
        this.img_url = img_url;
        this.id_produit = id_produit;
        this.id_user=id_user;
    }
     public Annonce(int type, String description, java.sql.Date date_annonce, float prix, String img_url) {
        this.type = type;
        
        this.description = description;
        this.date_annonce = date_annonce;
        this.prix = prix;
        this.img_url = img_url;
     }
    
    
     public Annonce(int type, String type_produit, String description, java.sql.Date date_annonce, float prix, String img_url) {
        this.type = type;
        this.type_produit = type_produit;
        this.description = description;
        this.date_annonce = date_annonce;
        this.prix = prix;
        this.img_url = img_url;
     }

    @Override
    public String toString() {
        return "Annonce{" + "id_annonce=" + id_annonce + ", type=" + type + ", type_produit=" + type_produit + ", id_produit=" + id_produit + ", description=" + description + ", date_annonce=" + date_annonce + ", prix=" + prix + ", img_url=" + img_url + '}';
    }
    

    public String getType_produit() {
        return type_produit;
    }

    public void setType_produit(String type_produit) {
        this.type_produit = type_produit;
    }
   public String description;
   public java.sql.Date date_annonce;
  public float prix;
  public String img_url;
  public int id_user;
   
   

    public Annonce(int id_annonce, int type, String description, String date_annonce, float prix,String img_url, int id_user) throws ParseException {
        this.id_annonce = id_annonce;
        this.type = type;
        this.description = description;
        //Date block
        SimpleDateFormat format =new SimpleDateFormat("yyyy/MM/dd");
        Date parsed = format.parse(date_annonce);
        
        this.date_annonce =new java.sql.Date(parsed.getTime());
        this.prix = prix;
        this.img_url = img_url;
        this.id_user = id_user;
    }
   
   

    public int getId_annonce() {
        return id_annonce;
    }

    public void setId_annonce(int id_annonce) {
        this.id_annonce = id_annonce;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate_annonce() {
        return date_annonce;
    }

    public void setDate_annonce(java.sql.Date date_annonce) {
        this.date_annonce = date_annonce;
    }

    public float getPrix() {
        return prix;
    }
    
    public void setPrix(float prix) {
        this.prix = prix;
    }
    
   
    public String getImg_url() {
        return img_url;
    }
    
    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
     public Annonce( int type, String description, java.sql.Date date_annonce)  {
        
        this.type = type;
        this.description = description;
        //Date block
        this.date_annonce=date_annonce;
        
        
        
        
        
        
    }

    public Annonce(int type, String description, java.sql.Date date_annonce, float prix, String img_url, int id_user) {
        this.type = type;
        this.description = description;
        this.date_annonce = date_annonce;
        this.prix = prix;
        this.img_url = img_url;
        this.id_user = id_user;
    }

    

  
   
    
   
    public Annonce() {}
        
    

   
  
  
    

    

}
