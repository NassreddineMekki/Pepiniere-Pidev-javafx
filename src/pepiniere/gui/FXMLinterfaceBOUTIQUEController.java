/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepiniere.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author FERID
 */
public class FXMLinterfaceBOUTIQUEController implements Initializable {

    @FXML
    private Circle image;
    @FXML
    private Label name;
    @FXML
    private Label mail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Statistque(ActionEvent event) throws IOException {
        
           Parent   url =  FXMLLoader.load( getClass().getResource("FXMLStat.fxml"))  ;  
         
          Scene scene = new Scene(url);
             Stage stage =  (Stage) ((Node) event.getSource()).getScene().getWindow();
             stage.hide();
              stage.setScene(scene);
              stage.show();
            
    }

    @FXML
    private void eveneet(ActionEvent event) throws IOException {
        
           Parent   url =  FXMLLoader.load( getClass().getResource("FXMLAffichage_Event.fxml"))  ;  
         
          Scene scene = new Scene(url);
             Stage stage =  (Stage) ((Node) event.getSource()).getScene().getWindow();
             stage.hide();
              stage.setScene(scene);
              stage.show();
            
    }

    @FXML
    private void AJOUT(ActionEvent event) throws IOException {
        
         Parent   url =  FXMLLoader.load( getClass().getResource("AjoutEvent.fxml"))  ;  
         
          Scene scene = new Scene(url);
             Stage stage =  (Stage) ((Node) event.getSource()).getScene().getWindow();
             stage.hide();
              stage.setScene(scene);
              stage.show();
        
        
        
        
        
        
    }
    
}
