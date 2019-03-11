/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepniere.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import pepiniere.utils.DataSource;
import pepniere.entitys.Product;

/**
 *
 * @author Nassreddine
 */
public class ProductService {
    Connection connection = null;
     public ProductService(){
       connection = DataSource.getInstance().getConnection();
     } 
      public ArrayList<Product> findAllProduct() {
        ArrayList<Product> arrayList = new ArrayList<Product>();
        Product p = null;
        String request = "SELECT * FROM `produit`";
        try{
            PreparedStatement st;
            st = connection.prepareStatement(request);
            ResultSet rs = st.executeQuery();
           /* public Product(int id_produit,
                    String nom,
                    String image,
                    String description,
                    String categorie_produit, 
                    int quantite,
                    String categorie_plante,
                    String type_categorie_plante,
                    String dure_vie_plante,
                    String origin_plante, 
                    int poids,
                    String saison,
                    int taille, 
                    String couleur, 
                    String referance, 
                    String marque, 
                    String titre, 
                    String auteur,
                    int id_user);*/
            while(rs.next()){
             p = new Product(
                   rs.getInt(1),rs.getString(2),rs.getString(3)
                     ,rs.getString(4),rs.getString(5),rs.getInt(6
                     ),rs.getFloat(7),rs.getString(8),rs.getString(9),
                     rs.getString(10),rs.getString(11),rs.getInt(12),rs.getString(13),rs.getInt(14),rs.getString(15),
                     rs.getString(16),rs.getString(17),rs.getString(18),rs.getString(19),rs.getString(20),rs.getInt(21)
             );
              
             arrayList.add(p);
            }
        }catch(Exception ex ){
            System.out.println("Error " +ex);
        }
        return arrayList;
    }
 public void updateProductAfterAddComnd(int id ,int q ){
             String request = "UPDATE produit SET quantite=? WHERE id_Produit=?";
        try{
           PreparedStatement st = connection.prepareStatement(request);
           st.setInt(1, q);
            st.setInt(2, id);
            st.executeUpdate();
        }
        catch(Exception ex){
            System.out.println("erreur update "+ex);
        }
    }
    
 

   
    public Product findProductById(int id) {
        Product p = null;
        String request = "SELECT * FROM `produit` WHERE id_Produit=?";
         try{
            PreparedStatement st;
            st = connection.prepareStatement(request);
             st.setInt(1,id);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
               p = new Product(
                   rs.getInt(1),rs.getString(2),rs.getString(3)
                     ,rs.getString(4),rs.getString(5),rs.getInt(6
                     ),rs.getFloat(7),rs.getString(8),rs.getString(9),
                     rs.getString(10),rs.getString(11),rs.getInt(12),rs.getString(13),rs.getInt(14),rs.getString(15),
                     rs.getString(16),rs.getString(17),rs.getString(18),rs.getString(19),rs.getString(20),rs.getInt(21)
             );
                
            
            }
        }catch(Exception ex ){
            System.out.println("Error find ProductById  " +ex);
        }
        return p;
    }
}
