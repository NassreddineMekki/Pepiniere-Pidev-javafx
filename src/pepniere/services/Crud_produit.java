/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepniere.services;


import Utile.Datasource;
import pepniere.entitys.Produit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author HP
 */
public class Crud_produit {
     Connection cn = new Datasource().getInstance().getConnecion();

    public void ajouterProduit(Produit p) {
        String requet = "Insert Into produit Set nom=?,image=?,categorie_produit=?,prix=?";
        try {
            PreparedStatement pr = cn.prepareStatement(requet);
            
            pr.setString(1, p.getNom());
            pr.setString(2, p.getImage());
            pr.setString(3, p.getCategorie_produit());
            pr.setFloat(4, p.getPrix());
            

            pr.executeUpdate();
            
}
        catch (Exception ex) {
            System.out.println("erreur " + ex);

        }
    }
    
     public boolean suppproduit(int id) {
        boolean dell = true;
        try {
            String requete2 = "Delete FROM produit where id_Produit ='"+id+"'";
            PreparedStatement pr = cn.prepareStatement(requete2);
            
            dell = pr.execute();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return dell;
    }
    
    
    
    
    
    
     public void Modifierproduit(Produit p, int id) {
        try {
            String requete = "update produit set nom='" + p.getNom() + "' , image='" + p.getImage() + "' ,  categorie_produit='" + p.getCategorie_produit() + "' ,  prix='" + p.getPrix() + "' where id_Produit= '" + id + "'";
            PreparedStatement st = cn.prepareStatement(requete);

            st.executeUpdate(requete);
            System.out.print("Annonce Modifieeqsdfghjklmùzertyuiop^$");
        } catch (Exception e) {
            System.err.println("erreur in modifier"+e.getMessage());
        }
     }  
        public int rechercherproduit(int id_annonce) {
       int idprod = 0;
        try {
            String requete2 = "select * from produit,annonce where produit.id_Produit=annonce.id_produit and annonce.id_annonce='" + id_annonce + "'";
            Statement st2 = cn.createStatement();
            ResultSet rs = st2.executeQuery(requete2);
            while (rs.next()) {
                System.out.println("recherche reussie");
                idprod=rs.getInt(1);

            }
        } catch (Exception e) {
            System.err.println("errer recherche id"+e.getMessage());
        }
        return idprod;
    }
      public int  RecupererDernier()
    {
       List<Produit> myList = new ArrayList<>();
        try {
            String requete2 = "SELECT id_Produit FROM produit ORDER BY id_Produit DESC LIMIT 1";
            Statement st2 = cn.createStatement();
            ResultSet rs = st2.executeQuery(requete2);
        while (rs.next()){
            int x=rs.getInt(1);
           return x;
        }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return 0;
    }
        
}
