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
import pepniere.entitys.Plante;
import pepniere.entitys.Service_PlantSitting;

/**
 *
 * @author Mahmoud
 */
public class Service_PlantSitting_Service {

    public Service_PlantSitting_Service() {
    }
    
        Connection cn = ConnexionDB.getInstance().getConnection();
    
    public void ajoutServicePlantSitting(Service_PlantSitting o){
       try {
            String requete =
                    "INSERT INTO offre_local (localisation, quantite_max,date_debut,date_fin,prix,description,type) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement st = cn.prepareStatement(requete);
            st.setString(1, o.getLocalisation());
            st.setInt(2, o.getQuantite());
            st.setDate(3, o.getDate_debut());
            st.setDate(4, o.getDate_fin());
            st.setFloat(5, o.getPrix());
            st.setString(6, o.getDescription());
            st.setInt(7, 2);
            st.executeUpdate();
            System.out.println("Service PlantSitting Ajouteée");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void ModifierServicePlantSitting(Service_PlantSitting o,int id) {
        try {
            String requete="update offre_local set localisation='"+o.getLocalisation()+"' , quantite='"+o.getQuantite()+"' ,  date_debut='"+o.getDate_debut()+"' ,  date_fin='"+o.getDate_fin()+"' ,  prix='"+o.getPrix()+"' ,  description='"+o.getDescription()+"' where id_offre= '"+id+"'";
            PreparedStatement st = cn.prepareStatement(requete);
  
            st.executeUpdate(requete);
            System.out.print("Service PlantSitting Modifiee");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public List<Service_PlantSitting> listerServices(){
        List<Service_PlantSitting> myList = new ArrayList<>();
        try {
            String requete2 = "SELECT * FROM offre_local where type=2";
            Statement st2 = cn.createStatement();
            ResultSet rs = st2.executeQuery(requete2);
        while (rs.next()){
            Service_PlantSitting o = new Service_PlantSitting();
            o.setId_offre(rs.getInt(1));
            o.setLocalisation(rs.getString(2));
            o.setQuantite(rs.getInt(3));
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
     public List<Service_PlantSitting> listerOffreClient(int id_user){
        List<Service_PlantSitting> myList = new ArrayList<>();
        try {
            String requete2 = "SELECT * FROM offre_local where type=2 and id_user='"+id_user+"'";
            Statement st2 = cn.createStatement();
            ResultSet rs = st2.executeQuery(requete2);
        while (rs.next()){
            Service_PlantSitting o = new Service_PlantSitting();
            o.setId_offre(rs.getInt(1));
            o.setLocalisation(rs.getString(2));
            o.setQuantite(rs.getInt(3));
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
    public void SupprimerServicePlantSitting(int id) 
              {
                     try {

               
               cn.createStatement().execute("Delete from offre_local where id_offre="+id+";");
               
        }catch (Exception e) {
            System.err.println(e.getMessage());
        }
              
              }
    public List<Plante> AfficherListePlantes()
    {
       List<Plante> myList = new ArrayList<>();
        try {
            String requete2 = "SELECT id_produit,nom FROM produit where id_user=1";
            Statement st2 = cn.createStatement();
            ResultSet rs = st2.executeQuery(requete2);
        while (rs.next()){
            Plante o = new Plante();
            o.setId_plante(rs.getInt(1));
            o.setNom(rs.getString(2));
            
            myList.add(o);
        }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return myList; 
    }
     public int CalculerNombrePlantes()
    {
      
        try {
            String requete2 = "SELECT COUNT(id_produit) FROM produit where id_user=1";
            Statement st2 = cn.createStatement();
            ResultSet rs = st2.executeQuery(requete2);
        while (rs.next()){
            
            String a=rs.getString(1);
            int b=Integer.parseInt(a);
            return b;
          
        }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return 0; 
    }
     public List<Plante> AfficherOffreParClient()
    {
       List<Plante> myList = new ArrayList<>();
        try {
            String requete2 = "SELECT ofa.id_offre ,ofa.id_plante p.* FROM offre_plant ofa ,offre_local ofl ,produit p WHERE ofa.id_offre = ofl.id_offre and ofa.id_plante = p.id_Produit and ofa.id_offre=98";
            Statement st2 = cn.createStatement();
            ResultSet rs = st2.executeQuery(requete2);
        while (rs.next()){

               Plante o=new Plante();
            o.setNom(rs.getString(4));
            o.setCategorie(rs.getString(5));

            
            myList.add(o);
        }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return myList; 
    }
    
   public void ajoutOffrePlante(int id_offre,int id_plante){
       try {
            String requete =
                    "INSERT INTO offre_plant (id_offre,id_plante) VALUES (?,?)";
            PreparedStatement st = cn.prepareStatement(requete);
            st.setInt(1, id_offre);
            st.setInt(2, id_plante);
            st.executeUpdate();
            System.out.println("Plante Ajouteée");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
   }
    public void RecupererQuantite(int id_offre,int id_plante){
       try {
            String requete =
                    "INSERT INTO offre_plant (id_offre,id_plante) VALUES (?,?)";
            PreparedStatement st = cn.prepareStatement(requete);
            st.setInt(1, id_offre);
            st.setInt(2, id_plante);
            st.executeUpdate();
            System.out.println("Plante Ajouteée");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
   }
    public int RecupererDernier()
    {
       List<Plante> myList = new ArrayList<>();
        try {
            String requete2 = "SELECT id_offre FROM offre_local ORDER BY id_offre DESC LIMIT 1";
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
     public int RecupererQuantiteLocal(int id_user)
    {

        try {
            String requete2 = "SELECT quantite_max FROM offre_local where id_user='"+id_user+"'";
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
    public int RecupereOffreClient(int id_user)
    {
       List<Plante> myList = new ArrayList<>();
        try {
            String requete2 = "SELECT id_offre FROM offre_local where id_user='"+id_user+"'";
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
