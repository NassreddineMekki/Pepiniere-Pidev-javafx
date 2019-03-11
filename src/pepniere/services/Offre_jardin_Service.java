/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepniere.services;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pepiniere.utils.ConnexionDB;
import pepniere.entitys.Offre_jardin;

/**
 *
 * @author Mahmoud
 */
public class Offre_jardin_Service {
    Connection cn = ConnexionDB.getInstance().getConnection();
    
    public void ajouterOffreJardin(Offre_jardin o){
       try {
            String requete =
                    "INSERT INTO offre_jardin (date_debut, date_fin,localisation,prix,description) VALUES (?,?,?,?,?)";
            PreparedStatement st = cn.prepareStatement(requete);
            st.setDate(1, o.getDate_debut());
            st.setDate(2, o.getDate_fin());
            st.setString(3, o.getLocalisation());
            st.setFloat(4, o.getPrix());
            st.setString(5, o.getDescription());
            st.executeUpdate();
            System.out.println("Offre Jardin Ajouteée");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
     public void ModifierOffreJardin(Offre_jardin o,int id) {
        try {
            String requete="update offre_jardin set  date_debut='"+o.getDate_debut()+"' ,  date_fin='"+o.getDate_fin()+"' , localisation='"+o.getLocalisation()+"' , prix='"+o.getPrix()+"' ,  description='"+o.getDescription()+"' where id_offre_jardin= '"+id+"'";
            PreparedStatement st = cn.prepareStatement(requete);
  
            st.executeUpdate(requete);
            System.out.print("Offre Jardin Modifiee");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
      public List<Offre_jardin> listerOffresJardin(){
        List<Offre_jardin> myList = new ArrayList<>();
        try {
            String requete2 = "SELECT * FROM offre_jardin";
            Statement st2 = cn.createStatement();
            ResultSet rs = st2.executeQuery(requete2);
        while (rs.next()){
            Offre_jardin o = new Offre_jardin();
            o.setDate_debut(rs.getDate(2));
            o.setDate_fin(rs.getDate(3));
            o.setLocalisation(rs.getString(4));
            o.setPrix(rs.getInt(5));
            o.setDescription(rs.getString(6));
            myList.add(o);
        }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return myList;
    }
      public void SupprimerOffreJardin(int id) 
              {
                     try {

               
               cn.createStatement().execute("Delete from offre_jardin where id_offre_jardin="+id+";");
               
        }catch (Exception e) {
            System.err.println(e.getMessage());
        }
              
              }
      public List<Offre_jardin> listerOffreJardinClient(int id_user){
        List<Offre_jardin> myList = new ArrayList<>();
        try {
            String requete2 = "SELECT * FROM offre_jardin where id_user='"+id_user+"'";
            Statement st2 = cn.createStatement();
            ResultSet rs = st2.executeQuery(requete2);
        while (rs.next()){
            Offre_jardin o = new Offre_jardin();
            o.setId_offre_jardin(rs.getInt(1));
            o.setDate_debut(rs.getDate(2));
            o.setDate_fin(rs.getDate(3));
            o.setLocalisation(rs.getString(4));
            o.setPrix(rs.getInt(5));
            o.setDescription(rs.getString(6));
            myList.add(o);
        }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return myList;
    }
    
}
