/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepniere.services;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pepiniere.utils.ConnexionDB;
import pepniere.entitys.Offre_PlantSitting;

/**
 *
 * @author Mahmoud
 */
public class Offre_PlantSitting_Service {

    public Offre_PlantSitting_Service()
    {
    }
    Connection cn = ConnexionDB.getInstance().getConnection();
    
    public void ajouterOffrePlantSitting(Offre_PlantSitting o,int id_user){
       try {
            String requete =
                    "INSERT INTO offre_local (localisation, quantite_max,date_debut,date_fin,prix,description,type,id_user) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement st = cn.prepareStatement(requete);
            st.setString(1, o.getLocalisation());
            st.setInt(2, o.getQuantite_max());
            st.setDate(3, o.getDate_debut());
            st.setDate(4, o.getDate_fin());
            st.setFloat(5, o.getPrix());
            st.setString(6, o.getDescription());
            st.setInt(7, 1);
            st.setInt(8, id_user);
            st.executeUpdate();
            System.out.println("Offre PlantSitting Ajouteée");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public void ModifierOffrePlantSitting(Offre_PlantSitting o,int id) {
        try {
            String requete="update offre_local set localisation='"+o.getLocalisation()+"' , quantite_max='"+o.getQuantite_max()+"' ,  date_debut='"+o.getDate_debut()+"' ,  date_fin='"+o.getDate_fin()+"' ,  prix='"+o.getPrix()+"' ,  description='"+o.getDescription()+"' where id_offre= '"+id+"'";
            PreparedStatement st = cn.prepareStatement(requete);
  
            st.executeUpdate(requete);
            System.out.print("Offre PlantSitting Modifiee");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public List<Offre_PlantSitting> listerOffres(){
        List<Offre_PlantSitting> myList = new ArrayList<>();
        try {
            String requete2 = "SELECT * FROM offre_local where type=1";
            Statement st2 = cn.createStatement();
            ResultSet rs = st2.executeQuery(requete2);
        while (rs.next()){
            Offre_PlantSitting o = new Offre_PlantSitting();
            o.setId_offre(rs.getInt(1));
            o.setLocalisation(rs.getString(2));
            o.setQuantite_max(rs.getInt(3));
            o.setDate_debut(rs.getDate(4));
            o.setDate_fin(rs.getDate(5));
            o.setPrix(rs.getInt(6));
            o.setDescription(rs.getString(7));
            o.setId_user(rs.getInt(9));
            myList.add(o);
        }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return myList;
    }
     public List<Offre_PlantSitting> listerOffreClient(int id_user){
        List<Offre_PlantSitting> myList = new ArrayList<>();
        try {
            String requete2 = "SELECT * FROM offre_local where type=1 and id_user='"+id_user+"'";
            Statement st2 = cn.createStatement();
            ResultSet rs = st2.executeQuery(requete2);
        while (rs.next()){
            Offre_PlantSitting o = new Offre_PlantSitting();
            o.setId_offre(rs.getInt(1));
            o.setLocalisation(rs.getString(2));
            o.setQuantite_max(rs.getInt(3));
            o.setDate_debut(rs.getDate(4));
            o.setDate_fin(rs.getDate(5));
            o.setPrix(rs.getInt(6));
            o.setDescription(rs.getString(7));
            myList.add(o);
        }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return myList;
    }
    public void SupprimerOffrePlantSitting(int id) 
              {
                     try {

               
               cn.createStatement().execute("Delete from offre_local where id_offre="+id+";");
               
        }catch (Exception e) {
            System.err.println(e.getMessage());
        }
              
              }
    
}
    

