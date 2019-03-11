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
import pepniere.entitys.Client;
import pepniere.entitys.ClientReservation;
import pepniere.entitys.Plante;
import pepniere.entitys.Reservation;
import pepniere.entitys.Service_PlantSitting;

/**
 *
 * @author Mahmoud
 */
public class Reservation_Service {
    
        Connection cn = ConnexionDB.getInstance().getConnection();
        
         public void ajoutReservation(Reservation o,int id_user){
       try {
            String requete =
                    "INSERT INTO reservation (id_offre,quantite,id_user,status) VALUES (?,?,?,?)";
            PreparedStatement st = cn.prepareStatement(requete);
            String x="Non Confirmer";
            st.setInt(1, o.getId_offre());
            st.setInt(2, o.getQuantite());
            
            st.setInt(3, id_user);
            st.setString(4,x);
            st.executeUpdate();
            System.out.println("Resrvation Ajouteée");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
          public void ajoutPlanteReservation(int id_plante,int id_reservation){
       try {
            String requete =
                    "INSERT INTO plante_reservation (id_plante,id_reservation) VALUES (?,?)";
            PreparedStatement st = cn.prepareStatement(requete);
            st.setInt(1, id_plante);
            st.setInt(2, id_reservation);
            st.executeUpdate();
            System.out.println("Plante reservation Ajouteée");
        } catch (Exception e) {
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
           public int RecupererDernier()
    {
       List<Plante> myList = new ArrayList<>();
        try {
            String requete2 = "SELECT id_reservation FROM reservation ORDER BY id_reservation DESC LIMIT 1";
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
     public List<Service_PlantSitting> AfficherReservationClient()
    {
       List<Service_PlantSitting> myList = new ArrayList<>();
        try {
            String requete2 = "select * from reservation,offre_local where offre_local.id_offre=reservation.id_offre and reservation.id_user=1";
            Statement st2 = cn.createStatement();
            ResultSet rs = st2.executeQuery(requete2);
        while (rs.next()){
            Service_PlantSitting o = new Service_PlantSitting();
            o.setLocalisation(rs.getString(7));
            o.setQuantite(rs.getInt(8));
            o.setDate_debut(rs.getDate(9));
            o.setDate_fin(rs.getDate(10));
            o.setPrix(rs.getInt(11));
            o.setDescription(rs.getString(12));
            myList.add(o);
        }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return myList; 
    }
      public void SupprimerReservationClient(int id) 
              {
                     try {

               
               cn.createStatement().execute("Delete from reservation where id_offre="+id+";");
               
        }catch (Exception e) {
            System.err.println(e.getMessage());
        }
              
              }
       public List<Client> ReservationParOffreClient()
    {
       List<Client> myList = new ArrayList<>();
        try {
            String requete2 = "select user.name,user.telephone,user.adress,user.id from user,reservation where user.id=reservation.id_user";
            Statement st2 = cn.createStatement();
            ResultSet rs = st2.executeQuery(requete2);
        while (rs.next()){
            Client o = new Client();
            o.setName(rs.getString(1));
            o.setTelephone(rs.getInt(2));
            o.setAdress(rs.getString(3));
            o.setId(rs.getInt(4));
            myList.add(o);
        }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return myList; 
    }
        public List<ClientReservation> ReservationParOffreClientQunatiteRes()
    {
       List<ClientReservation> myList = new ArrayList<>();
        try {
            String requete2 = "select user.name,user.first_name,user.telephone,user.adress,reservation.status ,reservation.id_reservation,reservation.quantite,user.id from user,reservation where user.id=reservation.id_user";
            Statement st2 = cn.createStatement();
            ResultSet rs = st2.executeQuery(requete2);
        while (rs.next()){
            ClientReservation o = new ClientReservation();
            o.setName(rs.getString(1));
            o.setFirst_name(rs.getString(2));
            o.setTelephone(rs.getInt(3));
            o.setAdress(rs.getString(4));
            o.setStatus(rs.getString(5));
            o.setId_reservation(rs.getInt(6));
            o.setQuantite(rs.getInt(7));
            o.setId_user(rs.getInt(8));
            myList.add(o);
        }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return myList; 
    }
        public int RecupererOffreUser(int id_user)
    {
        try {
            String requete2 = "SELECT id_offre FROM offre_local where id_user= '"+id_user+"' and type=1";
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
        public void ConfirmerReservation(int id_offre,int id_user)
    {
       try {
           String confirmer="confirmer";
            String requete="update reservation set status='"+confirmer+"' where id_offre= '"+id_offre+"' and id_user='"+id_user+"'";
            PreparedStatement st = cn.prepareStatement(requete);
  
            st.executeUpdate(requete);
            System.out.print("Reservation Confirmer");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
        public void ModifierQuantiteLocal(int quantiteRes,int id_offre)
    {
       try {
            String requete="update offre_local set offre_local.quantite_max=offre_local.quantite_max-'"+quantiteRes+"' where offre_local.id_offre='"+id_offre+"'";
            PreparedStatement st = cn.prepareStatement(requete);
  
            st.executeUpdate(requete);
            System.out.print("Qunatite Confirmer");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
       
       public List<Plante> ReservationParOffre()
    {
       List<Plante> myList = new ArrayList<>();
        try {
            String requete2 = "select produit.nom,produit.taille from offre_local ,reservation , produit ,plante_reservation"
                    + " WHERE plante_reservation.id_plante =produit.id_Produit and plante_reservation.id_reservation =reservation.id_reservation AND offre_local.id_offre=82";
            Statement st2 = cn.createStatement();
            ResultSet rs = st2.executeQuery(requete2);
        while (rs.next()){
            Plante o = new Plante();
            o.setNom(rs.getString(1));
            o.setTaille(rs.getInt(2));
            myList.add(o);
        }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return myList; 
    }
}
