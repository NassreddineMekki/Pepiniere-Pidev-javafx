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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class FXMLProduit_BoutiqueController implements Initializable {

    @FXML
    private ImageView plante;
    @FXML
    private ImageView accessoire;
    @FXML
    private ImageView soins;
    @FXML
    private ImageView livre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void plante(MouseEvent event) throws IOException {
                        switchToScene("Plante.fxml",event);

    }

    @FXML
    private void accessoire(MouseEvent event) throws IOException {
                        switchToScene("Accesoire.fxml",event);

    }

    @FXML
    private void soins(MouseEvent event) throws IOException {
                switchToScene("Soins.fxml",event);

    }

    @FXML
   private void livre(MouseEvent event) throws IOException {
        switchToScene("Livre.fxml",event);
    }
   
 private void switchToScene(String scene,MouseEvent event) throws IOException
    {
      
        
           Parent   url =  FXMLLoader.load( getClass().getResource(scene))  ;  
         
          Scene scenes = new Scene(url);
             Stage stage =  (Stage) ((Node) event.getSource()).getScene().getWindow();
            // stage.hide();
              stage.setScene(scenes);
              stage.show();
        
    }

    @FXML
    private void retoureAccueil(MouseEvent event) throws IOException {
                       switchToScene("FXMLAcceuil_Boutique.fxml",event);

    }
 
 
 
    
}
