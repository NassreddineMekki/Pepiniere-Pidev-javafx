/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepiniere.gui;
import com.jfoenix.controls.JFXListView;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import pepiniere.utils.StaticValue;
import pepniere.entitys.Client;
import pepniere.entitys.ClientReservation;
import pepniere.entitys.Offre_PlantSitting;
import pepniere.entitys.Offre_jardin;
import pepniere.entitys.Plante;
import pepniere.services.Offre_PlantSitting_Service;
import pepniere.services.Offre_jardin_Service;
import pepniere.services.Reservation_Service;
import pepniere.services.Service_PlantSitting_Service;

/**
 * FXML Controller class
 *
 * @author Mahmoud
 */
public class ProfileClientController implements Initializable {

    @FXML
    private Circle image;
    private JFXListView<String> offre;
    private AnchorPane listoffre;
    private JFXListView<String> plante;
    private JFXListView<String> reservation4;
    @FXML
    private TableView<ClientReservation> reservation3;
    @FXML
    private TableColumn<ClientReservation, String> nom;
    @FXML
    private TableColumn<?, ?> Telephone;
    @FXML
    private TableColumn<?, ?> adress;
    @FXML
    private Button AccepterReservation;
    @FXML
    private TableColumn<?, ?> status;
    @FXML
    private TableView<?> reservation31;
    @FXML
    private TableColumn<?, ?> nom1;
    @FXML
    private TableColumn<?, ?> Telephone1;
    @FXML
    private TableColumn<?, ?> adress1;
    @FXML
    private TableColumn<?, ?> status1;
    @FXML
    private TableView<Offre_PlantSitting> offre1;
    @FXML
    private TableColumn<?, ?> localisation;
    @FXML
    private TableColumn<?, ?> date_debut;
    @FXML
    private TableColumn<?, ?> date_fin;
    @FXML
    private TableColumn<?, ?> quantite;
    @FXML
    private TableColumn<?, ?> prix;
    @FXML
    private TableColumn<?, ?> description;
    @FXML
    private Button supprimeroffre;
    @FXML
    private Button modifieroffre;
    @FXML
    private TextArea description_modif;
    @FXML
    private TextField prix_modif;
    @FXML
    private ComboBox<String> quantite_max_modif;
      ObservableList<String>list=FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10");
    @FXML
    private DatePicker date_debut_modif;
    @FXML
    private TextField localisation_modif;
    @FXML
    private DatePicker date_fin__modif;
    @FXML
    private AnchorPane Modif_offre;
    @FXML
    private AnchorPane Main;
    @FXML
    private Button Modifier_Offre;
    @FXML
    private TableView<Offre_jardin> jardin;
    @FXML
    private TableColumn<?, ?> localisation1;
    @FXML
    private TableColumn<?, ?> date_debut1;
    @FXML
    private TableColumn<?, ?> date_fin1;
    @FXML
    private TableColumn<?, ?> quantite1;
    @FXML
    private TableColumn<?, ?> prix1;
    @FXML
    private TableColumn<?, ?> description1;
    @FXML
    private Button SupprimerJardin;
    @FXML
    private AnchorPane Modif_offre_Jardin;
    @FXML
    private TextArea description_modif1;
    @FXML
    private TextField prix_modif1;
    @FXML
    private DatePicker date_debut_modif1;
    @FXML
    private Button Modifier_Offre1;
    @FXML
    private TextField localisation_modif1;
    @FXML
    private DatePicker date_fin__modif1;
    @FXML
    private Button ModifierJArdin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         quantite_max_modif.setItems(list);
        //Offre Service D'un Client
        Offre_PlantSitting_Service ms2=new Offre_PlantSitting_Service();
        ArrayList arraylist=(ArrayList) ms2.listerOffreClient(StaticValue.client.getId());
        ObservableList obs=FXCollections.observableArrayList(arraylist);
        //Affichage Offre
       offre1.setItems(obs);
       localisation.setCellValueFactory(new PropertyValueFactory<>("localisation"));
       date_debut.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
       date_fin.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
       prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
       description.setCellValueFactory(new PropertyValueFactory<>("description"));
       quantite.setCellValueFactory(new PropertyValueFactory<>("quantite_max"));
        
       
       
       // offre Jardin d'un Client
        Offre_jardin_Service Service_jardin=new Offre_jardin_Service();
        ArrayList arraylist4=(ArrayList) Service_jardin.listerOffreJardinClient(StaticValue.client.getId());
        ObservableList obs4=FXCollections.observableArrayList(arraylist4);
        //Affichage Offre
       jardin.setItems(obs4);
       localisation1.setCellValueFactory(new PropertyValueFactory<>("localisation"));
       date_debut1.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
       date_fin1.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
       prix1.setCellValueFactory(new PropertyValueFactory<>("prix"));
       description1.setCellValueFactory(new PropertyValueFactory<>("description"));
       
       
       
       
       
        
         //listoffre.setVisible(false);
        Offre_PlantSitting_Service ms=new Offre_PlantSitting_Service();
        ArrayList<Offre_PlantSitting> offre1=(ArrayList<Offre_PlantSitting>) ms.listerOffres();
       //offre2.forEach(e->offre.getItems().add(e.getNom()+"  "+e.getQuantite()));
      /*  Reservation_Service res=new Reservation_Service();
        ArrayList<Service_PlantSitting> reservation1=(ArrayList<Service_PlantSitting>) res.AfficherReservationClient();
        reservation1.forEach(e->Reservation.getItems().add(e.getLocalisation()+" "+e.getDescription()+" "+e.getDate_debut()+" "+ e.getDate_fin()+" "+e.getPrix()));*/
//        setcelulfromtabView();
        setcelulfromtabView2();
        // TODO
        //AccepterReservation.setDisable(true);
        //Affichage les Reservation d'un Offre
        Reservation_Service rs=new Reservation_Service();
        Service_PlantSitting_Service Service1=new Service_PlantSitting_Service();
        ArrayList<Client> Reservation=(ArrayList<Client>) rs.ReservationParOffreClient();
        ArrayList<ClientReservation> ReservationConfirmer=(ArrayList<ClientReservation>) rs.ReservationParOffreClientQunatiteRes();
        ArrayList<Plante> Reservation2=(ArrayList<Plante>) rs.ReservationParOffre();
        ObservableList obs2=FXCollections.observableArrayList(ReservationConfirmer);
     reservation3.setItems(obs2);
       nom.setCellValueFactory(new PropertyValueFactory<>("name"));
       Telephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
       adress.setCellValueFactory(new PropertyValueFactory<>("adress"));
       status.setCellValueFactory(new PropertyValueFactory<>("status"));
        System.out.println(Service1.RecupererQuantiteLocal(StaticValue.client.getId()));
        setcelulfromtabView1();
       if(Service1.RecupererQuantiteLocal(StaticValue.client.getId())<=0)
                {
                    AccepterReservation.setDisable(true);
                }
//       Reservation.forEach(e->Reservation3.getItems().add(e.getName()+ "    "+ e.getTelephone()+"    "+e.getAdress()));
        reservation3.setOnMouseClicked(e1->
                {
                    
                    AccepterReservation.setOnMouseClicked(e3->{
                     
                        if(reservation3.getSelectionModel().getSelectedItem().getStatus().equals("Non Confirmer"))
                {  
                    if(reservation3.getSelectionModel().getSelectedItem().getQuantite()>Service1.RecupererQuantiteLocal(StaticValue.client.getId())){
                        System.out.println("Impossible Ajouter");
                    }
                        
                else{
                    rs.ModifierQuantiteLocal(reservation3.getSelectionModel().getSelectedItem().getQuantite(), Service1.RecupereOffreClient(StaticValue.client.getId()));
                    System.out.println(Service1.RecupereOffreClient(StaticValue.client.getId()));
                    rs.ConfirmerReservation(Service1.RecupereOffreClient(StaticValue.client.getId()), reservation3.getSelectionModel().getSelectedItem().getId_user());
                      System.out.println(status.getText());
                    }
                
                } else if(reservation3.getSelectionModel().getSelectedItem().getStatus().equals("Confirmer"))
                {
                    System.out.println("Ce Client est Deja Reserver");
                }
                    });
                   
                    Reservation2.forEach(e2->reservation4.getItems().add(e2.getNom()+ " " +e2.getTaille()));
                });
    }    
    private void handleButtonAction(MouseEvent event)
    {
      if(event.getSource()==modifieroffre)
                     {
                         System.out.println("2222");
                         Modif_offre.setVisible(true);
                         Main.setVisible(false);}
    }
  
    @FXML
    public void supprimerOffre(ActionEvent event) {
 
             Alert dialogC = new Alert(Alert.AlertType.CONFIRMATION);
dialogC.setTitle(" Confirmation ");
dialogC.setHeaderText(null);
dialogC.setContentText("Etes-vous sûr de vouloir supprimer Cette offre ");
             Optional<ButtonType> answer = dialogC.showAndWait();
if (answer.get() == ButtonType.OK) {
    
     
    
 
    
     int x = offre1.getSelectionModel().getSelectedItem().getId_offre();
     System.out.println(x);
     
        Offre_PlantSitting_Service offre=new Offre_PlantSitting_Service();
       offre.SupprimerOffrePlantSitting(x);
        
        ArrayList arraylist = (ArrayList) offre.listerOffreClient(StaticValue.client.getId());

        ObservableList obs = FXCollections.observableArrayList(arraylist);
        offre1.setItems(obs);


     
              
         
         }}
    public void modifierOffre(ActionEvent event) throws SQLException
{   
    
    
    java.sql.Date Date_debut=java.sql.Date.valueOf(date_debut_modif.getValue());
       java.sql.Date Date_fin=java.sql.Date.valueOf(date_fin__modif.getValue());
        Offre_PlantSitting_Service ms = new Offre_PlantSitting_Service();
        String combo=quantite_max_modif.getValue();
        int a2=Integer.parseInt(combo);
    //Livre b= new Livre ("s","b","b","b","Livre",2,"2",3);
   Offre_PlantSitting a = new Offre_PlantSitting(localisation_modif.getText(),a2,Date_debut,Date_fin,Float.parseFloat(prix_modif.getText()),description_modif.getText());
       int x = offre1.getSelectionModel().getSelectedItem().getId_offre();
Offre_PlantSitting_Service Service=new Offre_PlantSitting_Service();

   Service.ModifierOffrePlantSitting(a,x);
  

   
}
    
    
    public void setcelulfromtabView1()
         {offre1.setOnMouseClicked(e->
                 {
                    modifieroffre.setOnMouseClicked(e2->
                    {
                     {
                         Modif_offre.setVisible(true);
                         Main.setVisible(false);
                        LocalDate x=offre1.getSelectionModel().getSelectedItem().getDate_debut().toLocalDate();
                       LocalDate x1= offre1.getSelectionModel().getSelectedItem().getDate_fin().toLocalDate();
                       String y=String.valueOf(offre1.getSelectionModel().getSelectedItem().getQuantite_max());
                     localisation_modif.setText(offre1.getSelectionModel().getSelectedItem().getLocalisation()+"");
      date_debut_modif.setValue(x);

       date_fin__modif.setValue(x1);
       quantite_max_modif.setValue(y);
             prix_modif.setText(offre1.getSelectionModel().getSelectedItem().getPrix()+"");

       description_modif.setText(offre1.getSelectionModel().getSelectedItem().getDescription()+"") ;

        
                     }
                     
                 });
                     
        
        


       
                 } );
         
         }
    @FXML
     public void supprimerJardin(ActionEvent event) {
 
             Alert dialogC = new Alert(Alert.AlertType.CONFIRMATION);
dialogC.setTitle(" Confirmation ");
dialogC.setHeaderText(null);
dialogC.setContentText("Etes-vous sûr de vouloir supprimer Cette offre du jardin ");
             Optional<ButtonType> answer = dialogC.showAndWait();
if (answer.get() == ButtonType.OK) {
    
     
    
 
    
     int x = jardin.getSelectionModel().getSelectedItem().getId_offre_jardin();
     System.out.println(x);
     
        Offre_jardin_Service offre=new Offre_jardin_Service();
       offre.SupprimerOffreJardin(x);
        
        ArrayList arraylist = (ArrayList) offre.listerOffreJardinClient(StaticValue.client.getId());

        ObservableList obs = FXCollections.observableArrayList(arraylist);
        jardin.setItems(obs);


     
              
         
         }}
    @FXML
    public void modifierJardin(ActionEvent event) throws SQLException
{   
    
    
    java.sql.Date Date_debut=java.sql.Date.valueOf(date_debut_modif1.getValue());
       java.sql.Date Date_fin=java.sql.Date.valueOf(date_fin__modif1.getValue());
        Offre_PlantSitting_Service ms = new Offre_PlantSitting_Service();
      
    //Livre b= new Livre ("s","b","b","b","Livre",2,"2",3);
   Offre_jardin a = new Offre_jardin(Date_debut,Date_fin,localisation_modif1.getText(),Float.parseFloat(prix_modif1.getText()),description_modif1.getText());
       int x = jardin.getSelectionModel().getSelectedItem().getId_offre_jardin();
Offre_jardin_Service Service=new Offre_jardin_Service();

   Service.ModifierOffreJardin(a,x);
  

   
}
    
    
    public void setcelulfromtabView2()
         {jardin.setOnMouseClicked(e->
                 {
                    ModifierJArdin.setOnMouseClicked(e2->
                    {
                     {
                         Modif_offre_Jardin.setVisible(true);
                         Modif_offre.setVisible(false);
                         Main.setVisible(false);
                        LocalDate x=jardin.getSelectionModel().getSelectedItem().getDate_debut().toLocalDate();
                       LocalDate x1= jardin.getSelectionModel().getSelectedItem().getDate_fin().toLocalDate();
                     localisation_modif1.setText(jardin.getSelectionModel().getSelectedItem().getLocalisation()+"");
      date_debut_modif1.setValue(x);

       date_fin__modif1.setValue(x1);
             prix_modif1.setText(jardin.getSelectionModel().getSelectedItem().getPrix()+"");

       description_modif1.setText(jardin.getSelectionModel().getSelectedItem().getDescription()+"") ;

        
                     }
                     
                 });
                     
        
        


       
                 } );
         
         }

    @FXML
    private void buckAction(ActionEvent event) {
                         Modif_offre.setVisible(false);
                         Main.setVisible(true);
                         Modif_offre_Jardin.setVisible(false);
        
    }

    @FXML
    private void bbuck(ActionEvent event) throws IOException {
        Parent parentInscit = FXMLLoader.load(getClass().getResource("Offre_PlantSitting.fxml"));
        Scene sceneInscit = new Scene(parentInscit);
        Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
        stageInscit .hide();
        stageInscit .setScene(sceneInscit );
        stageInscit .show(); 
    }
}