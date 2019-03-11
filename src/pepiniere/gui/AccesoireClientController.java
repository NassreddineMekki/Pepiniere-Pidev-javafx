/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepiniere.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import pepiniere.utils.StaticValue;
import pepniere.entitys.Accessoire;
import pepniere.services.AccessoireServices;
import static pepiniere.gui.FXMLProduit_ClientController.x;


/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AccesoireClientController implements Initializable {
 @FXML
    private JFXListView<Pane> ListView_Produits;
    AccessoireServices ls = new AccessoireServices(); 
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ListView_Produits.setFocusTraversable( false );
             getShowPane();
             
            
    }    
    public void getShowPane()
    {
        List <Accessoire> AllProducts  = new ArrayList();
        
            for (Accessoire p:ls.listerAccessoire(x) )
        {
            AllProducts.add(p);
        }
        
        int i=0;
        int j=0;
        ObservableList<Pane> Panes = FXCollections.observableArrayList();  

        List <Accessoire> ThreeProducts= new ArrayList();
        for (Accessoire p:AllProducts )
        {
            if(i==0)
            {
                ThreeProducts.add(p);
                i++;
                j++;
            
                   if(j==AllProducts.size())
                {
                    Panes.add(AddPane(ThreeProducts));
                
                    ThreeProducts.clear();
                }
            
            
            }
            else
            {
                ThreeProducts.add(p);
                    i++;
                    j++;
                if((i%3==0)||(j==AllProducts.size()))
                {
                    Panes.add(AddPane(ThreeProducts));
                
                    ThreeProducts.clear();
                    
                }
            }
        }
       
         ObservableList<Pane> refresh = FXCollections.observableArrayList();  
       ListView_Produits.setItems(refresh);
       ListView_Produits.setItems(Panes);
}
    
      public Pane AddPane( List<Accessoire> ThreeProduct)
    {
        Pane pane = new Pane();
        pane.setStyle(" -fx-background-color: white");
                    int k =1;
                    for (Accessoire p3:ThreeProduct )
                        {
                         if(k == 1)
                            {
                                Pane pane2=new Pane();
                                pane2.setLayoutX(25);
                                pane2.setLayoutY(50);
                                pane2.setPrefWidth(pane2.getWidth() + 215); 
                                pane2.setPrefHeight(pane2.getHeight() + 200);
                                
                                //pane2.setStyle("-fx-background-radius: 50;");
        pane2.setStyle(" -fx-border-radius: 10;-fx-border-color: #383d3b ;-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0); ");
                        JFXButton t=new JFXButton("détails");  
                        t.setOnAction(e->{
                        
             try {
           final URL url =  getClass().getResource("DetailsLivreClient.fxml"); 
           final FXMLLoader loader = new FXMLLoader(url);
           final AnchorPane root = (AnchorPane) loader.load();
           final Scene scene = new Scene(root);
           final Stage stage = new Stage();
              stage.setScene(scene);
              stage.show();
             
         
           } catch(Exception ex) 
           {ex.printStackTrace();}
    
      } 
                        
                        );
                        
                       
                        t.setStyle("-fx-font-weight: bold;");
                        
                        
                        HBox hb=new HBox(t);
                     
                        
                        
                                hb.setLayoutX(20);
                                hb.setLayoutY(170);
                                hb.setPrefWidth(hb.getWidth() + 160); 
                                hb.setPrefHeight(hb.getHeight() + 35);
                                hb.setStyle("-fx-background-color: #ea7066; -fx-background-radius: 0 0 0 10;");
                                
                                
                                pane2.getChildren().addAll(hb);
                                
                                String A = p3.getImage();
                              A = "C:\\xampp\\htdocs\\pidev4info\\img\\"+A;
                                          File F1 = new File(A);
                                           Image image2 = new Image(F1.toURI().toString());
                                           
                                           
                                           System.out.println(p3.getImage().toString());
                                          
                                ImageView image=new ImageView();
                                image.setFitWidth(140);
                                image.setFitHeight(130);
                                image.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0);");

                                image.setImage(image2);
                                image.setLayoutX(40);
                                image.setLayoutY(-45);
                                pane2.getChildren().add(image);
                         
                               
                                
                             
                                Text nomt=new Text("Nom : ");
                                Label nom = new Label(p3.getNom());
                                Text prixt=new Text("prix : ");
                                Label prix = new Label(String.valueOf(p3.getPrix())+" DT");
                                nomt.setLayoutX(50);
                                nomt.setLayoutY(160);
                                nom.setLayoutX(100);
                                nom.setLayoutY(145);
                                prixt.setLayoutX(50);
                                prixt.setLayoutY(180);
                                prix.setLayoutX(100);
                                prix.setLayoutY(165);
                                nomt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                                prixt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                                                 pane.getChildren().addAll(pane2,nomt,prixt,nom,prix);

                            }
                     
        
                                        
                                       
                                        
           ///////////////////////////////////              
           ///////////////////////////////////              
           ///////////////////////////////////              
           ///////////////////////////////////              
           ///////////////////////////////////              
                            if(k == 2)
                            {
                               Pane pane2=new Pane();
                                pane2.setLayoutX(300);
                                pane2.setLayoutY(50);
                                pane2.setPrefWidth(pane2.getWidth() + 215); 
                                pane2.setPrefHeight(pane2.getHeight() + 200);
                                //pane2.setStyle("-fx-background-radius: 50;");
        pane2.setStyle(" -fx-border-radius: 10 ;-fx-border-color: #383d3b ;-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0); ");
                            
                        JFXButton t=new JFXButton("détails");    
                        t.setStyle("-fx-font-weight: bold;");
                        
                                    t.setOnAction(e->{
                        
             try {
           final URL url =  getClass().getResource("DetailsLivreClient.fxml"); 
           final FXMLLoader loader = new FXMLLoader(url);
           final AnchorPane root = (AnchorPane) loader.load();
           final Scene scene = new Scene(root);
           final Stage stage = new Stage();
              stage.setScene(scene);
              stage.show();
             
         
           } catch(Exception ex) 
           {ex.printStackTrace();}
    
      } 
                        
                        );
                        
                        HBox hb=new HBox(t);
                     
                        
                        
                                hb.setLayoutX(20);
                                hb.setLayoutY(170);
                                hb.setPrefWidth(hb.getWidth() + 160); 
                                hb.setPrefHeight(hb.getHeight() + 35);
                                hb.setStyle("-fx-background-color: #ea7066; -fx-background-radius: 0 0 0 10;");
                                
                                
                                pane2.getChildren().addAll(hb);
                                
                                String A = p3.getImage();
                               A = "C:\\xampp\\htdocs\\pidev4info\\img\\"+A;
                                          File F1 = new File(A);
                                           Image image2 = new Image(F1.toURI().toString());
                                          
                                ImageView image=new ImageView();
                                image.setFitWidth(140);
                                image.setFitHeight(130);
                                image.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0);");

                                image.setImage(image2);
                                image.setLayoutX(40);
                                image.setLayoutY(-45);
                                pane2.getChildren().add(image);
                           
                                
                            
                                
                                Text nomt=new Text("Nom : ");
                                Label nom = new Label(p3.getNom());
                                Text prixt=new Text("prix : ");
                                Label prix = new Label(String.valueOf(p3.getPrix())+" DT");
                                nomt.setLayoutX(325);
                                nomt.setLayoutY(160);
                                nom.setLayoutX(375);
                                nom.setLayoutY(145);
                                prixt.setLayoutX(325);
                                prixt.setLayoutY(180);
                                prix.setLayoutX(375);
                                prix.setLayoutY(165);
                                nomt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                                prixt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                         pane.getChildren().addAll(pane2,nomt,prixt,nom,prix);
                            }
                                                    

                            if(k == 3)
                                {
                                   Pane pane2=new Pane();
                                pane2.setLayoutX(575);
                                pane2.setLayoutY(50);
                                pane2.setPrefWidth(pane2.getWidth() + 215); 
                                pane2.setPrefHeight(pane2.getHeight() + 200);
                                //pane2.setStyle("-fx-background-radius: 50;");
        pane2.setStyle(" -fx-border-radius: 10;-fx-border-color: #383d3b ;-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0); ");
                            
                        JFXButton t=new JFXButton("détails");   
                        
                        
                        t.setStyle("-fx-font-weight: bold;");
                        
                                    t.setOnAction(e->{
                        
             try {
           final URL url =  getClass().getResource("DetailsLivreClient.fxml"); 
           final FXMLLoader loader = new FXMLLoader(url);
           final AnchorPane root = (AnchorPane) loader.load();
           final Scene scene = new Scene(root);
           final Stage stage = new Stage();
              stage.setScene(scene);
              stage.show();
             
         
           } catch(Exception ex) 
           {ex.printStackTrace();}
    
      } 
                        
                        );
                        HBox hb=new HBox(t);
                       
                        
                        
                                hb.setLayoutX(20);
                                hb.setLayoutY(170);
                                hb.setPrefWidth(hb.getWidth() + 160); 
                                hb.setPrefHeight(hb.getHeight() + 35);
                                hb.setStyle("-fx-background-color: #ea7066; -fx-background-radius: 0 0 0 10;");
                                
                                
                                pane2.getChildren().addAll(hb);
                                
                                String A = p3.getImage();
                          A = "C:\\xampp\\htdocs\\pidev4info\\img\\"+A;
                                          File F1 = new File(A);
                                           Image image2 = new Image(F1.toURI().toString());
                                          
                                ImageView image=new ImageView();
                                image.setFitWidth(140);
                                image.setFitHeight(130);
                                image.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0);");

                                image.setImage(image2);
                                image.setLayoutX(40);
                                image.setLayoutY(-45);
                                pane2.getChildren().add(image);
                                
                           
                             
                                Text nomt=new Text("Nom : ");
                                Label nom = new Label(p3.getNom());
                                Text prixt=new Text("prix : ");
                                Label prix = new Label(String.valueOf(p3.getPrix())+" DT");
                                nomt.setLayoutX(600);
                                nomt.setLayoutY(160);
                                nom.setLayoutX(650);
                                nom.setLayoutY(145);
                                prixt.setLayoutX(600);
                                prixt.setLayoutY(180);
                                prix.setLayoutX(650);
                                prix.setLayoutY(165);
                                nomt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                                prixt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                           
                        pane.getChildren().addAll(pane2,nomt,prixt,nom,prix);
                                    
                                }
                            k++;
                            
                            }
                    return pane;
    }

    @FXML
    private void retoureAccueil(MouseEvent event) throws IOException {
               switchToScene("ListeProduitBoutiqueClient.fxml",event);

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
