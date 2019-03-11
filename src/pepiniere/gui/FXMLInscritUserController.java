/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepiniere.gui;

import com.jfoenix.controls.JFXPasswordField;
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
import pepniere.services.UserService;

/**
 * FXML Controller class
 *
 * @author Nassreddine
 */
public class FXMLInscritUserController implements Initializable {

    @FXML
    private JFXTextField nom;
    @FXML
    private JFXTextField pren;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        img.setVisible(false);
    }    

    @FXML
    private void imageAction(ActionEvent event) throws IOException{
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
    private void inscrireAction(ActionEvent event) throws IOException  {
       
           
        
         if(nom.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
             alert.setHeaderText(null);
            alert.setContentText("Vous devez entrez votre nom de compte");
           alert.showAndWait();
         }else if(pren.getText().equals("")){
           Alert alert = new Alert(Alert.AlertType.ERROR);
             alert.setHeaderText(null);
            alert.setContentText("Vous devez entrez votre prenom");
           alert.showAndWait();
         } else if(mail.getText().equals("")){
           Alert alert = new Alert(Alert.AlertType.ERROR);
             alert.setHeaderText(null);
            alert.setContentText("Vous devez entrez votre adress emeil");
           alert.showAndWait();
         }else if(adrs.getText().equals("")){
           Alert alert = new Alert(Alert.AlertType.ERROR);
             alert.setHeaderText(null);
            alert.setContentText("Vous devez entrez votre adress");
           alert.showAndWait();
         }else if((tel.getText().equals(""))||(tel.getText().length()!=8)){
           Alert alert = new Alert(Alert.AlertType.ERROR);
             alert.setHeaderText(null);
            alert.setContentText("numero de telephone invalide");
           alert.showAndWait();
         }else{System.err.println("**********"+img.getText());
              String masque = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"
                        + "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";
         System.out.println("Pas d'insertion "+masque);
         Pattern pattern = Pattern.compile(masque);
         String name = nom.getText();
        String fristName = pren.getText();
        String mai = mail.getText();
        String description = "";
        String adress = adrs.getText();
        int telNum = Integer.parseInt(tel.getText());
        String password = pass.getText();
        String im = img.getText();
         Matcher controler = pattern.matcher(mai);
                      if(controler.matches()){
                          UserService us = new UserService();
        
       
      Client c = new Client(name,fristName,adress,0,telNum,"",description,mai,password,im,null);
      us.adduserClient(c);
        System.out.println("Pas d'insertion "+c);
         Client client = (Client) us.Authentification(name, password);
            StaticValue.client=client;
            Parent parentInscit = FXMLLoader.load(getClass().getResource("FXMLAcceuil_Client.fxml"));
        
              Scene sceneInscit = new Scene(parentInscit);
              Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
       
             stageInscit .hide();
        
             stageInscit .setScene(sceneInscit );
             stageInscit .show();
  }
  else{
      Alert alert = new Alert(Alert.AlertType.ERROR);
             alert.setHeaderText(null);
            alert.setContentText("Vous devez entrez une image pour une compte");
           alert.showAndWait();    
        
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
