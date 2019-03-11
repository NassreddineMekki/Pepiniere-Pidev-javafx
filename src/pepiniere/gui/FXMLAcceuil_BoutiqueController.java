/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepiniere.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import pepiniere.utils.StaticValue;

/**
 * FXML Controller class
 *
 * @author Nassreddine
 */
public class FXMLAcceuil_BoutiqueController implements Initializable {

    @FXML
    private Circle image;
    @FXML
    private Label name;
    @FXML
    private Label mail;
    private Label lbl;
    @FXML
    private ImageView pane;
    @FXML
    private Label lll;
    @FXML
    private ImageView prod;
    @FXML
    private ImageView event;
    @FXML
    private Label l1;
    @FXML
    private Label l2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        name.setText(StaticValue.store.getUsername());
        mail.setText(StaticValue.store.getEmail());
         lll.setText(StaticValue.store.getUsername());
        Image img = new Image("http://localhost/pidev4info/img/"+StaticValue.store.getImgUrl(),150,150,true,true);
        image.setFill(new ImagePattern(img));
         if(StaticValue.client!=null){
             l1.setVisible(false);
             lll.setVisible(false);
             l2.setVisible(false);
        }
       
    }    

    @FXML
    private void eventAction(MouseEvent event) throws IOException {
        
              Parent parentInscit = FXMLLoader.load(getClass().getResource("FXMLinterfaceBOUTIQUE.fxml"));
        Scene sceneInscit = new Scene(parentInscit);
              Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
       
             stageInscit .hide();
        
             stageInscit .setScene(sceneInscit );
             stageInscit .show();
        
    }

    @FXML
    private void paneActoin(MouseEvent event) {
       if(StaticValue.client!=null){
             
        }
    }

    @FXML
    private void produitAction(MouseEvent event) throws IOException {
            switchToScene("FXMLProduit_Boutique.fxml",event);
              
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
    
}
