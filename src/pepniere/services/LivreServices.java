/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepniere.services;

import pepniere.entitys.Livre;
import pepniere.entitys.Produit;

import pepniere.services.LivreServices;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class LivreServices {
        static Connection cn = Connexion.getInstance().getConnection();
      static  Produit p1 ;

     public LivreServices () {} ;
        public  void ajoutLivre(Livre  l) 
       {           
           
           try {
               String requete="INSERT INTO Produit(nom,image,categorieProduit,quantite,prix,description,titre,auteur,id_user,dateajout) values ('"+l.getNom()+"','"+l.getImage()+"','"+"Livre"+"','"+l.getQuantite()+"','"+l.getPrix()+"','"+l.getDescription()+"','"+l.getTitre()+"','"+l.getAuteur()+"','"+l.getId_user()+"','"+l.getDateAjout()+"')";
              
               Statement st;
               st = cn.createStatement();
               st.executeUpdate(requete);
            
        } catch (SQLException ex) {
            System.err.println("Error d'insertion"+ex);
        }
       
       }
        
        
        
            public  void supprimerLivre(int id) 
              {
                     try {
               cn.createStatement().execute("Delete from Produit where id_Produit="+id+";");
               
        } catch (SQLException ex) {
            System.err.println("Error d'suppression"+ex);
        }
              
              }
            
            
            
            
             
    public void updateLivre(Livre l, int id ) throws SQLException {
         try {
            Statement statement= cn.createStatement();
            String requete="update Produit set nom='"+l.getNom()+"' ,  image='"+l.getImage()+"' ,  quantite='"+l.getQuantite()+"' ,  prix='"+l.getPrix()+"' ,  description='"+l.getDescription()+"' ,  titre='"+l.getTitre()+"' ,  auteur='"+l.getAuteur()+"'where id_Produit= '"+id+"'";
            statement.executeUpdate(requete);
            System.out.print("Updated !!");
        } catch (SQLException e) {
            e.printStackTrace();
        } 

        
    }
    public List<Livre> listerLivres(int id){
    List<Livre> mylist = new ArrayList();
    try{
    String requet = "select nom,image,description,quantite,prix,titre,auteur,id_Produit from produit where categorieProduit = 'livre' and id_user ="+id;
    Statement st2 = cn.createStatement();
        ResultSet rs = st2.executeQuery(requet);
        while(rs.next())
        {
        Livre ps = new Livre();
        ps.setNom(rs.getString(1));
        ps.setImage(rs.getString(2));
                ps.setDescription(rs.getString(3));
        ps.setQuantite(rs.getInt(4));
        ps.setPrix(rs.getInt(5));
        ps.setTitre(rs.getString(6));
        ps.setAuteur(rs.getString(7));
        
       ps.setId_produit(rs.getInt(8));


        mylist.add(ps);
        }
    }
    catch(SQLException Ex)
            {System.out.print("errreur de selection");}
    
    
    return mylist;
    }
    public Livre findProductById(int id){
    Livre ps = null;
       
     try{
       String requet = "select * from produit where categorieProduit = 'livre' AND id_Produit="+id;
    Statement st2 = cn.createStatement();
        ResultSet rs = st2.executeQuery(requet);
        while(rs.next())
        {
       
        ps.setNom(rs.getString(1));
        ps.setImage(rs.getString(2));
        ps.setDescription(rs.getString(3));
        ps.setQuantite(rs.getInt(4));
        ps.setPrix(rs.getInt(5));
        ps.setTitre(rs.getString(6));
        ps.setAuteur(rs.getString(7));
        
       ps.setId_produit(rs.getInt(8));


       
        }
    }
    catch(SQLException Ex)
            {System.out.print("errreur de selection");} 
    
    
    return ps;
    
    
    }          
    
    public void afficherListeLivres(int id)
            {
               List<Livre> arrayList = listerLivres(id);
        for(Livre m : arrayList){
           System.out.println(m.getNom()+","+m.getImage()+","+m.getQuantite()+","+m.getPrix()+","+m.getDescription()+","+m.getTitre()+","+m.getAuteur());
        }
            
            }
  
    
    }
