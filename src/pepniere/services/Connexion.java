/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepniere.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class Connexion {
    private static final String login = "root";
	private static final String mdp = "";
	
	private static final String URL = "jdbc:mysql://localhost:3306/pidevpepniere";
	
	private static Connection connection;
        
        static Connexion instance;

    private Connexion() {
     try {
	connection=DriverManager.getConnection(URL,login,mdp);
	System.out.println("cnx établie");
     }catch (SQLException ex){
         System.out.println("erreur de conxion");
        
        
}
    
    }
    
    
    public static Connexion getInstance()
    {
    if (instance == null)
    {instance = new Connexion();
    }
    return instance ;
    
    
  
    }
    
        public static Connection getConnection()
        {
            return connection;
        
        
        
        }
    
    
    
    
}
