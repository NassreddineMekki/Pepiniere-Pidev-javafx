/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepiniere.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import pepiniere.utils.DataSource;
import pepniere.services.EventService;
/**
 * FXML Controller class
 *
 * @author FERID
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */





public class FXMLStatController implements Initializable {


    @FXML
    private BarChart<?, ?> stat;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;
    
     pepniere.services.Participation a= new  pepniere.services.Participation();
      public int rechercher(int id) 
                 
         {int a=0;
    
      Connection connection = null;
   
       connection = DataSource.getInstance().getConnection();
          String req = "select count(id_p) from participation where id_event = "+id+" ";
     PreparedStatement pste;
        try {
            pste = connection.prepareStatement(req);
             ResultSet rs =  pste.executeQuery(req);
         
  
 while(rs.next())
 {a= rs.getInt(1);
      
                
 }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLStatController.class.getName()).log(Level.SEVERE, null, ex);
        }
                 
                 
   return a;          
                 
    } 

     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
       
     
        Connection connection = null;
   XYChart.Series set1 =new  XYChart.Series<>();
       connection = DataSource.getInstance().getConnection();
           String req = "select participation.id_event ,events.nom_event from participation inner join events on (events.id_event=participation .id_event) ";
            PreparedStatement pste;
         try {
             pste = connection.prepareStatement(req);
             
               ResultSet rs =  pste.executeQuery(req);
               
               while(rs.next()){
               
               int idevent = rs.getInt(1);
               String nom =rs.getString(2);
               
               int k = rechercher(idevent);
               
               set1.getData().add(new  XYChart.Data(nom,k));
            
               
               }
               
         } catch (SQLException ex) {
             Logger.getLogger(FXMLStatController.class.getName()).log(Level.SEVERE, null, ex);
         }
         stat.getData().addAll(set1);
         
           System.out.println(rechercher(38));
         
         
    }

}