/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class Lister_produitController implements Initializable {

    @FXML
    private Button opo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
        public void start(Stage primaryStage) throws IOException {
      
    Parent root =FXMLLoader.load(getClass().getResource("lister_produit.fxml"));
        //Scene scene = new Scene(FXMLLoader.load(getClass().getResource("pep.fxml")));
        Rectangle2D screen = Screen.getPrimary().getBounds();
        Scene liste= new Scene(root, screen.getWidth(), screen.getHeight());
        primaryStage.setX(screen.getMinX()); 
primaryStage.setY(screen.getMinY()); 
primaryStage.setWidth(screen.getWidth()); 
primaryStage.setHeight(screen.getHeight());
        //primaryStage.setTitle("Personne Service");
        //primaryStage.setScene(scene);
        //primaryStage.show();
    primaryStage.setScene(liste);
    primaryStage.show();
     primaryStage.setScene(liste); 
        primaryStage.sizeToScene();
        primaryStage.setFullScreen(true);
        primaryStage.centerOnScreen();
        primaryStage.show();
        }
    @FXML
        public void liste_produit(ActionEvent event) throws IOException {
         switchToScene("lister_produit.fxml",event);
    }
    
      private void switchToScene(String scene,ActionEvent event) throws IOException
    {
        Parent cinema_chose_parent = FXMLLoader.load(getClass().getResource(scene));      
        Scene cinema_chose_scene = new Scene(cinema_chose_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(cinema_chose_scene);
        app_stage.show(); 
        
    }
        
        
}
