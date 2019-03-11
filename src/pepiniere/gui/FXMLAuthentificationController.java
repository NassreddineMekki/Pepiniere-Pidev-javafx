/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepiniere.gui;

import com.jfoenix.controls.JFXRadioButton;
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
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pepiniere.utils.StaticValue;
import pepniere.entitys.Admin;
import pepniere.entitys.Client;
import pepniere.entitys.Store;
import pepniere.entitys.User;
import pepniere.services.UserService;

/**
 * FXML Controller class
 *
 * @author Nassreddine
 */
public class FXMLAuthentificationController implements Initializable {

    @FXML
    private TextField txtUserName;
    @FXML
    private PasswordField txtPass;
    @FXML
    private AnchorPane paneIscrit;
    @FXML
    private JFXRadioButton boutiqurRad;
    @FXML
    private JFXRadioButton clientRad;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleGroup groupe = null;
        boutiqurRad.setToggleGroup(groupe);
        clientRad.setToggleGroup(groupe);
        paneIscrit.setVisible(false);
    }    

    @FXML
    private void ConnectAction(ActionEvent event) throws IOException {
            if (txtUserName.getText().isEmpty()){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText("Vous devez entrez votre nom de compte");
        alert.showAndWait();
        }else if(txtUserName.getText().isEmpty()){
           Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText("Vous devez entrez votre Mot de Passe");
        alert.showAndWait();
        }else{
              String login = txtUserName.getText();
        String password = txtPass.getText();
        UserService us = new UserService();
        User user = us.Authentification(login, password);
        if(user!=null){
            if(user.getRole().equals("a:0:{}")){
          user = (Client)us.Authentification(login, password);
            StaticValue.client=(Client) user;
            Parent parentInscit = FXMLLoader.load(getClass().getResource("FXMLAcceuil_Client.fxml"));
        
              Scene sceneInscit = new Scene(parentInscit);
              Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
       
             stageInscit .hide();
        
             stageInscit .setScene(sceneInscit );
             stageInscit .show();
        }else{
               if(user.getRole().equals("admin")){
                   user = (Admin)us.Authentification(login, password);
                   StaticValue.admin=(Admin) user;
                   Parent parentInscit = FXMLLoader.load(getClass().getResource("FXMLAdmin.fxml"));
        
                    Scene sceneInscit = new Scene(parentInscit);
                     Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
       
                   stageInscit .hide();
          
                   stageInscit .setScene(sceneInscit );
                   stageInscit .show();
        }
               else{
                   if(user.getEnabled()!=0){
                        user = (Store)us.Authentification(login, password);
                     StaticValue.store=(Store)user;
                   Parent parentInscit = FXMLLoader.load(getClass().getResource("FXMLAcceuil_Boutique.fxml"));
        
                    Scene sceneInscit = new Scene(parentInscit);
                     Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
       
                   stageInscit .hide();
          
                   stageInscit .setScene(sceneInscit );
                   stageInscit .show();
                   }
                   else{
                      Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setHeaderText(null);
                            alert.setContentText("votre compte n'est pas activer");
                            alert.showAndWait();
                   }
                 
               }
        }
        }
        else{
             Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setHeaderText(null);
                            alert.setContentText("Mot de Passe ou nom de compte invalide ");
                            alert.showAndWait();
        }
        }
     
        
    }

    @FXML
    private void boutiqueInscrit(ActionEvent event) throws IOException {
        Parent parentInscit = FXMLLoader.load(getClass().getResource("FXMLIscritStore.fxml"));
        
                    Scene sceneInscit = new Scene(parentInscit);
                     Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
       
                   stageInscit .hide();
          
                   stageInscit .setScene(sceneInscit );
                   stageInscit .show();
    }

    @FXML
    private void clientInscrit(ActionEvent event) throws IOException {
        //
        Parent parentInscit = FXMLLoader.load(getClass().getResource("FXMLInscritUser.fxml"));
        
                    Scene sceneInscit = new Scene(parentInscit);
                     Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
       
                   stageInscit .hide();
          
                   stageInscit .setScene(sceneInscit );
                   stageInscit .show();
    }

    @FXML
    private void inscritAction(ActionEvent event) {
         paneIscrit.setVisible(true);
    }
    
}
