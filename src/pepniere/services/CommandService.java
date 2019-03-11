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
import pepniere.entitys.Command;

/**
 *
 * @author Nassreddine
 */
public class CommandService {
        Connection connection = null;
     public CommandService(){
       connection = DataSource.getInstance().getConnection();
     }  
     public void addCommande(Command c){
         String request = "insert into `Command` SET quantite=?,prix_total=?,date_ajout=?,categorie_produit=?,categorie_plante=?,id_user=?,id_produit=?";
         try{
         PreparedStatement st = connection.prepareStatement(request);
        st.setInt(1,c.getQuantite());
        st.setDouble(2, c.getPrix_total());
        st.setString(3,c.getDateAdd());
        st.setString(4,c.getCtegorieProduit());
        st.setString(5,c.getCategoriePlante());
        st.setInt(6,c.getId_user());
        st.setInt(7,c.getId_produit());
         st.executeUpdate();
         }catch(Exception ex){
             System.out.println("Error in methode addCommand"+ex.getMessage());
         }
     }
    public int nbComand(){
      int nb=0;
       String request = "SELECT count(*) FROM command";
       try{
           PreparedStatement st;
            st = connection.prepareStatement(request);
            ResultSet rs = st.executeQuery();
             while(rs.next()){
              nb = rs.getInt(1);
            }
       }catch(Exception ex){
           System.out.println("exeptionn in nb commande"+ex);
       }
      return nb;
    }
      public int nbComandById(int id){
      int nb=0;
       String request = "SELECT count(*) FROM command WHERE id_user=?";
       try{
           PreparedStatement st;
            st = connection.prepareStatement(request);
             st.setInt(1,id);
            ResultSet rs = st.executeQuery();
             while(rs.next()){
              nb = rs.getInt(1);
            }
       }catch(Exception ex){
           System.out.println("exeptionn in nb commande"+ex);
       }
      return nb;
    }
   public int nbCatPlante(){
      int nb = 0;
      
      String request = "SELECT count(*) FROM command WHERE categorie_produit=?";
        try{
           PreparedStatement st;
            st = connection.prepareStatement(request);
            st.setString(1,"plante");
            ResultSet rs = st.executeQuery();
             while(rs.next()){
              nb = rs.getInt(1);
            }
       }catch(Exception ex){
           System.out.println("exeptionn in nb commande"+ex);
       }
      return nb;
   }
      public int nbCatLivre(){
      int nb = 0;
      
      String request = "SELECT count(*) FROM command WHERE categorie_produit=?";
        try{
           PreparedStatement st;
            st = connection.prepareStatement(request);
            st.setString(1,"livre");
            ResultSet rs = st.executeQuery();
             while(rs.next()){
              nb = rs.getInt(1);
            }
       }catch(Exception ex){
           System.out.println("exeptionn in nb commande"+ex);
       }
      return nb;
   }
         public int nbCatMed(){
      int nb = 0;
      
      String request = "SELECT count(*) FROM command WHERE categorie_produit=?";
        try{
           PreparedStatement st;
            st = connection.prepareStatement(request);
            st.setString(1,"Medicament1");
            ResultSet rs = st.executeQuery();
             while(rs.next()){
              nb = rs.getInt(1);
            }
       }catch(Exception ex){
           System.out.println("exeptionn in nb commande"+ex);
       }
      return nb;
   }
      public int nbCatAccesoire(){
      int nb = 0;
      
      String request = "SELECT count(*) FROM command WHERE categorie_produit=?";
        try{
            PreparedStatement st;
            st = connection.prepareStatement(request);
            st.setString(1,"decore");
            ResultSet rs = st.executeQuery();
             while(rs.next()){
              nb = rs.getInt(1);
            }
       }catch(Exception ex){
           System.out.println("exeptionn in nb commande"+ex);
       }
      return nb;
   }
  public ArrayList<Command> findCommandById(int id) {
      ArrayList<Command> arrayList = new ArrayList<Command>();
        Command cmd = null;
        String request = "SELECT * FROM `command` WHERE id_user=?";
         try{
            PreparedStatement st;
            st = connection.prepareStatement(request);
             st.setInt(1,id);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
             cmd = new Command(rs.getInt(1),rs.getInt(2),rs.getFloat(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8));
              arrayList.add(cmd);
            }
        }catch(Exception ex ){
            System.out.println("Error find ProductById  " +ex);
        }
        return arrayList;
    }  
    public ArrayList<Command> findAllCommand() {
      ArrayList<Command> arrayList = new ArrayList<Command>();
        Command cmd = null;
        String request = "SELECT * FROM `command`";
         try{
            PreparedStatement st;
            st = connection.prepareStatement(request);
 
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
             cmd = new Command(rs.getInt(1),rs.getInt(2),rs.getFloat(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8));
              arrayList.add(cmd);
            }
        }catch(Exception ex ){
            System.out.println("Error find ProductById  " +ex);
        }
        return arrayList;
    } 
    
    // delete comannd
    public void deleteCommand(int id) {
        try {
              String request = "delete from command where id_command=?";
         
               PreparedStatement  st = connection.prepareStatement(request);
               st.setInt(1,id);
               st.executeUpdate();
        } catch (Exception ex) {
             System.out.println("erroe in delete Commande "+ex);
        }
    }
}
