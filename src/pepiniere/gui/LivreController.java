/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepiniere.gui;

import com.jfoenix.controls.JFXButton;
import pepniere.entitys.Livre;
import pepniere.services.LivreServices;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pepiniere.utils.StaticValue;
import pepiniere.utils.Upload;
import pepniere.services.LivreServices;
       

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class LivreController implements Initializable {
        private File file;
                   String pic;
    private Image imageBut;
 @FXML
       private TableView<Livre> tabview;
    @FXML
    private TableColumn <Livre, String>nom;
    @FXML
    private TableColumn<Livre, ImageView> image;
    @FXML
    private TableColumn<Livre, Integer>quantite;
    @FXML
    private TableColumn<Livre, Integer> prix;
    @FXML
    private TableColumn <Livre, String> description;
    @FXML
    private TableColumn <Livre, String> auteur;
    @FXML
    private TableColumn <Livre, String> titre;
    @FXML
    private TextField nomLabel;
    @FXML
    private TextField imageLabel;
    @FXML
    private TextField prixLabel;
    @FXML
    private TextField descriptionLabel;
    @FXML
    private TextField titreLabel;
    @FXML
    private TextField auteurLabel;
    @FXML
    private TextField quantiteLabel;
    
     LivreServices serviceLivre = new LivreServices();
     Livre c = new Livre();
       ImageView img = new ImageView();
    @FXML
    private JFXButton bouttonimage;
 
    
    @FXML
         public void supprimerLivre(ActionEvent event) {
 
             Alert dialogC = new Alert(Alert.AlertType.CONFIRMATION);
dialogC.setTitle(" Confirmation ");
dialogC.setHeaderText(null);
dialogC.setContentText("Etes-vous sûr de vouloir supprimer "+tabview.getSelectionModel().getSelectedItem().getNom());
             Optional<ButtonType> answer = dialogC.showAndWait();
if (answer.get() == ButtonType.OK) {
    
     
    
 
    
     int x = tabview.getSelectionModel().getSelectedItem().getId_produit() ;
     
     
       serviceLivre.supprimerLivre(x);
        
        ArrayList arraylist = (ArrayList) serviceLivre.listerLivres(StaticValue.store.getId());

        ObservableList obs = FXCollections.observableArrayList(arraylist);
        tabview.setItems(obs);


     
              
         
         }}
         
         
        
             
    @FXML
  public void modifier(ActionEvent event) throws SQLException
{    Calendar calendar = Calendar.getInstance();
             java.util.Date currentDate = calendar.getTime();
             java.sql.Date date = new java.sql.Date(currentDate.getTime());
             Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
             String s = formatter.format(date);
    //Livre b= new Livre ("s","b","b","b","Livre",2,"2",3);
   Livre a = new Livre(titreLabel.getText(),auteurLabel.getText(),nomLabel.getText(),imageLabel.getText(),
           "Livre",Integer.parseInt(quantiteLabel.getText()),descriptionLabel.getText(),Float.parseFloat(prixLabel.getText()),StaticValue.store.getId(),s);
       int x = tabview.getSelectionModel().getSelectedItem().getId_produit() ;
int i = StaticValue.store.getId();


   serviceLivre.updateLivre(a,x);
  

     ArrayList arraylist = (ArrayList) serviceLivre.listerLivres(StaticValue.store.getId());

        ObservableList obs = FXCollections.observableArrayList(arraylist);
        tabview.setItems(obs);
          nomLabel.setText("");
       imageLabel.setText("");
       prixLabel.setText("") ;
       quantiteLabel.setText("");
       descriptionLabel.setText("");
       auteurLabel.setText("");
       titreLabel.setText("");
}
  
  
  
      @FXML
  public void ajouter(ActionEvent event) throws SQLException
{   
     Calendar calendar = Calendar.getInstance();
             java.util.Date currentDate = calendar.getTime();
             java.sql.Date date = new java.sql.Date(currentDate.getTime());
             Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
             String s = formatter.format(date);
   Livre a = new Livre(titreLabel.getText(),auteurLabel.getText(),nomLabel.getText(),String.valueOf(imageLabel.getText()),
           "Livre",Integer.parseInt(quantiteLabel.getText()),descriptionLabel.getText(),Float.parseFloat(prixLabel.getText()),StaticValue.store.getId(),s);

   serviceLivre.ajoutLivre(a);
  

     ArrayList arraylist = (ArrayList) serviceLivre.listerLivres(StaticValue.store.getId());

        ObservableList obs = FXCollections.observableArrayList(arraylist);
        tabview.setItems(obs);
          nomLabel.setText("");
       imageLabel.setText("");
       prixLabel.setText("") ;
       quantiteLabel.setText("");
       descriptionLabel.setText("");
       auteurLabel.setText("");
       titreLabel.setText("");
}
    
          public void setcelulfromtabView()
         {tabview.setOnMouseClicked(e->
                 {
                     nomLabel.setText(tabview.getSelectionModel().getSelectedItem().getNom()+"");
      imageLabel.setText(tabview.getSelectionModel().getSelectedItem().getImage()+"");

       prixLabel.setText(tabview.getSelectionModel().getSelectedItem().getPrix()+"");
             quantiteLabel.setText(tabview.getSelectionModel().getSelectedItem().getQuantite()+"");

       descriptionLabel.setText(tabview.getSelectionModel().getSelectedItem().getDescription()+"") ;
       auteurLabel.setText(tabview.getSelectionModel().getSelectedItem().getAuteur()+"");
        titreLabel.setText(tabview.getSelectionModel().getSelectedItem().getTitre()+"");  
        
        
     /*    File f = new File("C:\\wamp\\www\\pidev3info\\img\\"+c.getImage());
 imageViewLivre.setImage(new Image("http://localhost/pidev3info/img/livre",100,100,true,true));

        System.out.println(f.toURI().toString());
                System.out.println(f.toURI().toString());

        */
     
     
        
       /* Image IMAGE_RUBY = new Image(f.toURI().toString());
        
        imageViewLivre.setFitHeight(100);
        imageViewLivre.setFitWidth(100);
        Rectangle clip = new Rectangle(
                imageViewLivre.getFitWidth(), imageViewLivre.getFitHeight()
        );

        clip.setArcWidth(20);
        clip.setArcHeight(20);
        imageViewLivre.setClip(clip);
        
        
          SnapshotParameters parameters = new SnapshotParameters();
        parameters.setFill(Color.TRANSPARENT);
        WritableImage image = imageViewLivre.snapshot(parameters, null);

        // remove the rounding clip so that our effect can show through.
        imageViewLivre.setClip(null);

        // apply a shadow effect.
        imageViewLivre.setEffect(new DropShadow(20, Color.BLACK));
        
         imageViewLivre.setImage(IMAGE_RUBY);
        */
                 } );
         
         }
   
          
 @FXML
    public void retoureAccueil(MouseEvent event) throws IOException
{ 
    
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
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        LivreServices ms=new LivreServices();
        ArrayList arraylist=(ArrayList) ms.listerLivres(StaticValue.store.getId());
        ms.afficherListeLivres(StaticValue.store.getId());
        ObservableList obs=FXCollections.observableArrayList(arraylist);
                     
        
        img.setImage(new Image("http://localhost/pidev3info/img/"+c.getImage(),100,100,true,true));

        
        
               
       
        
       nom.setCellValueFactory(new PropertyValueFactory<Livre, String>("nom"));
        image.setCellValueFactory(new PropertyValueFactory<Livre, ImageView>("image"));
         prix.setCellValueFactory(new PropertyValueFactory<Livre, Integer>("prix"));
          quantite.setCellValueFactory(new PropertyValueFactory<Livre, Integer>("quantite"));
           description.setCellValueFactory(new PropertyValueFactory<Livre, String>("description"));

           
           auteur.setCellValueFactory(new PropertyValueFactory<Livre, String>("auteur"));
             titre.setCellValueFactory(new PropertyValueFactory<Livre, String>("titre"));
           
       
 
             
              
              tabview.setItems(obs);        
        // TODO
         nomLabel.setText("");
       imageLabel.setText("");
       prixLabel.setText("") ;
       quantiteLabel.setText("");
       descriptionLabel.setText("");
       auteurLabel.setText("");
       titreLabel.setText("");
 
        setcelulfromtabView();
}    
    
    @FXML
    private void bouttonimage(ActionEvent event) throws IOException {
        
      FileChooser fileChooser = new FileChooser();
            file= fileChooser.showOpenDialog(null);
             FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

            
            pic=(file.toURI().toString());
            pic=new Upload().upload(file,"");
            System.out.println(pic);
             imageLabel.setText(pic);
           imageBut= new Image("http://localhost/pidev3info/img/"+pic);

    }
}
