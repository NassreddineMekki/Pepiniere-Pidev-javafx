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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import pepiniere.utils.StaticValue;
import pepniere.services.UserService;

/**
 * FXML Controller class
 *
 * @author Nassreddine
 */
public class FXMLAdminController implements Initializable {

    @FXML
    private Circle cir;
    @FXML
    private Label nbStoreBlock;
    @FXML
    private Label admin;
    @FXML
    private ImageView stor;
    @FXML
    private ImageView storb;
    @FXML
    private Label name;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       name.setText(StaticValue.admin.getUsername());
       
         admin.setText(StaticValue.admin.getUsername());
        Image img = new Image("http://localhost/pidev4info/img/"+StaticValue.admin.getImgUrl(),150,150,true,true);
        cir.setFill(new ImagePattern(img));
        UserService us = new UserService();
        
        int nb = us.nbStoreBloque();
        if(nb>0)
        nbStoreBlock.setText("Vous avez "+nb+"demande bloquée(s) consulter liste des botique pour savoir plus");
        else
            nbStoreBlock.setText("Pas de nouveaux demandes");
    }    

    @FXML
    private void deconectAction(ActionEvent event) throws IOException {
        Parent parentInscit = FXMLLoader.load(getClass().getResource("FXMLAuthentification.fxml"));
        Scene sceneInscit = new Scene(parentInscit);
              Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
       
             stageInscit .hide();
        
             stageInscit .setScene(sceneInscit );
             stageInscit .show();
    }

    @FXML
    private void listStorebloked(MouseEvent event) throws IOException {
         Parent parentInscit = FXMLLoader.load(getClass().getResource("FXMLListStore.fxml"));
        Scene sceneInscit = new Scene(parentInscit);
              Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
       
             stageInscit .hide();
        
             stageInscit .setScene(sceneInscit );
             stageInscit .show();
    }

    @FXML
    private void statAction(MouseEvent event) throws IOException {
         Parent parentInscit = FXMLLoader.load(getClass().getResource("FXMLStatCommand.fxml"));
        Scene sceneInscit = new Scene(parentInscit);
              Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
       
             stageInscit .hide();
        
             stageInscit .setScene(sceneInscit );
             stageInscit .show();
    }

    @FXML
    private void listAllUser(MouseEvent event) throws IOException {
         
                 Parent parentInscit = FXMLLoader.load(getClass().getResource("FXMLListAllUser.fxml"));
        Scene sceneInscit = new Scene(parentInscit);
              Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
       
             stageInscit .hide();
        
             stageInscit .setScene(sceneInscit );
             stageInscit .show();
    }
    
}
