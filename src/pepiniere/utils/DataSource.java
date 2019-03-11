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
 * @author Nassreddine
 */
public class DataSource {
     private static DataSource instance = null;
    String url = "jdbc:mysql://localhost:3306/pidevpepniere";
    String login = "root";
    String pwd = "";
    Connection connection=null;


    private DataSource() {
try {
        connection = DriverManager.getConnection(url, login, pwd);

}
catch ( SQLException ex)
        {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    public static DataSource getInstance() {
        if (instance == null) {
            instance = new DataSource();
        }

        return instance;
    }
    

    public Connection getConnection() {
        return connection;
    }
}
