/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepiniere.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import pepniere.entitys.Event;

/**
 * FXML Controller class
 *
 * @author FERID
 */
public class FXMLAdminEventController implements Initializable {

    @FXML
    private TableView<Event> tabb;
    @FXML
    private TableColumn<Event, String> col_nom;
    @FXML
    private TableColumn<Event, Date> col_date_deb;
    @FXML
    private TableColumn<Event, String> col_description;
    @FXML
    private TableColumn<Event, String> col_adresse;
    @FXML
    private TableColumn<Event, Integer> frais_part;
    @FXML
    private TableColumn<Event, Integer> Nbre_participant;
    @FXML
    private TableColumn<Event, Integer> id_event;
    @FXML
    private Circle image;
    @FXML
    private Label name;
    @FXML
    private Label mail;

   
    /**
     * Initializes the controller class.
     * @throws java.io.IOException
     */
    @FXML
       public void deleteEvent() throws IOException
    {
           pepniere.services.EventService SE = new  pepniere.services.EventService();

       // System.out.println(table.getSelectionModel().getSelectedItem());
       if (tabb.getSelectionModel().getSelectedItem() != null) 
       {
        Event selectedUser = tabb.getSelectionModel().getSelectedItem();
        SE.delete(selectedUser);
 
        tabb.getItems().setAll(SE.listeEvents());
       }
     
       
    }
    @FXML
       public void retourAdmin(ActionEvent event)  {
    try {
        
           Parent   url =  FXMLLoader.load( getClass().getResource("FXMLAcceuil_Boutique.fxml"))  ;  
         
          Scene scene = new Scene(url);
             Stage stage =  (Stage) ((Node) event.getSource()).getScene().getWindow();
             stage.hide();
              stage.setScene(scene);
              stage.show();
            
             
         
           } catch(Exception e) 
           {e.printStackTrace();}
    
      }
     //  public 
       @Override
    public void initialize(URL url, ResourceBundle rb) {
              // TODO
 id_event.setVisible(false);
      col_nom.setCellValueFactory(new PropertyValueFactory<>("nom_event"));
       col_date_deb.setCellValueFactory(new PropertyValueFactory<>("date_deb"));
         col_description.setCellValueFactory(new PropertyValueFactory<>("description")); 
       col_adresse.setCellValueFactory(new PropertyValueFactory<>("adresse_event"));
        frais_part.setCellValueFactory(new PropertyValueFactory<>("frais_particpation"));
         Nbre_participant.setCellValueFactory(new PropertyValueFactory<>("Nbre_participant"));
          id_event.setCellValueFactory(new PropertyValueFactory<>("id_event"));
           pepniere.services.EventService SE = new  pepniere.services.EventService();
           ObservableList<Event> oblist;
           oblist=SE.listeEvents();
           
         tabb.setItems(oblist);
                

    }    
    }    
    

