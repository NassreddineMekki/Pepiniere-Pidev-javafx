/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepniere.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//import Connexion.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pepiniere.utils.DataSource;
import pepniere.entitys.Event;

/**
 *
 * @author FERID
 */
public class EventService {
    
      Connection connection = null;
     public EventService(){
       connection = DataSource.getInstance().getConnection();}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */





/**
 *
 * @author FERID
 */

    
     public void ajouterEvents(Event e)
     {
         
                 
        try{

            
            
String requete = "INSERT INTO events (nom_event,date_deb,description,adresse_event,frais_particpation,nbre_participant,	img_Event,id_user ) VALUES (?,?,?,?,?,?,?,?)";


              PreparedStatement pste = connection.prepareStatement(requete);
             
            pste.setString(1,e.getNom_event());
             pste.setDate(2,e.getDate_deb());
             pste.setString(3,  e.getDescription());
             pste.setString(4,e.getAdresse_event()); 
             pste.setInt(5,e.getFrais_particpation() ); 
                pste.setInt(6,e.getNbre_participant()); 
                pste.setString(7,e.getImg_Event());
                pste.setInt(8,e.getid_user());
             pste.executeUpdate();
             
             System.out.println("Event ajoutée");
   
        }catch(SQLException k){
            System.out.println("error in add "+k.getMessage());
        }
        
        
    }
         
    public  ObservableList <Event> listeEvents(){
        
        ObservableList <Event> list = FXCollections.observableArrayList();
        try{
            
            String req = "select id_event,nom_event,date_deb,description,adresse_event,frais_particpation,Nbre_participant from events";
              PreparedStatement pste = connection.prepareStatement(req);
           
            ResultSet rs =  pste.executeQuery(req);
            
            
            while (rs.next()){
                
                Event e = new Event();
             e.setId_event(rs.getInt(1));
             e.setNom_event(rs.getString(2));
             e.setDate_deb(rs.getDate(3));
             e.setDescription (rs.getString(4));
             e.setAdresse_event(rs.getString(5));
             e.setFrais_particpation(rs.getInt(6));
             e.setNbre_participant(rs.getInt(7));
             //e.setImg_Event(rs.getString(9));
                //System.out.println("////////////////////////////////////////////"+rs.getString(9));
               list.add(e);
            }
            
            
        }
        
        
        
        catch(SQLException k){
            System.out.println(k.getMessage());
        }
        return list;
        
    }
    
    
        public  ArrayList <Event> affichageEvent(){
        
      ArrayList <Event> list = new ArrayList<>();
        try{
            
            String req = "select id_event,nom_event,date_deb,description,adresse_event,frais_particpation,Nbre_participant,img_Event,id_user from events ";
     PreparedStatement pste = connection.prepareStatement(req);
           
            ResultSet rs =  pste.executeQuery(req);
            
            
            while (rs.next()){
                
                Event e = new Event();
                
        e.setId_event(rs.getInt(1));
             e.setNom_event(rs.getString(2));
             e.setDate_deb(rs.getDate(3));
             e.setDescription (rs.getString(4));
             e.setAdresse_event(rs.getString(5));
             e.setFrais_particpation(rs.getInt(6));
             e.setNbre_participant(rs.getInt(7));
               e.setImg_Event(rs.getString(8));
               e.setid_user(rs.getInt(9));


list.add(e);
       
            
            
            }
            
            
        }
        
        
        
        
        
        catch(SQLException k){
            System.out.println("error in affichage event "+k.getMessage());
        }
        return list;
        
    }
        
    
     /*   public boolean aff( ) throws SQLException{
        
        
        String req = "select id_user from user";
        
  PreparedStatement pste = connection.prepareStatement(req);
            ResultSet rs =  pste.executeQuery(req);
           int a= rs.getInt(1);
            String req1 = "select id_user from Events";
             pste= cnx.getCn().prepareStatement(req1);
            ResultSet rs1 =  pste.executeQuery(req1);
            int b=rs1.getInt(1);
            if(a==b){
                return true;
            }
        
        return false;
        }
        
        
        
        */
       
        
  public  ArrayList <Event> affichageEventById(int id){
        
      ArrayList <Event> list = new ArrayList<>();
        try{
            
            String req = "select id_event,nom_event,date_deb,description,adresse_event,frais_particpation,Nbre_participant,img_Event,id_user from events where id_user='"+id+"'";
            PreparedStatement pste = connection.prepareStatement(req);
            //  pste.setInt(1, id);
           
            ResultSet rs =  pste.executeQuery(req);
          
            
            while (rs.next()){
                
                Event e = new Event();
                
        e.setId_event(rs.getInt(1));
             e.setNom_event(rs.getString(2));
             e.setDate_deb(rs.getDate(3));
             e.setDescription (rs.getString(4));
             e.setAdresse_event(rs.getString(5));
             e.setFrais_particpation(rs.getInt(6));
             e.setNbre_participant(rs.getInt(7));
               e.setImg_Event(rs.getString(8));
               e.setid_user(rs.getInt(9));

                     list.add(e);

            }
         
        }

        catch(SQLException k){
            System.out.println("error in affichage event "+k.getMessage());
        }
        return list;
        
    }      
        
        
    public void delete(Event  e) {
       try
       {
           String req="DELETE FROM events WHERE id_event=?";
          PreparedStatement pste = connection.prepareStatement(req);
          pste.setInt(1,e.getId_event());
          if (pste.execute())
          { System.out.println("event supprimer");}
           
       }catch(SQLException ex)
       {
          System.out.println(ex.getMessage());
       }
    }
        
    
    
    public void deleteVBox(Event c,int id) {
       try
       {
           String req="DELETE FROM event WHERE id_event='"+id+"'";
         PreparedStatement pste = connection.prepareStatement(req);
          pste.setInt(1,c.getId_event());
          if (pste.execute())
          { System.out.println("event supprimer");}
           
       }catch(SQLException ex)
       {
          System.out.println(ex.getMessage());
       }
    } 
    
    
    
public void update(Event o,int id) {
        try {
            String requete="update event set  nom_event='"+o.getNom_event()+"' ,  description='"+o.getDescription()+"' , adresse_event='"+o.getAdresse_event()+"' , frais_particpation='"+o.getFrais_particpation()+"' ,  Nbre_participant='"+o.getNbre_participant()+"' where id_event= '"+id+"'";
           PreparedStatement pste = connection.prepareStatement(requete);
  
            pste.executeUpdate(requete);
            System.out.print("event modifier");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
/*public void update_confirmer(int id)
{

   try {
            String requete="update events set confirmer=1 where id_event= '"+id+"'";
           PreparedStatement pste = connection.prepareStatement(requete);
  
            pste.executeUpdate(requete);
            System.out.print("event modifier");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

}
   */     
        /*public void update(Events e,int id)
    {
        String query="UPDATE events SET  nom_event ,description,adresse_event,frais_particpation,Nbre_participant  WHERE id_event='"+id+"'";
        
        try {  pste= cnx.getCn().prepareStatement(query);
           
            pste.setString(1, e.getNom_event());
         // pste.setDate(2, e.getDate_deb());
            pste.setString(2,e.getDescription());
           pste.setString(3, e.getAdresse_event());
           pste.setInt(4, e.getFrais_particpation());
           pste.setInt(5,e.getNbre_participant());
        
            System.out.println(pste);
           pste.executeUpdate();
            System.out.println(e.getNom_event()+" à été modifier avec succes ");
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
         
        
    }*/

    public void delete(javafx.event.Event selectedUser) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



} 
