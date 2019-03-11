/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepiniere.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class ConnexionDB {
    String url ="jdbc:mysql://localhost:3306/pidevpepniere";
    String login ="root"; 
    String pwd ="";
    Connection cnx;
    static ConnexionDB instance;
                
     private ConnexionDB(){     //limiter l'acces public yweli private
        try {
            cnx= DriverManager.getConnection(url, login, pwd);
            System.out.println("cnx établie");
        } catch (SQLException ex) {
            System.out.println("error");
             }
   }
     public Connection getConnection(){
         return cnx;
     }
    public static ConnexionDB getInstance(){
        if (instance == null){
           instance = new ConnexionDB();
        }
           return instance;
        }
}
