/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepiniere.gui;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pepiniere.utils.StaticValue;
import pepiniere.utils.Upload;
import pepniere.entitys.Client;
import pepniere.entitys.Store;
import pepniere.services.UserService;

/**
 * FXML Controller class
 *
 * @author Nassreddine
 */
public class FXMLIscritStoreController implements Initializable {

    @FXML
    private JFXTextField nom;
    @FXML
    private JFXTextField mail;
    @FXML
    private JFXPasswordField pass;
    @FXML
    private JFXTextField adrs;
    @FXML
    private JFXTextField tel;
    @FXML
    private TextField img;
    
     private File file;
    private Image image;
    String pic;
    @FXML
    private JFXTextArea des;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         img.setVisible(false);
    }    

    @FXML
    private void imageAction(ActionEvent event) throws IOException {
         FileChooser fileChooser = new FileChooser();
            file= fileChooser.showOpenDialog(null);
             FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

            
            pic=(file.toURI().toString());
         //  pic=new Upload().upload(file,"uimg");
           pic=new Upload().upload(file,"");
            System.out.println(pic);
       //  image= new Image("http://localhost/uimg/"+pic);
            img.setText(pic);
           image= new Image("http://localhost/pidev4info/img/"+pic); 
    }

    @FXML
    private void inscrireAction(ActionEvent event) throws IOException {
         if(nom.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
             alert.setHeaderText(null);
            alert.setContentText("Vous devez entrez votre nom de compte");
           alert.showAndWait();
         }else if(des.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
             alert.setHeaderText(null);
            alert.setContentText("Vous devez entrez votre adresse");
           alert.showAndWait();
         }else if(pass.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
             alert.setHeaderText(null);
            alert.setContentText("Vous devez entrez votre mot de pass");
           alert.showAndWait();
         }else if(mail.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
             alert.setHeaderText(null);
            alert.setContentText("Vous devez entrez votre adresse mail");
           alert.showAndWait();
         }else if(tel.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
             alert.setHeaderText(null);
            alert.setContentText("Vous devez entrez votre telephone");
           alert.showAndWait();
         }
         else{
                   UserService us = new UserService();
        String name = nom.getText();
        String desc = des.getText();
        String mai = mail.getText();
        String description = "";
        String adress = adrs.getText();
        int telNum = Integer.parseInt(tel.getText());
        String password = pass.getText();
        String im = img.getText();
        String masque = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"
                        + "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";
         System.out.println("Pas d'insertion "+masque);
         Pattern pattern = Pattern.compile(masque);
         Matcher controler = pattern.matcher(mai);
         
         if(controler.matches()){
      Store s = new Store(adress,telNum,desc,name,mai,0,password,"",im,null);
      us.adduserStrore(s);
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
             alert.setHeaderText(null);
            alert.setContentText("Vous avez une compte bloquée vous ressouvez un email de confirmation si vous etes une boutique");
           alert.showAndWait(); 
  }
  else{
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("Delete File");
      alert.setHeaderText("Entrer une adress email valide ?");
      alert.setContentText("Il y a des commandes à confirmer");
  } 
         }
    
        
    }

    @FXML
    private void buckAction(ActionEvent event) throws IOException {
                Parent parentInscit = FXMLLoader.load(getClass().getResource("FXMLAuthentification.fxml"));
        
              Scene sceneInscit = new Scene(parentInscit);
              Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
       
             stageInscit .hide();
        
             stageInscit .setScene(sceneInscit );
             stageInscit .show();
    }
    
}
