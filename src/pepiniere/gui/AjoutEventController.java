/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepiniere.gui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import pepiniere.utils.StaticValue;
import pepiniere.utils.Upload;
import pepniere.entitys.Event;


/**
 * FXML Controller class
 *
 * @author FERID
 */
public class AjoutEventController implements Initializable {

    @FXML
    private Circle image;
    @FXML
    private Label name;
    @FXML
    private Label mail;
    @FXML
    private TextField Nom_event;
    @FXML
    private TextField adresse_event;
    @FXML
    private TextField nbre_p;
    @FXML
    private DatePicker date_deb;
    @FXML
    private TextArea Description;
    @FXML
    private TextField txtimg;
       private File file;
   private Image image1;
    String pic;
    @FXML
    private TextField frais_p;
    /**
     * Initializes the controller class.
     */
    
    
         public boolean verifier (String text, String aff)
    {if (text.isEmpty())
    {JOptionPane.showMessageDialog(null, aff);
    
    return false;
    }
   
   return true;
    }
    
    
    
    
    
    @FXML
    void ajouterEvent(ActionEvent event) 
    {
      boolean verifnom= verifier(Nom_event.getText(),"Veuillez saisir le nom");
      boolean verifdes= verifier(Description.getText(),"veuillez remplir champ description");
      
        
        java.sql.Date dateDeb;
     java.sql.Date  date1 ;
     
         dateDeb = java.sql.Date.valueOf(date_deb.getValue());
  /* if((Integer.valueOf(frais_p.getText())instanceof Integer))
    {
    JOptionPane.showMessageDialog(null,"number");
         
tl;dr
LocalDate today = LocalDate.now( ZoneId.of( "America/Montreal" ) )
    }   
     */ 
 /* DateTimeFormatter formatter = DateTimeFormat.forPattern( "dd-MM-yyyy" );
LocalDate localDate1 = formatter.parseLocalDate(dateDeb );
LocalDate today = LocalDate.now( ZoneId.of( "Africa/Tunis" ) );
  if(today.isBefore(dateDeb))
      
     {
     
     
     }

          if( date1.getTime().compareTo(date_deb.getValue()))
          {
          
          };
      
      */
      if(verifnom && verifdes &&(Integer.valueOf(frais_p.getText())instanceof Integer)&&(Integer.valueOf(nbre_p.getText())instanceof Integer))
     {
        
       
           dateDeb = java.sql.Date.valueOf(date_deb.getValue());
        
          //dateDeb. 
        Event e;
      pepniere.services.EventService se = new  pepniere.services.EventService();
        int c=StaticValue.store.getId();
        e= new Event(dateDeb, Description.getText(), adresse_event.getText(),
                Nom_event.getText(), Integer.parseInt(frais_p.getText()), Integer.parseInt(nbre_p.getText()),txtimg.getText(),StaticValue.store.getId());//au lieu de StaticValue.store.getIdUser()
         System.err.println(StaticValue.store.getId());
        
        
    se.ajouterEvents(e);
     }else
      {
     JOptionPane.showMessageDialog(null,"le frais et nbre de participation doit etre nombre");
  
    }
     
      
    
    
   
  
     //  @FXML
    /*void a(ActionEvent event) 
    {int k=0;
    do{
      if(Nom_event.getText().isEmpty())
     {
         JOptionPane.showMessageDialog(null, "add Nom event");
             }   
     else if(Description.equals(""))
     {
         JOptionPane.showMessageDialog(null, "add Descriptin");
         
     
   
    } 
    }
    
    while(k=1)
    */
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
  txtimg.setVisible(false);
    }
        // TODO
    

    @FXML
  private void addImg(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
            file= fileChooser.showOpenDialog(null);
             FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

            
            pic=(file.toURI().toString());
         //  pic=new Upload().upload(file,"uimg");
           pic=new Upload().upload(file,"");
            System.out.println(pic);
   //   image= new Image("http://localhost/uimg/"+pic);
            txtimg.setText(pic);
           image1= new Image("http://localhost/pidev4info/img/"+pic);
  }

    @FXML
    private void RETOUR(ActionEvent event) {
          try {
        
           Parent   url =  FXMLLoader.load( getClass().getResource("FXMLinterfaceBOUTIQUE.fxml"))  ;  
         
          Scene scene = new Scene(url);
             Stage stage =  (Stage) ((Node) event.getSource()).getScene().getWindow();
             stage.hide();
              stage.setScene(scene);
              stage.show();
            
             
         
           } catch(Exception e) 
           {e.printStackTrace();}
    
      }
}
