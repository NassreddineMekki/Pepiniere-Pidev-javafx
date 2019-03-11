/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Nassreddine
 */
public class Datasource {
    private static final String login = "root";
	private static final String mdp = "";
	
	private static final String URL = "jdbc:mysql://localhost:3306/pidevpepniere";
	
	private static Connection connection;
        static Datasource instance;

    public Datasource() {
     try {
	connection=(Connection) DriverManager.getConnection(URL, login, mdp);
	System.out.println("cnx établie");
     }catch (SQLException ex){
         System.out.println("erreur de conxion"+ex.getMessage());
        
        
     }}
    public static Datasource getInstance(){
        if (instance == null)
        {instance =new Datasource();
    }
        return instance;
    }   
    public static Connection getConnecion (){
        return  connection;
    }
}
