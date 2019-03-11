/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepiniere.gui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pepiniere.utils.StaticValue;
import pepiniere.utils.Upload;
import pepniere.entitys.Accessoire;
import pepniere.services.AccessoireServices;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AccesoireController implements Initializable {
            private File file;
                   String pic;
    private Image imageBut;

    @FXML
    private TableView<Accessoire> tabview;
    @FXML
    private TableColumn<Accessoire, String> nom;
    @FXML
    private TableColumn<Accessoire, String> image;
    @FXML
    private TableColumn<Accessoire, Integer> prix;
    @FXML
    private TableColumn<Accessoire, Integer> quantite;
    @FXML
    private TableColumn<Accessoire, String> description;
    @FXML
    private TableColumn<Accessoire, String> reference;
    @FXML
    private TableColumn<Accessoire, String> marque;
    @FXML
    private TableColumn<Accessoire, Integer> poids;
    @FXML
    private Button ajouter;
    @FXML
    private Button supprimer;
    @FXML
    private Button modifier;
    @FXML
    private TextField nomLabel;
    @FXML
    private TextField imageLabel;
    @FXML
    private TextField prixLabel;
    @FXML
    private TextField descriptionLabel;
    @FXML
    private TextField marqueLabel;
    @FXML
    private TextField referenceLabel;
    @FXML
    private TextField quantiteLabel;
      @FXML
    private TextField poidsLabel;

 AccessoireServices serviceAcce = new AccessoireServices();
     Accessoire c = new Accessoire();
     //  ImageView img = new ImageView();
     
   
 
   
    @FXML
         public void supprimer(ActionEvent event) {
 
             Alert dialogC = new Alert(Alert.AlertType.CONFIRMATION);
dialogC.setTitle(" Confirmation ");
dialogC.setHeaderText(null);
dialogC.setContentText("Etes-vous sûr de vouloir supprimer "+tabview.getSelectionModel().getSelectedItem().getNom());
             Optional<ButtonType> answer = dialogC.showAndWait();
if (answer.get() == ButtonType.OK) {
    
     
    
 
    
     int x = tabview.getSelectionModel().getSelectedItem().getId_produit() ;
     
     System.out.println(x);
       serviceAcce.supprimerAccessoire(x);
        
        ArrayList arraylist = (ArrayList) serviceAcce.listerAccessoire(StaticValue.store.getId());

        ObservableList obs = FXCollections.observableArrayList(arraylist);
        tabview.setItems(obs);


     
              
         
         }}
         
        
        
             
    @FXML
  public void modifier(ActionEvent event) throws SQLException
{   
   Calendar calendar = Calendar.getInstance();
             java.util.Date currentDate = calendar.getTime();
             java.sql.Date date = new java.sql.Date(currentDate.getTime());
             Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
             String s = formatter.format(date);
   Accessoire a = new Accessoire(referenceLabel.getText(),marqueLabel.getText(),Integer.parseInt(poidsLabel.getText()),nomLabel.getText(),imageLabel.getText(),"Accessoire",Integer.parseInt(quantiteLabel.getText()),descriptionLabel.getText(),Float.parseFloat(prixLabel.getText()),StaticValue.store.getId(),s);
       int x = tabview.getSelectionModel().getSelectedItem().getId_produit() ;

   serviceAcce.updateAccessoire(a,x);
  

     ArrayList arraylist = (ArrayList) serviceAcce.listerAccessoire(StaticValue.store.getId());

        ObservableList obs = FXCollections.observableArrayList(arraylist);
        tabview.setItems(obs);
          nomLabel.setText("");
       imageLabel.setText("");
       prixLabel.setText("") ;
       quantiteLabel.setText("");
       descriptionLabel.setText("");
       marqueLabel.setText("");
       referenceLabel.setText("");
       poidsLabel.setText("");
}
  
  
  
    @FXML
  public void ajouter(ActionEvent event) throws SQLException
{    Calendar calendar = Calendar.getInstance();
             java.util.Date currentDate = calendar.getTime();
             java.sql.Date date = new java.sql.Date(currentDate.getTime());
             Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
             String s = formatter.format(date);
   Accessoire a = new Accessoire(referenceLabel.getText(),marqueLabel.getText(),Integer.parseInt(poidsLabel.getText()),nomLabel.getText(),String.valueOf(imageLabel.getText()),"Accessoire",Integer.parseInt(quantiteLabel.getText()),descriptionLabel.getText(),Float.parseFloat(prixLabel.getText()),StaticValue.store.getId(),s);

   serviceAcce.ajoutAccessoire(a);
  

     ArrayList arraylist = (ArrayList) serviceAcce.listerAccessoire(StaticValue.store.getId());

        ObservableList obs = FXCollections.observableArrayList(arraylist);
        tabview.setItems(obs);
          nomLabel.setText("");
       imageLabel.setText("");
       prixLabel.setText("") ;
       quantiteLabel.setText("");
       descriptionLabel.setText("");
       referenceLabel.setText("");
       marqueLabel.setText("");
       poidsLabel.setText("");
}
    
          public void setcelulfromtabView()
         {tabview.setOnMouseClicked(e->
                 {
                     System.out.println( tabview.getSelectionModel().getSelectedItem().getRefrence());
                     nomLabel.setText(tabview.getSelectionModel().getSelectedItem().getNom()+"");
      imageLabel.setText(tabview.getSelectionModel().getSelectedItem().getImage()+"");

       prixLabel.setText(tabview.getSelectionModel().getSelectedItem().getPrix()+"");
             quantiteLabel.setText(tabview.getSelectionModel().getSelectedItem().getQuantite()+"");

       descriptionLabel.setText(tabview.getSelectionModel().getSelectedItem().getDescription()+"") ;
       referenceLabel.setText(tabview.getSelectionModel().getSelectedItem().getRefrence()+"");
        marqueLabel.setText(tabview.getSelectionModel().getSelectedItem().getMarque()+"");  
        poidsLabel.setText(tabview.getSelectionModel().getSelectedItem().getPoids()+"");  
        
                     
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
        
         imageViewLivre.setImage(IMAGE_RUBY);*/
        
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
       
        AccessoireServices ms=new AccessoireServices();
        ArrayList arraylist=(ArrayList) ms.listerAccessoire(StaticValue.store.getId());
        ms.afficherListeAccessoire(StaticValue.store.getId());
        ObservableList obs=FXCollections.observableArrayList(arraylist);
                     
        
   //     img.setImage(new Image("http://localhost/pidev3info/img/"+c.getImage(),100,100,true,true));

        
        
               
       
        
       nom.setCellValueFactory(new PropertyValueFactory<Accessoire, String>("nom"));
        image.setCellValueFactory(new PropertyValueFactory<Accessoire,String>("image"));
         prix.setCellValueFactory(new PropertyValueFactory<Accessoire, Integer>("prix"));
          quantite.setCellValueFactory(new PropertyValueFactory<Accessoire, Integer>("quantite"));
           description.setCellValueFactory(new PropertyValueFactory<Accessoire, String>("description"));
             reference.setCellValueFactory(new PropertyValueFactory<Accessoire, String>("refrence"));
             marque.setCellValueFactory(new PropertyValueFactory<Accessoire, String>("marque"));
                       poids.setCellValueFactory(new PropertyValueFactory<Accessoire, Integer>("poids"));

             
           
       
 
             
              
              tabview.setItems(obs);        
        // TODO
         nomLabel.setText("");
       imageLabel.setText("");
       prixLabel.setText("") ;
       quantiteLabel.setText("");
       descriptionLabel.setText("");
       referenceLabel.setText("");
       marqueLabel.setText("");
       poidsLabel.setText("");
 
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

