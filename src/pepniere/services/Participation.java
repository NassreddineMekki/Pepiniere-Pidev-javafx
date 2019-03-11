/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepniere.services;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import pepniere.entitys.Event;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//import Connexion.ConnectionDB;
import java.sql.Connection;
import pepiniere.utils.DataSource;
import pepniere.entitys.ParticipationEvent;
/**
 *
 * @author FERID
 */
public class Participation {
    
    
       Connection connection = null;
     public Participation(){
       connection = DataSource.getInstance().getConnection();}
    
    
    public void ajouterParticipation (ParticipationEvent p)
     {
         
                 
        try{

            
            
String requete = "INSERT INTO participation  (confirmer,id_event,id) VALUES (?,?,?)";


              PreparedStatement pste = connection.prepareStatement(requete);
              
              pste.setInt(1,1);
              pste.setInt(2,p.getId_event());
            pste.setInt(3,p.getId());
            
             
             ;
             pste.executeUpdate();
             
             System.out.println("Participation ajoutée");
   
        }catch(SQLException k){
            System.out.println("error in add "+k.getMessage());
        }
        
        
    }
    
    



public int  RechercherParticipation (int id_e ,int id_user )
     {
int a=0         ;
                 
        try{

            
            
String req = "Select  confirmer   from  participation where  id_event ='"+id_e+"' and id='"+id_user+"' ";

  Statement pste = connection.createStatement();
   //           PreparedStatement pste = connection.prepareStatement(req);
 
   ResultSet rs =  pste.executeQuery(req);
 while(rs.next())
 {a= rs.getInt(1);
 }        
             
             
        
   
        }catch(SQLException k){
            System.out.println("error in add "+k.getMessage());
        }
      
     
    return a;  }



    
public int remise (int id_user )
{
int a=0;

        try{

            
            
String req = "Select count(id_p)  from  participation where id='"+id_user+"' ";

  Statement pste = connection.createStatement();
   //           PreparedStatement pste = connection.prepareStatement(req);
 
   ResultSet rs =  pste.executeQuery(req);
 while(rs.next())
 {a= rs.getInt(1);
 }        
             
             
        
   
        }catch(SQLException k){
            System.out.println("error in add "+k.getMessage());
        }
      
     
    return a; 





}
    

public int  nbreParticipationMax (int id_event )
     {
int a=0         ;
                 
        try{

            
            
String req = "Select  count(id_p)   from  participation where id_event='"+id_event+"' ";

  Statement pste = connection.createStatement();
   //           PreparedStatement pste = connection.prepareStatement(req);
 
   ResultSet rs =  pste.executeQuery(req);
 while(rs.next())
 {a= rs.getInt(1);
 }        
             
             
        
   
        }catch(SQLException k){
            System.out.println("error in add "+k.getMessage());
        }
      
     
    return a;  }

public int fondateurEvent(int id_event) 
{
    int a=0;
    
     try{
             
String req = "select id_user from events where id_event='"+id_event+"'";

  Statement pste = connection.createStatement();
   //           PreparedStatement pste = connection.prepareStatement(req);
 
   ResultSet rs =  pste.executeQuery(req);
 while(rs.next())
 {a= rs.getInt(1);
 }        
      
     }catch(SQLException k){
            System.out.println("error in add "+k.getMessage());
        }
      
           
     
    return a; 
    
     
}
public int evenement()
{
     int a=0;
    
     try{
             
String req = "select count(id_p) from participation ";

  Statement pste = connection.createStatement();
   //           PreparedStatement pste = connection.prepareStatement(req);
 
   ResultSet rs =  pste.executeQuery(req);
 while(rs.next())
 {a= rs.getInt(1);
 }        
      
     }catch(SQLException k){
            System.out.println("error in add "+k.getMessage());
        }
      
           
     
    return a; 
    
    
    
    
    
}
}



     




     