/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepiniere.gui;
import com.jfoenix.controls.JFXButton;
import javafx.util.Duration;
//import org.controlsfx.control.Notifications;
 import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
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
import javafx.geometry.Pos;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pepiniere.utils.StaticValue;
import pepiniere.utils.Upload;
 import pepniere.entitys.Plante;
 import pepniere.services.PlanteServices;
 



/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class PlanteController implements Initializable {

    private JFXListView<String> listeView;
    @FXML
    private TableView<Plante> tabview;
    @FXML
    private TableColumn<Plante, String> nom;
    @FXML
    private TableColumn<Plante, String> image;
    @FXML
    private TableColumn<Plante, Integer> prix;
    @FXML
    private TableColumn<Plante, Integer> quantite;
    @FXML
    private TableColumn<Plante, String> description;
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
    private TextField quantiteLabel;

    @FXML
    private TableColumn<Plante,String> type;
    @FXML
    private TableColumn<Plante, String> tempsvie;
    @FXML
    private TableColumn<Plante,String> couleur;
    @FXML
    private TableColumn<Plante,Integer> poids;
    @FXML
    private TableColumn<Plante, String> saison;
    @FXML
    private TableColumn<Plante,Integer> taille;
    @FXML
    private TextField OrigineLabel;
    @FXML
    private TextField CategorieLabel;
    @FXML
    private TextField tailleLabel;
    @FXML
    private TextField saisonLabel;
    @FXML
    private TextField CouleurLabel;
    @FXML
    private TextField poidsLabel;
    @FXML
    private TextField DureeLabel;

 PlanteServices servicePlante = new PlanteServices();
     Plante c = new Plante();
       ImageView img = new ImageView();
    @FXML
    private TextField typeLabel;
    @FXML
    private TableColumn<Plante,String> origine;
    @FXML
    private TableColumn<Plante,String> plancat;
    @FXML
    private JFXTextField search;
    @FXML
    private JFXButton bouttonimage;
               private File file;
                   String pic;
    private Image imageBut;


 
    
     
    
    @FXML
         public void supprimer(ActionEvent event) {
 
             Alert dialogC = new Alert(Alert.AlertType.CONFIRMATION);
dialogC.setTitle(" Confirmation ");
dialogC.setHeaderText(null);
dialogC.setContentText("Etes-vous sûr de vouloir supprimer "+tabview.getSelectionModel().getSelectedItem().getNom());
             Optional<ButtonType> answer = dialogC.showAndWait();
if (answer.get() == ButtonType.OK) {
    
     
    
 
    
     int x = tabview.getSelectionModel().getSelectedItem().getId_produit() ;
     
     
       servicePlante.supprimerPlante(x);
        
        ArrayList arraylist = (ArrayList) servicePlante.listerPlante(StaticValue.store.getId());

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
    Plante a = new Plante(CategorieLabel.getText(),typeLabel.getText(),DureeLabel.getText(),
            OrigineLabel.getText(),Integer.parseInt(poidsLabel.getText()),saisonLabel.getText(),
            Integer.parseInt(tailleLabel.getText()),CouleurLabel.getText(),nomLabel.getText(),
            imageLabel.getText(),"Plante",Integer.parseInt(quantiteLabel.getText()),
            descriptionLabel.getText(),Float.parseFloat(prixLabel.getText()),StaticValue.store.getId(),s);
       int x = tabview.getSelectionModel().getSelectedItem().getId_produit() ;
       
 
   servicePlante.updatePlante(a,x);
  

     ArrayList arraylist = (ArrayList) servicePlante.listerPlante(StaticValue.store.getId());

        ObservableList obs = FXCollections.observableArrayList(arraylist);
        tabview.setItems(obs);
          nomLabel.setText("");
       imageLabel.setText("");
       prixLabel.setText("") ;
       quantiteLabel.setText("");
       descriptionLabel.setText("");
       CategorieLabel.setText("");
       typeLabel.setText("");
              DureeLabel.setText("");
       OrigineLabel.setText("");
       poidsLabel.setText("");
       saisonLabel.setText("");
       tailleLabel.setText("");
       CouleurLabel.setText("");
      

}
  
  
  
      @FXML
  public void ajouter(ActionEvent event) throws SQLException
{   
    Calendar calendar = Calendar.getInstance();
             java.util.Date currentDate = calendar.getTime();
             java.sql.Date date = new java.sql.Date(currentDate.getTime());
             Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
             String s = formatter.format(date);
   Plante a = new Plante(CategorieLabel.getText(),typeLabel.getText(),DureeLabel.getText(),OrigineLabel.getText(),
           Integer.parseInt(poidsLabel.getText()),saisonLabel.getText(),Integer.parseInt(tailleLabel.getText()),
           CouleurLabel.getText(),nomLabel.getText(),String.valueOf(imageLabel.getText()),"Plante",
           Integer.parseInt(quantiteLabel.getText()),descriptionLabel.getText(),Float.parseFloat(prixLabel.getText()),StaticValue.store.getId(),s);

   servicePlante.ajoutPlante(a);
   
         
                
   
   
    
  

     ArrayList arraylist = (ArrayList) servicePlante.listerPlante(StaticValue.store.getId());

        ObservableList obs = FXCollections.observableArrayList(arraylist);
        tabview.setItems(obs);
           nomLabel.setText("");
       imageLabel.setText("");
       prixLabel.setText("") ;
       quantiteLabel.setText("");
       descriptionLabel.setText("");
       CategorieLabel.setText("");
       typeLabel.setText("");
              DureeLabel.setText("");
       OrigineLabel.setText("");
       poidsLabel.setText("");
       saisonLabel.setText("");
       tailleLabel.setText("");
       CouleurLabel.setText("");
                    Image img = new Image("/app.jpg");

        // Notifications notificationBuilder = Notifications.create()
              
  
}
    
          public void setcelulfromtabView()
         {tabview.setOnMouseClicked(e->
                 {
                     nomLabel.setText(tabview.getSelectionModel().getSelectedItem().getNom()+"");
      imageLabel.setText(tabview.getSelectionModel().getSelectedItem().getImage()+"");

       prixLabel.setText(tabview.getSelectionModel().getSelectedItem().getPrix()+"");
             quantiteLabel.setText(tabview.getSelectionModel().getSelectedItem().getQuantite()+"");

       descriptionLabel.setText(tabview.getSelectionModel().getSelectedItem().getDescription()+"") ;
            CategorieLabel.setText(tabview.getSelectionModel().getSelectedItem().getCategoriePlante()+"");
        typeLabel.setText(tabview.getSelectionModel().getSelectedItem().getType_categorie()+"");  
             DureeLabel.setText(tabview.getSelectionModel().getSelectedItem().getDuree_vie()+"");
        OrigineLabel.setText(tabview.getSelectionModel().getSelectedItem().getOrigine()+"");  
             poidsLabel.setText(tabview.getSelectionModel().getSelectedItem().getPoids()+"");
        saisonLabel.setText(tabview.getSelectionModel().getSelectedItem().getSaison()+"");  
             tailleLabel.setText(tabview.getSelectionModel().getSelectedItem().getTaille()+"");
        CouleurLabel.setText(tabview.getSelectionModel().getSelectedItem().getCouleur()+"");  
         
     
    

        
        
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
       
        PlanteServices ms=new PlanteServices();
        ArrayList arraylist=(ArrayList) ms.listerPlante(StaticValue.store.getId());
        ms.afficherListePlante(StaticValue.store.getId());
        ObservableList obs=FXCollections.observableArrayList(arraylist);
                     
        
        img.setImage(new Image("http://localhost/pidev3info/img/"+c.getImage(),100,100,true,true));

        
        
               
       
        
       nom.setCellValueFactory(new PropertyValueFactory<Plante,String>("nom"));
        image.setCellValueFactory(new PropertyValueFactory<Plante,String>("image"));
         prix.setCellValueFactory(new PropertyValueFactory<Plante,Integer>("prix"));
          quantite.setCellValueFactory(new PropertyValueFactory<Plante,Integer>("quantite"));
           description.setCellValueFactory(new PropertyValueFactory<Plante,String>("description"));
              type.setCellValueFactory(new PropertyValueFactory<Plante,String>("type_categorie"));
             plancat.setCellValueFactory(new PropertyValueFactory<Plante,String>("categoriePlante"));
              tempsvie.setCellValueFactory(new PropertyValueFactory<Plante,String>("duree_vie"));
 
            saison.setCellValueFactory(new PropertyValueFactory<Plante,String>("saison"));
            taille.setCellValueFactory(new PropertyValueFactory<Plante,Integer>("taille"));
             couleur.setCellValueFactory(new PropertyValueFactory<Plante,String>("couleur"));
            poids.setCellValueFactory(new PropertyValueFactory<Plante,Integer>("poids"));
             origine.setCellValueFactory(new PropertyValueFactory<Plante, String>("origine"));
           
       
 
             
              
              tabview.setItems(obs);        
        // TODO
          nomLabel.setText("");
       imageLabel.setText("");
       prixLabel.setText("") ;
       quantiteLabel.setText("");
       descriptionLabel.setText("");
       CategorieLabel.setText("");
       typeLabel.setText("");
              DureeLabel.setText("");
       OrigineLabel.setText("");
       poidsLabel.setText("");
       saisonLabel.setText("");
       tailleLabel.setText("");
       CouleurLabel.setText("");


 
        setcelulfromtabView();
}    

    @FXML
    private void finKey(KeyEvent event) {
        
        String mot = search.getText();
        PlanteServices sb = new PlanteServices();
           if (mot.length() > 0) {
            System.out.println("Eveneement Ok ");
            ArrayList<Plante> rec = (ArrayList<Plante>) sb.rechercher(mot,StaticValue.store.getId());
            ObservableList<Plante> find = FXCollections.observableArrayList(sb.rechercher(mot,StaticValue.store.getId()));
            tabview.getItems().clear();
             
        img.setImage(new Image("http://localhost/pidev3info/img/"+c.getImage(),100,100,true,true));

        
        
               
       
        
       nom.setCellValueFactory(new PropertyValueFactory<Plante,String>("nom"));
        image.setCellValueFactory(new PropertyValueFactory<Plante,String>("image"));
         prix.setCellValueFactory(new PropertyValueFactory<Plante,Integer>("prix"));
          quantite.setCellValueFactory(new PropertyValueFactory<Plante,Integer>("quantite"));
           description.setCellValueFactory(new PropertyValueFactory<Plante,String>("description"));
              type.setCellValueFactory(new PropertyValueFactory<Plante,String>("type_categorie"));
             plancat.setCellValueFactory(new PropertyValueFactory<Plante,String>("categoriePlante"));
              tempsvie.setCellValueFactory(new PropertyValueFactory<Plante,String>("duree_vie"));
 
            saison.setCellValueFactory(new PropertyValueFactory<Plante,String>("saison"));
            taille.setCellValueFactory(new PropertyValueFactory<Plante,Integer>("taille"));
             couleur.setCellValueFactory(new PropertyValueFactory<Plante,String>("couleur"));
            poids.setCellValueFactory(new PropertyValueFactory<Plante,Integer>("poids"));
             origine.setCellValueFactory(new PropertyValueFactory<Plante, String>("origine"));
           
       
 
             
              
              tabview.setItems(find);   
              nomLabel.setText("");
       imageLabel.setText("");
       prixLabel.setText("") ;
       quantiteLabel.setText("");
       descriptionLabel.setText("");
       CategorieLabel.setText("");
       typeLabel.setText("");
              DureeLabel.setText("");
       OrigineLabel.setText("");
       poidsLabel.setText("");
       saisonLabel.setText("");
       tailleLabel.setText("");
       CouleurLabel.setText("");


 
        setcelulfromtabView();
        } else {
            PlanteServices ms=new PlanteServices();
        ArrayList arraylist=(ArrayList) ms.listerPlante(StaticValue.store.getId());
        ms.afficherListePlante(StaticValue.store.getId());
        ObservableList obs=FXCollections.observableArrayList(arraylist);
                     
               
        img.setImage(new Image("http://localhost/pidev3info/img/"+c.getImage(),100,100,true,true));

        
        
               
       
        
       nom.setCellValueFactory(new PropertyValueFactory<Plante,String>("nom"));
        image.setCellValueFactory(new PropertyValueFactory<Plante,String>("image"));
         prix.setCellValueFactory(new PropertyValueFactory<Plante,Integer>("prix"));
          quantite.setCellValueFactory(new PropertyValueFactory<Plante,Integer>("quantite"));
           description.setCellValueFactory(new PropertyValueFactory<Plante,String>("description"));
              type.setCellValueFactory(new PropertyValueFactory<Plante,String>("type_categorie"));
             plancat.setCellValueFactory(new PropertyValueFactory<Plante,String>("categoriePlante"));
              tempsvie.setCellValueFactory(new PropertyValueFactory<Plante,String>("duree_vie"));
 
            saison.setCellValueFactory(new PropertyValueFactory<Plante,String>("saison"));
            taille.setCellValueFactory(new PropertyValueFactory<Plante,Integer>("taille"));
             couleur.setCellValueFactory(new PropertyValueFactory<Plante,String>("couleur"));
            poids.setCellValueFactory(new PropertyValueFactory<Plante,Integer>("poids"));
             origine.setCellValueFactory(new PropertyValueFactory<Plante, String>("origine"));
           
       
 
             
              
              tabview.setItems(obs);
              nomLabel.setText("");
       imageLabel.setText("");
       prixLabel.setText("") ;
       quantiteLabel.setText("");
       descriptionLabel.setText("");
       CategorieLabel.setText("");
       typeLabel.setText("");
              DureeLabel.setText("");
       OrigineLabel.setText("");
       poidsLabel.setText("");
       saisonLabel.setText("");
       tailleLabel.setText("");
       CouleurLabel.setText("");


 
        setcelulfromtabView();
    }

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
