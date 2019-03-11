/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepiniere.gui;


import java.net.URL;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.IOException;

import com.gnostice.pdfone.*;
import javafx.scene.layout.VBox;

import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import javafx.stage.Stage;
import javafx.util.Duration;
import pepiniere.utils.StaticValue;
import pepniere.entitys.Command;
import pepniere.entitys.Product;
import pepniere.entitys.Store;
import pepniere.services.CommandService;
import pepniere.services.ProductService;
import pepniere.services.UserService;




/**
 * FXML Controller class
 *
 * @author Nassreddine
 */
public class FXMLConfirmController implements Initializable {

    @FXML
    private Circle profilImg;
    @FXML
    private Label name;
    @FXML
    private VBox vb;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        name.setText(StaticValue.client.getName());
     
      Image imgg = new Image("http://localhost/pidev4info/img/"+StaticValue.client.getImgUrl(),150,150,true,true);
      profilImg.setFill(new ImagePattern(imgg));
      
             for(Product c :StaticValue.listProduct){
            
            VBox vb1 = new VBox();
            VBox vb2 = new VBox();
            VBox vb3 = new VBox();
            VBox vb4 = new VBox();
            VBox vb5 = new VBox();
            VBox vb6 = new VBox();
            
            Separator sp1 = new Separator(Orientation.VERTICAL);
             Separator sp2 = new Separator(Orientation.VERTICAL);
            
             vb5.getChildren().add(sp1);
             vb6.getChildren().add(sp2);
             
            HBox hhb = new HBox();
            ProductService ps = new ProductService();
           
           System.err.println("id Produit "+c.getId_produit());
            ImageView img = new ImageView();
            img.setImage(new Image("http://localhost/pidev4info/img/"+c.getImage(),200,200,true,true));
            System.err.println(c.getId_produit());
             Label l0 = new Label("");
             Label l1 = new Label("       Nom Produit : "+c.getNom());
            Label l01 = new Label("");
            Label l2 = new Label("       Marque : "+c.getMarque());
            Label l02 = new Label("");
            Label l27 = new Label("       Quantité disponible : "+c.getQuantite());
               Label l024 = new Label("");
            vb1.getChildren().add(img);
            vb1.getChildren().add(l0);
            vb2.getChildren().add(l1);
            vb2.getChildren().add(l01);
            vb2.getChildren().add(l2);
            vb2.getChildren().add(l02);
            vb2.getChildren().add(l27);
            Button b = new Button("Confirmer ");
            b.setPrefWidth(150);
            
             Button b2 = new Button("Payer ");
            b2.setPrefWidth(150);
            
            
            
           TextField twf = new TextField();
            
            Label l = new Label("Saisir le nombre à commandé");
            Label ll = new Label("");
             Label lll = new Label("");
            
            twf.setPrefWidth(50);
             l.setPrefWidth(250);
            Separator spv = new Separator(Orientation.VERTICAL);

            vb4.getChildren().add(l);
             vb4.getChildren().add(ll);
            vb4.getChildren().add(twf);
            vb3.getChildren().add(ll);
            vb3.getChildren().add(lll);
           
            vb3.getChildren().add(b);
            
          
            hhb.getChildren().add(vb1);
            hhb.getChildren().add(vb5);
            hhb.getChildren().add(vb2);
            hhb.getChildren().add(vb4);
            hhb.getChildren().add(vb6);
            hhb.getChildren().add(vb3);
            
            vb.getChildren().add(hhb);
           
           EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
         CommandService cs = new CommandService();
        float f = 0.0f;
        int i = Integer.parseInt(twf.getText());
        f =  c.getPrix()*i;
         Calendar calendar = Calendar.getInstance();
             java.util.Date currentDate = calendar.getTime();
             java.sql.Date date = new java.sql.Date(currentDate.getTime());
             Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
             String s = formatter.format(date);
            
       
       
        
        Command cmd = new Command(i,f,s,c.getCategorie_produit(),c.getCategorie_plante(),StaticValue.client.getId(),c.getId_produit());
        //System.out.println(".handle()");
         
      if(i<=c.getQuantite()){
          cs.addCommande(cmd);
          ProductService pss = new ProductService();
          int q = (int)c.getQuantite()-i;
          
         
          pss.updateProductAfterAddComnd(c.getId_produit(), q);
          StaticValue.listProduct.remove(c);
          Parent parentInscit = null;
            try {
                parentInscit = FXMLLoader.load(getClass().getResource("FXMLConfirm.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(FXMLConfirmController.class.getName()).log(Level.SEVERE, null, ex);
            }
        Scene sceneInscit = new Scene(parentInscit);
        Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
        stageInscit .hide();
        stageInscit .setScene(sceneInscit );
        stageInscit .show();
        
        // Create a new document
    PdfDocument doc = new PdfDocument();

    // Create a blank signature form field
   
        
    // Create a PDF page
    PdfPage page1 = new PdfPage(PdfPageSize.A4);
          UserService us = new UserService();
        Store sff =  us.FindStoreById(StaticValue.client.getId());
    // Add the form field to the page
            try {
                String te="";
                String text="                                         - nom produit commandé  = "+c.getNom();
                 String tex="";
                String text2="                                        - Qunantite Produit  commandé= "+i;
                 String t="";
                 String text3="                                       -  prix= "+f;
                  String tek="";
                  String text4="                                      -  Boutique à payé  "+sff.getUsername();
                page1.writeText(te+"\n"+text+"\n"+tex+"\n"+text2+"\n"+t+"\n"+text3+"\n"+tek+"\n"+text4, 10, 10);
            } catch (IOException ex) {
                Logger.getLogger(FXMLConfirmController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (PdfException ex) {
                Logger.getLogger(FXMLConfirmController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            try {
                // Add the page to the document
                doc.add(page1);
            } catch (PdfException ex) {
                Logger.getLogger(FXMLConfirmController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            try {
                // Save the document to file
                doc.save("blankdoc2l.pdf");
            } catch (IOException ex) {
                Logger.getLogger(FXMLConfirmController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (PdfException ex) {
                Logger.getLogger(FXMLConfirmController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            try {
                // Close IO resources
                doc.close();
            } catch (IOException ex) {
                Logger.getLogger(FXMLConfirmController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (PdfException ex) {
                Logger.getLogger(FXMLConfirmController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        String title = "Coupon généré";
        String message = "Coupon. généré avec Succes";
        //********** Notif pc
    
       
       
      }
      else{
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
                   alert.setHeaderText(null);
                   alert.setContentText("Quantité indiponible");
                   alert.showAndWait();
      } 
    }
};
            
         b.setOnAction(buttonHandler);
          

   
       
       
           
        

          
          
            
          
            
            
             
             
           
           
             
             
            
        
          
            
           
      
           
        //************Sending mail**************
           //send Mail
   

        
        
        //***************************************
              
    
     
  
             }
    }    

    @FXML
    private void buckAction(ActionEvent event) throws IOException {
        Parent parentInscit = FXMLLoader.load(getClass().getResource("FXMLComptClient.fxml"));
        Scene sceneInscit = new Scene(parentInscit);
        Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
        stageInscit .hide();
        stageInscit .setScene(sceneInscit );
        stageInscit .show(); 
    }
   
}
