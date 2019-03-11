/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepiniere.gui;

import java.io.IOException;
import java.net.URL;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import pepiniere.utils.StaticValue;
import pepniere.entitys.Product;
import pepniere.services.ProductService;

/**
 * FXML Controller class
 *
 * @author Nassreddine
 */
public class FXMLComptClientController implements Initializable {

    @FXML
    private Circle profilImg;
    @FXML
    private ImageView panieImg;
    @FXML
    private VBox vb;
    public  ArrayList<Product> ac = new ArrayList<Product>();
    @FXML
    private Label name;
   
   
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           if(StaticValue.listProduct==null){
            Image imag= new Image("/pepiniere/gui/images/shopping-cart-empty-side-view.png");
            panieImg.setImage(imag);
           }else{
                if(StaticValue.listProduct!=null){
             Image imag= new Image("/pepiniere/gui/images/318-39938.jpg");
             panieImg.setImage(imag);}
           }
        
            
            Image im = new Image("http://localhost/pidev4info/img/"+StaticValue.client.getImgUrl(),150,150,true,true);
             profilImg.setFill(new ImagePattern(im));
             
             name.setText(StaticValue.client.getName());
             
   
             
             
        
            ProductService ps = new ProductService();
            ArrayList<Product> arrayListProduct = ps.findAllProduct();
            for(Product p : arrayListProduct){
                System.out.println("///////////"+p.getDateAjout());
                
                 java.util.Date  temp = null ;
                 java.util.Date  t = null ;
                  try {
                    temp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(StaticValue.client.getDateLogOut());
                } catch (ParseException ex) {
                    Logger.getLogger(FXMLComptClientController.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                     t = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(p.getDateAjout());
                } catch (ParseException ex) {
                    Logger.getLogger(FXMLComptClientController.class.getName()).log(Level.SEVERE, null, ex);
                }
                long diff = t.getTime() - temp.getTime();
                    
                    int n1 = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                    int n2 = (int) TimeUnit.MINUTES.convert(diff, TimeUnit.MILLISECONDS);
                    int n3 = (int) TimeUnit.MICROSECONDS.convert(diff, TimeUnit.MILLISECONDS);
                   
                     System.out.println(".changed()"+diff);
                if((n1>0)||(n2>0)||(n3>0)){
                     VBox vb1 = new VBox();
                    VBox vb2 = new VBox(); 
                       VBox vb3 = new VBox(); 
                  
                    HBox hhb = new HBox();
                    
                    // add img to Vb1
                    
                    ImageView img = new ImageView();
                    img.setImage(new Image("http://localhost/pidev4info/img/"+p.getImage(),200,200,true,true));
                    
                     vb1.getChildren().add(img);
                     hhb.getChildren().add(vb1);
                    
                    
                       Label l1 = new Label("       Nom Produit  : "+p.getNom());
                       Label l01 = new Label("");
                       Label l2 = new Label("       Categorie Produit  : "+p.getCategorie_produit());
                       //Label l02 = new Label("");
                       Label l27 = new Label("       Prix     : "+p.getPrix());
                       Label l024 = new Label("");
                       Label lb = new Label("       Quantité disponible     : "+p.getQuantite());
                       Label lb2 = new Label("");
                       
                     
                       
                 
                       vb2.getChildren().add(l1);
                       vb2.getChildren().add(l01);
                      // vb2.getChildren().add(l02);
                       vb2.getChildren().add(l27);
                       vb2.getChildren().add(l024);
                       vb2.getChildren().add(lb);
                       vb2.getChildren().add(lb2);
                       hhb.getChildren().add(vb2);
                     
                    Button b = new Button(" Ajouter dans votre panier");
                    vb3.getChildren().add(b);
                    hhb.getChildren().add(vb3);
                    vb.getChildren().add(hhb);
              
                               EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {//add to panier
        Product product = new Product(p.getId_produit(),
                         p.getNom(),p.getImage(),p.getDescription(),p.getCategorie_produit(),p.getQuantite(),
                         p.getPrix(),p.getCategorie_plante(),p.getType_categorie_plante(),p.getDure_vie_plante(),p.getOrigin_plante(),
                         p.getPoids(),p.getSaison(),p.getTaille(),p.getCouleur(),p.getReferance(),p.getMarque(),p.getTitre(),p.getAuteur(),p.getDateAjout(),p.getId_user());
        if(StaticValue.listProduct==null){
            
         Image imag= new Image("/pepiniere/gui/images/images.png");
         panieImg.setImage(imag);
         ac.add(product);
         StaticValue.listProduct=ac;
         
          
        }
        else{
           
           
               if(StaticValue.listProduct.contains(product)){
                   Alert alert = new Alert(Alert.AlertType.INFORMATION);
                   alert.setHeaderText(null);
                   alert.setContentText("Le produit choisit est deje existe");
                   alert.showAndWait();
               }
               else{
                 ac.add(product);
                 StaticValue.listProduct=ac;
               }
           }
        }   
    
   
};
             b.setOnAction(buttonHandler);  
                       
                    
                       
                     
                   
                    
                       
                }
               
                
         
            }
    }    

    @FXML
    private void confirmAction(ActionEvent event) throws IOException {
         Parent parentInscit = FXMLLoader.load(getClass().getResource("FXMLConsulterProduitSelonDate.fxml"));
        Scene sceneInscit = new Scene(parentInscit);
        Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
        stageInscit .hide();
        stageInscit .setScene(sceneInscit );
        stageInscit .show(); 
        
    }

    @FXML
    private void consulPanieAction(MouseEvent event) throws IOException {
        if(StaticValue.listProduct==null){
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("votre panier est vide ");
        alert.showAndWait();
       }
       else{
           
         Parent parentInscit = FXMLLoader.load(getClass().getResource("FXMLConfirm.fxml"));
        Scene sceneInscit = new Scene(parentInscit);
        Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
        stageInscit .hide();
        stageInscit .setScene(sceneInscit );
        stageInscit .show(); 
             
        
        
       }
    }

    @FXML
    private void buckAction(ActionEvent event) throws IOException {
        Parent parentInscit = FXMLLoader.load(getClass().getResource("FXMLAcceuil_Client.fxml"));
        Scene sceneInscit = new Scene(parentInscit);
        Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
        stageInscit .hide();
        stageInscit .setScene(sceneInscit );
        stageInscit .show(); 
    }
    
}
