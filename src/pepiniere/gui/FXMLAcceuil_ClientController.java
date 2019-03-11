/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepiniere.gui;

import com.gnostice.pdfone.PdfDocument;
import com.gnostice.pdfone.PdfException;
import com.gnostice.pdfone.PdfPage;
import com.gnostice.pdfone.PdfPageSize;

import java.io.IOException;
import java.net.URL;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import pepiniere.utils.StaticValue;
import pepniere.entitys.Client;
import pepniere.services.UserService;
import javafx.stage.Popup;
import javafx.util.Duration;
import javax.smartcardio.CardException;
import pepniere.entitys.Command;
import pepniere.entitys.Payer;
import pepniere.entitys.Product;
import pepniere.entitys.Store;
import pepniere.services.CommandService;
import pepniere.services.ProductService;


/**
 * FXML Controller class
 *
 * @author Nassreddine
 */
public class FXMLAcceuil_ClientController implements Initializable {

    @FXML
    private Circle image;
    @FXML
    private Label name;
    @FXML
    private Label mail;
  
    @FXML
    private Label lbl;
    @FXML
    private ImageView panel;
    @FXML
    private Label nbCmd;
    @FXML
    private Label lab1;
    @FXML
    private Label lab2;
     
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int i = 0 ;
        int j = 0 ;
        if(StaticValue.listProduct==null){
            Image imag= new Image("/pepiniere/gui/images/shopping-cart-empty-side-view.png");
            panel.setImage(imag);
           }else{
                if(StaticValue.listProduct!=null){
             Image imag= new Image("/pepiniere/gui/images/318-39938.jpg");
             panel.setImage(imag);}
           }
        
      name.setText(StaticValue.client.getName());
      mail.setText(StaticValue.client.getEmail());
      lbl.setText(StaticValue.client.getName());
      Image img = new Image("http://localhost/pidev4info/img/"+StaticValue.client.getImgUrl(),150,150,true,true);
      image.setFill(new ImagePattern(img));
      
      Tooltip tooltip = new Tooltip("cliquer pour savoir plus sur votre panier");
   
    panel.setPickOnBounds(true);
    Tooltip.install(panel, tooltip); 
    
        // date system
         Calendar calendar = Calendar.getInstance();
             java.util.Date currentDate = calendar.getTime();
             java.sql.Date date = new java.sql.Date(currentDate.getTime());
             Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
             String s = formatter.format(date);
            
            java.util.Date temp = null;
        try {
            temp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(s);
        } catch (ParseException ex) {
            Logger.getLogger(FXMLComptClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        CommandService cm = new CommandService();
        ArrayList<Command> arrayListCmd = cm.findCommandById(StaticValue.client.getId());
        for(Command c : arrayListCmd){
           java.util.Date  t = null ; 
                try {
                     t = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(c.getDateAdd());
                } catch (ParseException ex) {
                    Logger.getLogger(FXMLComptClientController.class.getName()).log(Level.SEVERE, null, ex);
                }
                 long diff = temp.getTime() - t.getTime();
                 System.out.println("******************** "+ diff);
                 
                 int n = (int) TimeUnit.HOURS.convert(diff, TimeUnit.MILLISECONDS);
                 System.out.println("******************** "+ n);
                 
                 int k = cm.nbComandById(StaticValue.client.getId());
                 nbCmd.setText(" Vous avez "+k+" Commande");
                 ProductService ps = new ProductService();
                 Product p = ps.findProductById(c.getId_produit());
                 if(n>62){
                      int q = 0;
                      q = c.getQuantite()+p.getQuantite();
                      ps.updateProductAfterAddComnd(p.getId_produit(), q);
                      cm.deleteCommand(c.getId_command());
                      i++;
                 }
                 else{
                    if(n>48){
                        j++;
                    }
                 } 
                 System.out.println("i = "+i);
                  System.out.println("j = "+j);
                 if(i==0){
                         lab1.setText("Pas de commande supprimer");
                     }
                 if(i>0){
                    
                         if(i==1){
                            lab1.setText(" - une commnade a été supprimé car elle est depasseés 3 jours ");
                         }else{
                               lab1.setText(" - des commnades sont supprimés car elles sont depasseés 3 jours ");
                         }
                  }
                 if(j==0){
                      lab2.setVisible(false);
                 }
                 if(j>0){
                     if(j==1){
                        lab2.setText(" - vous avez quelque heures pour payé une commande SVP consulter votre liste de commande pour la payée ");
                     }
                   lab2.setText(" - vous avez quelque heures pour payé des commandes SVP consulter votre liste de commande pour les payées  ");
                 }
                 
        }
        
      
     }    

    @FXML
    private void palanteSttingAction(MouseEvent event) throws IOException {
        
        
                   
            Parent parentInscit = FXMLLoader.load(getClass().getResource("Offre_PlantSitting.fxml"));
        
              Scene sceneInscit = new Scene(parentInscit);
              Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
       
             stageInscit .hide();
        
             stageInscit .setScene(sceneInscit );
             stageInscit .show();
    }

    @FXML
    private void annonceAction(MouseEvent event) throws IOException {
        
        
                 Parent parentInscit = FXMLLoader.load(getClass().getResource("ajouter_annonce.fxml"));
        
              Scene sceneInscit = new Scene(parentInscit);
              Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
       
             stageInscit .hide();
        
             stageInscit .setScene(sceneInscit );
             stageInscit .show();
    }

    @FXML
    private void iventAction(MouseEvent event) throws IOException {
       Parent parentInscit = FXMLLoader.load(getClass().getResource("FXMLaffichageCLient.fxml"));
        
              Scene sceneInscit = new Scene(parentInscit);
              Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
       
             stageInscit .hide();
        
             stageInscit .setScene(sceneInscit );
             stageInscit .show();
    }

    @FXML
    private void produitAction(MouseEvent event) throws IOException {
        //interface Produit Et command Cote client Mois 
       
               
                 switchToScene("FXMLProduit_Client.fxml",event);
    
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
    private void deconectAction(ActionEvent event) throws IOException {
        
          if(StaticValue.listProduct==null){
                UserService us = new UserService();
       
        Calendar calendar = Calendar.getInstance();
        java.util.Date currentDate = calendar.getTime();
        java.sql.Date date = new java.sql.Date(currentDate.getTime());
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = formatter.format(date);
        System.out.println("********************************************"+s);
        us.updateDateLogOutUserClient(s, StaticValue.client.getId());
         Parent parentInscit = FXMLLoader.load(getClass().getResource("FXMLAuthentification.fxml"));
        Scene sceneInscit = new Scene(parentInscit);
              Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
       
             stageInscit .hide();
        
             stageInscit .setScene(sceneInscit );
             stageInscit .show();
            
           }else{
                
                    Alert alert = new Alert(AlertType.CONFIRMATION);
      alert.setTitle("Delete File");
      alert.setHeaderText("Votre panier n'est vide ?");
      alert.setContentText("Il y a des commandes à confirmer");
 
      // option != null.
      Optional<ButtonType> option = alert.showAndWait();
 
      if (option.get() == null) {
         
      } else if (option.get() == ButtonType.CANCEL) {
          Parent parentInscit = FXMLLoader.load(getClass().getResource("FXMLAcceuil_Client"));
        
              Scene sceneInscit = new Scene(parentInscit);
              Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
       
             stageInscit .hide();
        
             stageInscit .setScene(sceneInscit );
             stageInscit .show();
         
      } else if (option.get() == ButtonType.OK) {
          Parent parentInscit = FXMLLoader.load(getClass().getResource("FXMLAuthentification.fxml"));
        
              Scene sceneInscit = new Scene(parentInscit);
              Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
       
             stageInscit .hide();
        
             stageInscit .setScene(sceneInscit );
             stageInscit .show();
             StaticValue.listProduct=null;
        
      } 
           }
        
       
        
    }

    @FXML
    private void popupActoin(MouseEvent event) {
         Stage primaryStage = new Stage(); 
         primaryStage.setTitle("Notification");  
    final Popup popup = new Popup(); 
    popup.setX(1427);
    popup.setY(81);
    popup.getContent().addAll(new Circle(1427, 81, 50, Color.AQUAMARINE));
    
    
    
  
      VBox layout = new VBox();
     
      
        CommandService cv = new CommandService();
        ProductService ps = new ProductService();
        UserService us = new UserService();
    ArrayList<Command> list = cv.findCommandById(StaticValue.client.getId());
    for(Command c : list){
      Product p = ps.findProductById(c.getId_produit());
      Store s = us.FindStoreById(p.getId_user());
       HBox hb = new HBox();
      VBox vb1 = new VBox();
      VBox vb2 = new VBox();
      VBox vb3 = new VBox();
      
      ImageView img = new ImageView();
      img.setImage(new Image("http://localhost/pidev4info/img/"+p.getImage(),200,200,true,true));
      
      vb1.getChildren().add(img);
      vb1.setPrefSize(250, 200);
      
      vb2.getChildren().add( new Label(" - Nom Produit : "+p.getNom()));
      vb2.getChildren().add( new Label(" "));
      vb2.getChildren().add( new Label(" - Ctegorit Prodiut : "+p.getCategorie_produit()));
      vb2.getChildren().add( new Label(" "));
      vb2.getChildren().add( new Label(" - Quantite dispnible : "+p.getQuantite()));
      vb2.getChildren().add( new Label(" "));
      vb2.getChildren().add( new Label(" - Quantite Commandé : "+c.getQuantite()));
      vb2.getChildren().add( new Label(" "));

      
      vb2.setPrefSize(400, 200);
      
     
  

    Button supprimer = new Button("Supprimer ");
  
    
     Button modifier = new Button("Confirmer ");
  
      
     
      vb3.getChildren().add( new Label(" "));
      
      vb3.getChildren().add( modifier);
      vb3.getChildren().add( new Label(" "));
      
  
      vb3.getChildren().add( supprimer);
      vb2.setPrefSize(250, 200);
      
      hb.getChildren().addAll(vb1,vb2,vb3);
      layout.setStyle("-fx-background-color: cornsilk; -fx-padding: 10;");
      layout.getChildren().add(hb );
        supprimer.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent event) {
       
      }
    });
    
         modifier .setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent event) {
         CommandService cs = new CommandService();
        double h = c.getPrix_total();
       
       int f =  c.getQuantite();
         Calendar calendar = Calendar.getInstance();
             java.util.Date currentDate = calendar.getTime();
             java.sql.Date date = new java.sql.Date(currentDate.getTime());
             Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
             String s = formatter.format(date);
            
       
       
        
        Command cmd = new Command(f,h,s,c.getCtegorieProduit(),c.getCategoriePlante(),StaticValue.client.getId(),c.getId_produit());
        //System.out.println(".handle()");
         
      if(f<=c.getQuantite()){
          cs.addCommande(cmd);
          ProductService pss = new ProductService();
          int q = (int)c.getQuantite()-f;
          
         
          pss.updateProductAfterAddComnd(c.getId_produit(), q);
          
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
          ProductService ps = new ProductService();
        Product p =  ps.findProductById(c.getId_command());
      
    // Add the form field to the page
            try {
                String te="";
                String text="                                         - Categorie  = "+p.getNom();
                 String tex="";
                String text2="                                        - Qunantite Produit  commandé= "+c.getQuantite();
                 String t="";
                 String text3="                                       -  prix= "+f;
                  String tek="";
                 
                page1.writeText(te+"\n"+text+"\n"+tex+"\n"+text2+"\n"+t+"\n"+text3+"\n"+tek, 10, 10);
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
                doc.save("blaoc2l.pdf");
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
    });

    }
   
   
    Pane p = new Pane();
        ScrollPane pane = new ScrollPane();
    layout.setPrefSize(800,400);
    p.setPrefSize(800, 400);

    p.getChildren().add(layout);
    primaryStage.setScene(new Scene(p));
    primaryStage.show();
  }

    @FXML
    private void commandAction(MouseEvent event) throws IOException {
        Parent parentInscit = FXMLLoader.load(getClass().getResource("FXMLComptClient.fxml"));
        
              Scene sceneInscit = new Scene(parentInscit);
              Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
       
             stageInscit .hide();
        
             stageInscit .setScene(sceneInscit );
             stageInscit .show();
    }
    

   
    
}
