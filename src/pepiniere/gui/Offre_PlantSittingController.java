     /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepiniere.gui;

import java.util.Date;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;


import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import pepiniere.utils.StaticValue;
//import org.controlsfx.control.Notifications;
import pepniere.entitys.Offre_PlantSitting;
import pepniere.entitys.Offre_jardin;
import pepniere.entitys.Plante;
import pepniere.entitys.Reservation;
import pepniere.entitys.Service_PlantSitting;
import pepniere.services.Offre_PlantSitting_Service;
import pepniere.services.Offre_jardin_Service;
import pepniere.services.Reservation_Service;
import pepniere.services.Service_PlantSitting_Service;

/**
 * FXML Controller class
 *
 * @author Mahmoud
 */
public class Offre_PlantSittingController implements Initializable {

    @FXML
    private ImageView gestionoffre;
    @FXML
    private ImageView gestionservice;
    @FXML
    private ImageView gestionjardin;
    @FXML
    private AnchorPane Interface_Offre;
    @FXML
    private AnchorPane Menu;

    @FXML
    private AnchorPane Interface_Service;
    @FXML
    private AnchorPane Interface_Jardin;
    @FXML
    private TableColumn<?, ?> localisation;
    @FXML
    private TableColumn<?, ?> date_debut;
    @FXML
    private TableColumn<?, ?> date_fins;
    @FXML
    private TableColumn<?, ?> prix;
    @FXML
    private TableColumn<?, ?> description;
    @FXML
    private TableColumn<?, ?> quantite_max;
    @FXML
    private TableView<Offre_PlantSitting> taboffre;
    @FXML
    private Button AjouterOffre;
    @FXML
    private AnchorPane Interface_Ajout_Offre;
    @FXML
    private TextField localisation_ajout;
    @FXML
    private TextArea description_ajout;
    @FXML
    private TextField prix_ajout;
    @FXML
    private DatePicker date_debut_ajout;
    @FXML
    private DatePicker date_fin_ajout;
    @FXML
    private ComboBox<String> quantite_max_ajout;
    ObservableList<String>list=FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10");
    private TextField localisation_modif;
    private TextArea description_modif;
    private TextField prix_modif;
    private DatePicker date_debut_modif;
    private ComboBox<String> quantite_max_modif;
    @FXML
    private AnchorPane Interface_Ajout_Service;
    @FXML
    private TextField localisation_ajout1;
    @FXML
    private TextArea description_ajout1;
    @FXML
    private TextField prix_ajout1;
    @FXML
    private DatePicker date_debut_ajout1;
    @FXML
    private DatePicker date_fin_ajout1;
    @FXML
    private Button AjouterService;
    @FXML
    private VBox vb1;
    @FXML
    private ScrollPane scrollPane;
     final CheckBox[] cbs = new CheckBox[1000];
      final TextField[] cbs1 = new TextField[1000];
    @FXML
    private TableView<Service_PlantSitting> taboffre2;
    @FXML
    private TableColumn<?, ?> localisation2;
    @FXML
    private TableColumn<?, ?> date_debut2;
    @FXML
    private TableColumn<?, ?> date_fins2;
    @FXML
    private TableColumn<?, ?> prix2;
    @FXML
    private TableColumn<?, ?> description2;
    @FXML
    private TableColumn<?, ?> quantite_max2;
    @FXML
    private TableView<Offre_jardin> taboffre3;
    @FXML
    private TableColumn<?, ?> localisation3;
    @FXML
    private TableColumn<?, ?> date_debut3;
    @FXML
    private TableColumn<?, ?> date_fins3;
    @FXML
    private TableColumn<?, ?> prix3;
    @FXML
    private TableColumn<?, ?> description3;
    @FXML
    private TextField localisation_ajout2;
    @FXML
    private TextArea description_ajout2;
    @FXML
    private TextField prix_ajout2;
    @FXML
    private DatePicker date_debut_ajout2;
    @FXML
    private DatePicker date_fin_ajout2;
    @FXML
    private AnchorPane Interface_Ajout_Jardin;
    @FXML
    private Button AjouterJardin;
    @FXML
    private AnchorPane Reservation;
    @FXML
    private ScrollPane scrollPane1;
    @FXML
    private VBox vb11;
    @FXML
    private TextField quantite_local;
    @FXML
    private Button Ajouter_Reservation;
    @FXML
    private Circle image;
    @FXML
    private JFXTextField recherche;
    @FXML
    private ImageView panier;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         if(StaticValue.listProduct==null){
            Image imag= new Image("/pepiniere/gui/images/shopping-cart-empty-side-view.png");
            panier.setImage(imag);
           }else{
                if(StaticValue.listProduct!=null){
             Image imag= new Image("/pepiniere/gui/images/318-39938.jpg");
             panier.setImage(imag);}
           }
         
      Image img = new Image("http://localhost/pidev4info/img/"+StaticValue.client.getImgUrl(),150,150,true,true);
      image.setFill(new ImagePattern(img));
        Offre_PlantSitting_Service ms=new Offre_PlantSitting_Service();
        ArrayList arraylist=(ArrayList) ms.listerOffres();
        ObservableList obs=FXCollections.observableArrayList(arraylist);

       localisation_ajout.setText("");
       date_debut_ajout.getEditor().setText("");
       date_fin_ajout.getEditor().setText("") ;
       prix_ajout.setText("");
       description.setText("");
       quantite_max.setText("");

        //Affichage Offre
       taboffre.setItems(obs);
       localisation.setCellValueFactory(new PropertyValueFactory<>("localisation"));
       date_debut.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
       date_fins.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
       prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
       description.setCellValueFactory(new PropertyValueFactory<>("description"));
       quantite_max.setCellValueFactory(new PropertyValueFactory<>("quantite_max"));
//       Reservation.setCellValueFactory(new PropertyValueFactory<>("Reservation"));
       quantite_max_ajout.setItems(list);
      // quantite_max_ajout1.setItems(list);
//       quantite_max_modif.setItems(list);
       setcelulfromtabViewOffre();
       //Affichage Service
        Service_PlantSitting_Service ms1=new Service_PlantSitting_Service();
        ArrayList arraylist1=(ArrayList) ms1.listerServices();
        ObservableList obs2=FXCollections.observableArrayList(arraylist1);
        taboffre2.setItems(obs2);
       localisation2.setCellValueFactory(new PropertyValueFactory<>("localisation"));
       date_debut2.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
       date_fins2.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
       prix2.setCellValueFactory(new PropertyValueFactory<>("prix"));
       description2.setCellValueFactory(new PropertyValueFactory<>("description"));
       quantite_max2.setCellValueFactory(new PropertyValueFactory<>("quantite_max"));
       //setcelulfromtabViewOffre();
       //Affichage Jardin
       Offre_jardin_Service ms2=new Offre_jardin_Service();
        ArrayList arraylist2=(ArrayList) ms2.listerOffresJardin();
        ObservableList obs3=FXCollections.observableArrayList(arraylist2);
        taboffre3.setItems(obs3);
       localisation3.setCellValueFactory(new PropertyValueFactory<>("localisation"));
       date_debut3.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
       date_fins3.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
       prix3.setCellValueFactory(new PropertyValueFactory<>("prix"));
       description3.setCellValueFactory(new PropertyValueFactory<>("description"));

       //setcelulfromtabViewOffre();
       
       FilteredList<Offre_jardin> filterData = new FilteredList<Offre_jardin>(obs3, e -> true);
        recherche.setOnKeyReleased(e -> {
            recherche.textProperty().addListener((observableValue, oldValue, newValue) -> {
             
                filterData.setPredicate((Predicate<? super Offre_jardin>) Offre_jardin -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String lowerCaseFilter = newValue.toLowerCase();
                    if (Offre_jardin.getDescription().contains(newValue)) {
                        return true;
                    } else if (Offre_jardin.getDescription().toLowerCase().contains(newValue)) {
                        return true;
                    } else if (Offre_jardin.getLocalisation().contains(newValue)) {
                        return true;
                    } else if (Float.toString(Offre_jardin.getPrix()).contains(newValue)) {
                        return true;
                    }else if (Offre_jardin.getDescription().toLowerCase().contains(newValue)) {
                        return true;
                    }
                    
                    return false;
                });
            });
            SortedList<Offre_jardin> sortedData = new SortedList<>(filterData);

            sortedData.comparatorProperty().bind(taboffre3.comparatorProperty());
            taboffre3.setItems(sortedData);

        });
       
        // TODO
    } 
    
    ////////////////abdou ////////////////////////////////////
    
    public static void showAlert(Alert.AlertType type, String title, String header, String text) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(text);
        alert.showAndWait();

    }
    
    
    
    private boolean controleDeSaisiOffre() {
        java.sql.Date Date_debut=java.sql.Date.valueOf(date_debut_ajout.getValue());
        java.sql.Date Date_fin=java.sql.Date.valueOf(date_fin_ajout.getValue());
        java.util.Date uDate = new java.util.Date();
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        if (localisation_ajout.getText().isEmpty() || prix_ajout.getText().isEmpty() || description_ajout.getText().isEmpty()
                ) {
            showAlert(Alert.AlertType.ERROR, "Données erronés", "Verifier les données", "Veuillez bien remplir tous les champs !");
            return false;
        } else {

            if (!Pattern.matches("[0-9]*", prix_ajout.getText())) {
                showAlert(Alert.AlertType.ERROR, "Données erronés", "Verifier les données", "Vérifiez la reference ! ");
                prix_ajout.requestFocus();
                prix_ajout.selectEnd();
                return false;
            }
            
        //SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        
             if (Date_fin.before(Date_debut)){
                 showAlert(Alert.AlertType.ERROR, "Données erronés", "Verifier les données", "Vérifiez la date debut et fin ! ");
 
                return false;
            
        }
             if (Date_debut.before(uDate)){
                    showAlert(Alert.AlertType.ERROR, "Données erronés", "Verifier les données", "Vérifiez la date debut  ! ");
                    return false;
            
        }
             if (Date_fin.before(uDate)){
                 showAlert(Alert.AlertType.ERROR, "Données erronés", "Verifier les données", "Vérifiez la date fin  ! ");
                 return false;
            
        }

        }
        return true;
    }
    private boolean controleDeSaisiService() {

        if (localisation_ajout1.getText().isEmpty() || prix_ajout1.getText().isEmpty() || description_ajout1.getText().isEmpty()
                ) {
            showAlert(Alert.AlertType.ERROR, "Données erronés", "Verifier les données", "Veuillez bien remplir tous les champs !");
            return false;
        } else {

            if (!Pattern.matches("[0-9]*", prix_ajout1.getText())) {
                showAlert(Alert.AlertType.ERROR, "Données erronés", "Verifier les données", "Vérifiez la reference ! ");
                prix_ajout1.requestFocus();
                prix_ajout1.selectEnd();
                return false;
            }

        }
        return true;
    }
    private boolean controleDeSaisiJardin() {

        if (localisation_ajout2.getText().isEmpty() || prix_ajout2.getText().isEmpty() || description_ajout2.getText().isEmpty()
                ) {
            showAlert(Alert.AlertType.ERROR, "Données erronés", "Verifier les données", "Veuillez bien remplir tous les champs !");
            return false;
        } else {

            if (!Pattern.matches("[0-9]*", prix_ajout2.getText())) {
                showAlert(Alert.AlertType.ERROR, "Données erronés", "Verifier les données", "Vérifiez la reference ! ");
                prix_ajout2.requestFocus();
                prix_ajout2.selectEnd();
                return false;
            }

        }
        return true;
    }



    
    
    
    
    
    
    ///////abdou *///////////////////////
    
    @FXML
    private void handleButtonAction(MouseEvent event)
    {
       if(event.getTarget()==gestionoffre) {
           Interface_Offre.setVisible(true);
           Interface_Service.setVisible(false);
           Interface_Jardin.setVisible(false);
           Interface_Ajout_Offre.setVisible(false);
           Interface_Ajout_Service.setVisible(false);
             Interface_Ajout_Jardin.setVisible(false);
             Reservation.setVisible(false);

           
       }
      else if(event.getTarget()==gestionservice) {
           Interface_Offre.setVisible(false);
           Interface_Service.setVisible(true);
           Interface_Jardin.setVisible(false);
           Interface_Ajout_Offre.setVisible(false);
           Interface_Ajout_Service.setVisible(false);
Interface_Ajout_Jardin.setVisible(false);
Reservation.setVisible(false);
       }
       else if(event.getTarget()==gestionjardin) {
           Interface_Offre.setVisible(false);
           Interface_Service.setVisible(false);
           Interface_Jardin.setVisible(true);
           Interface_Ajout_Offre.setVisible(false);
           Interface_Ajout_Service.setVisible(false);
            Interface_Ajout_Jardin.setVisible(false);
            Reservation.setVisible(false);
       }
       else if(event.getSource()==AjouterOffre)
           {
               Interface_Ajout_Offre.setVisible(true);
               Interface_Service.setVisible(false);
               Interface_Jardin.setVisible(false);
               Interface_Offre.setVisible(false);
               Interface_Ajout_Service.setVisible(false);
             Interface_Ajout_Jardin.setVisible(false);
             Reservation.setVisible(false);
           }
       else if(event.getSource()==AjouterJardin)
           {
               Interface_Ajout_Offre.setVisible(false);
               Interface_Service.setVisible(false);
               Interface_Jardin.setVisible(false);
               Interface_Offre.setVisible(false);
               Interface_Ajout_Service.setVisible(false);
               Interface_Ajout_Jardin.setVisible(true);
               Reservation.setVisible(false);
           }
        else if(event.getSource()==AjouterService)
           {
               Interface_Ajout_Offre.setVisible(false);
               Interface_Service.setVisible(false);
               Interface_Jardin.setVisible(false);
               Interface_Offre.setVisible(false);
               Interface_Ajout_Service.setVisible(true);
               Interface_Ajout_Offre.setVisible(false);
               Reservation.setVisible(false);
               Service_PlantSitting_Service ms=new Service_PlantSitting_Service();
               ms.AfficherListePlantes();
               
              
               List<Plante> arrayList5= ms.AfficherListePlantes();
                   
                      if(vb1.getChildren().isEmpty()){
                           for(Plante m : arrayList5){
                          System.out.println(m.getId_plante());
                 int i = 0;
                 cbs[m.getId_plante()] = new CheckBox(m.getNom());
                    CheckBox c=cbs[m.getId_plante()];
                   cbs1[m.getId_plante()]=new TextField();
                   TextField a=cbs1[m.getId_plante()];
                           a.setPromptText("Quantite");
                       
                // CheckBox cb = new CheckBox(m.getNom());
                vb1.getChildren().add(c); 
                vb1.getChildren().add(a);
                      }}
                           
              
             
               // cbs[i].setSelected(true);
               //cbs[1].setSelected(true);
                

           }
       
       }
    @FXML
    private void AjouterOffre_PlantSitting(ActionEvent event) {
            if (controleDeSaisiOffre()) {

                    if (localisation_ajout.getText().isEmpty()) {
                        localisation_ajout.setText("");
                    }
                    if (prix_ajout.getText().isEmpty()) {
                        prix_ajout.setText("");                      
                    }
                    if (description_ajout.getText().isEmpty()) {
                        description_ajout.setText("");
                    }
                    if(date_debut_ajout.getEditor().getText().isEmpty())
                    {
                        date_debut_ajout.setValue(LocalDate.MAX);
                    }
                     if(date_fin_ajout.getEditor().getText().isEmpty())
                    {
                         date_fin_ajout.getEditor().clear();
                    }

                }
            else{
        date_debut_ajout.getValue();
       java.sql.Date Date_debut=java.sql.Date.valueOf(date_debut_ajout.getValue());
       java.sql.Date Date_fin=java.sql.Date.valueOf(date_fin_ajout.getValue());
        Offre_PlantSitting_Service ms = new Offre_PlantSitting_Service();
        String combo=quantite_max_ajout.getValue();
        int a=Integer.parseInt(combo);
        float jml = Float.parseFloat(prix_ajout.getText());
       
        //if(verifier()){
             /*   if(localisation_ajout.getText().equals(""))
        {
            System.out.println("CA MARCHE PAS");
        }*/
            
            //    if(verifierOffre()&&verifierPrixOffre()&&verifierPrixDate()){
        Offre_PlantSitting m= new Offre_PlantSitting(localisation_ajout.getText(),a,Date_debut,Date_fin,jml,description_ajout.getText());
        ms.ajouterOffrePlantSitting(m,StaticValue.client.getId());
           //SMS ss=new SMS();
        //   ss.SendSMS("light0", "0591487Mcv", "heello", "21655621629", "https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");
//        Notifications.create().darkStyle().title("Pepiniere").text("Ajout avec Succes").position(Pos.BOTTOM_RIGHT).showInformation();
              //  }
       // }
       localisation_ajout.clear();
        prix_ajout.clear();
        description_ajout.clear();
        date_debut_ajout.getEditor().clear();
        date_fin_ajout.getEditor().clear();
        quantite_max_ajout.getItems().clear();
            }
    }
  public void modifier(ActionEvent event) 
{
    //Livre b= new Livre ("s","b","b","b","Livre",2,"2",3);
    java.sql.Date Date_debut_modif=java.sql.Date.valueOf(date_debut_modif.getValue());
        java.sql.Date Date_fin_modif=java.sql.Date.valueOf(date_debut_modif.getValue());
         String combo=quantite_max_modif.getValue();
         int a=Integer.parseInt(combo);
float jml = Float.parseFloat(prix_modif.getText());
   Offre_PlantSitting m = new Offre_PlantSitting(localisation_modif.getText(),a,Date_debut_modif,Date_fin_modif,jml,description_modif.getText());
  Offre_PlantSitting_Service ms = new Offre_PlantSitting_Service();
  ms.ModifierOffrePlantSitting(m, 25);

     ArrayList arraylist = (ArrayList) ms.listerOffres();

        ObservableList obs = FXCollections.observableArrayList(arraylist);
        taboffre.setItems(obs);
    
}
    public void setcelulfromtabViewOffre()
         {taboffre2.setOnMouseClicked(e->
                 {
                                   System.out.println(taboffre2.getSelectionModel().getSelectedItem().getId_offre());

                    Alert dialogC = new Alert(Alert.AlertType.CONFIRMATION);
dialogC.setTitle(" Confirmation ");
dialogC.setHeaderText(null);
dialogC.setContentText("Voulez-vous vraiment reserver cette offre? ");
             Optional<ButtonType> answer = dialogC.showAndWait();
if (answer.get() == ButtonType.OK) {
   
      System.out.println(taboffre2.getSelectionModel().getSelectedItem().getId_offre());
      Interface_Ajout_Offre.setVisible(false);
               Interface_Service.setVisible(false);
               Interface_Jardin.setVisible(false);
               Interface_Offre.setVisible(false);
               Interface_Ajout_Service.setVisible(false);
               Interface_Ajout_Offre.setVisible(false);
               Reservation.setVisible(true);
                Service_PlantSitting_Service ms=new Service_PlantSitting_Service();
               ms.AfficherListePlantes();
               
              
               List<Plante> arrayList5= ms.AfficherListePlantes();
                   
                      if(vb11.getChildren().isEmpty()){
                           for(Plante m : arrayList5){
                          System.out.println(m.getId_plante());
                 int i = 0;
                 cbs[m.getId_plante()] = new CheckBox(m.getNom());
                    CheckBox c=cbs[m.getId_plante()];
                   cbs1[m.getId_plante()]=new TextField();
                   TextField a=cbs1[m.getId_plante()];
                           a.setPromptText("Quantite");
                       
                // CheckBox cb = new CheckBox(m.getNom());
                vb11.getChildren().add(c); 
                vb11.getChildren().add(a);
                      }}
                                       int x=taboffre2.getSelectionModel().getSelectedItem().getQuantite();
                             String a= String.valueOf(x);
                             System.out.println(a);
                      quantite_local.setText(a);
                      Ajouter_Reservation.setOnAction(e1->
                 { Reservation_Service ms3=new Reservation_Service();
                 
                  List<Plante> arrayList6= ms3.AfficherListePlantes();
int quan = 0;
        for (Plante b: arrayList5)
                {
                                     
                            if(cbs[b.getId_plante()].isSelected()==true)
                            {
                                ms3.ajoutPlanteReservation(b.getId_plante(),ms3.RecupererDernier());
                                         
                            String nombre = cbs1[b.getId_plante()].getText();
                             quan+=Integer.parseInt(nombre);
                           //quan+=quan;
                            
           
                  
                            }
                            
                }
      //quantite_local.
        System.out.println(quan);
      Reservation o=new Reservation(taboffre2.getSelectionModel().getSelectedItem().getId_offre(), quan);
                 ms3.ajoutReservation(o,StaticValue.client.getId());
                   
                 });
         
         }
         
                 });
             
         
         
         }
@FXML
    private void AjouterService_PlantSitting(ActionEvent event) {
         if (controleDeSaisiService()) {

                    if (localisation_ajout1.getText().isEmpty()) {
                        localisation_ajout1.setText("");
                    }
                    if (prix_ajout1.getText().isEmpty()) {
                        prix_ajout1.setText("");                      
                    }
                    if (description_ajout1.getText().isEmpty()) {
                        description_ajout1.setText("");
                    }

                }
         
          Service_PlantSitting_Service ms = new Service_PlantSitting_Service();
        List<Plante> arrayList5= ms.AfficherListePlantes();
         int x = 0;
         int c=0;
         int quan=0;
        for (Plante b: arrayList5)
                {
                                     
                            if(cbs[b.getId_plante()].isSelected()==true)
                            {
                                ms.ajoutOffrePlante(ms.RecupererDernier(),b.getId_plante());
                               // System.out.println(ms.RecupererDernier());          
                            String nombre = cbs1[b.getId_plante()].getText();
                           quan+=Integer.parseInt(nombre);
          // x =Integer.parseInt(nombre);
          //c+=x;
           
                  
                            }
                }
          System.out.println(quan);
          
        
       date_debut_ajout1.getValue();
       java.sql.Date Date_debut=java.sql.Date.valueOf(date_debut_ajout1.getValue());
       java.sql.Date Date_fin=java.sql.Date.valueOf(date_fin_ajout1.getValue());
       /* String combo=quantite_max_ajout1.getValue();
        int a=Integer.parseInt(combo);*/
        float jml = Float.parseFloat(prix_ajout1.getText());
 String x1 = description_ajout1.getText();
        
           Service_PlantSitting m= new Service_PlantSitting(quan,localisation_ajout1.getText(),Date_debut,Date_fin,jml,description_ajout1.getText());
        ms.ajoutServicePlantSitting(m);

         
        
       
        localisation_ajout1.clear();
        //prix_ajout1.clear();
        description_ajout1.clear();
        date_debut_ajout1.getEditor().clear();
        date_fin_ajout1.getEditor().clear();
     
        
        
    }
 @FXML
    private void AjouterOffre_Jardin(ActionEvent event) {
         if (controleDeSaisiJardin()) {

                    if (localisation_ajout2.getText().isEmpty()) {
                        localisation_ajout2.setText("");
                    }
                    if (prix_ajout2.getText().isEmpty()) {
                        prix_ajout2.setText("");                      
                    }
                    if (description_ajout2.getText().isEmpty()) {
                        description_ajout2.setText("");
                    }

                }
       
               date_debut_ajout.getValue();
       java.sql.Date Date_debut=java.sql.Date.valueOf(date_debut_ajout2.getValue());
       java.sql.Date Date_fin=java.sql.Date.valueOf(date_fin_ajout2.getValue());
        Offre_jardin_Service ms = new Offre_jardin_Service();
        float jml = Float.parseFloat(prix_ajout2.getText());
        Offre_jardin m= new Offre_jardin(Date_debut,Date_fin,localisation_ajout2.getText(),jml,description_ajout.getText());
        ms.ajouterOffreJardin(m);
         
        localisation_ajout2.clear();
        prix_ajout2.clear();
        description_ajout2.clear();
        date_debut_ajout2.getEditor().clear();
        date_fin_ajout2.getEditor().clear();
         
     
    }
    public boolean verifierOffre ()
    {if ((localisation_ajout.getText().length()==0)|date_debut_ajout.getEditor().getText().isEmpty()|date_fin_ajout.getEditor().getText().isEmpty()
            |prix_ajout.getText().isEmpty()|description_ajout.getText().isEmpty()
            )
        
    {Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Valider Les Champs");
    alert.setHeaderText(null);
    alert.setContentText("Veuillez Valider Les Champs ");
    alert.showAndWait();
    return false;
    }
   
   return true;
    }
     public boolean verifierPrixOffre ()
    {
         float jml = Float.parseFloat(prix_ajout.getText());
        if (jml<0)
        
    {
        Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Valider Les Champs");
    alert.setHeaderText(null);
    alert.setContentText("Verifier Le prix ");
    alert.showAndWait();
    return false;
    }
   
   return true;
    }
      public boolean verifierPrixDate ()
    {
        java.sql.Date Date_debut=java.sql.Date.valueOf(date_debut_ajout.getValue());
        java.sql.Date Date_fin=java.sql.Date.valueOf(date_fin_ajout.getValue());
        java.util.Date uDate = new java.util.Date();
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        //SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        
        if (Date_fin.before(Date_debut)&&Date_debut.before(uDate)&&Date_fin.before(uDate))
        
    {
        
        Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Valider Les Champs");
    alert.setHeaderText(null);
    alert.setContentText("Verifier La Date ");
    alert.showAndWait();
    return false;
    }
   
   return true;
    }

    @FXML
    private void buck(ActionEvent event) throws IOException {
        Parent parentInscit = FXMLLoader.load(getClass().getResource("FXMLAcceuil_Client.fxml"));
        
              Scene sceneInscit = new Scene(parentInscit);
              Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
       
             stageInscit .hide();
        
             stageInscit .setScene(sceneInscit );
             stageInscit .show();
    }

   

    @FXML
    private void panierAction(MouseEvent event) throws IOException {
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
    private void prfilAction(ActionEvent event) throws IOException {
        Parent parentInscit = FXMLLoader.load(getClass().getResource("ProfileClient.fxml"));
        Scene sceneInscit = new Scene(parentInscit);
        Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
        stageInscit .hide();
        stageInscit .setScene(sceneInscit );
        stageInscit .show(); 
    }
}
