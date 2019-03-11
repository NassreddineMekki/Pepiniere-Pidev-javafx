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
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import pepiniere.utils.StaticValue;
import pepiniere.utils.Upload;

/**
 * FXML Controller class
 *
 * @author FERID
 */
public class FXMLmodifierEventController implements Initializable {

    @FXML
    private Circle image;
    @FXML
    private Label name;
    @FXML
    private Label mail;
    @FXML
    private TextField nomE;
    @FXML
    private TextField adrE;
    @FXML
    private TextArea descE;
    @FXML
    private TextField FraisE;
    @FXML
    private TextField NbreE;
    @FXML
    private TextField imagE;
       private File file;
   private Image image1;
    String pic;
    @FXML
    private DatePicker DateD;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /* descE.setText(StaticValue.event.getDescription());
      FraisE.setText(""+StaticValue.event.getFrais_particpation());
      image1.setText(StaticValue.event.getImg_Event());
      NbreE.setText(""+StaticValue.event.getNbre_participant());
     */
    }    

    @FXML
    private void imageAction(ActionEvent event) throws IOException {
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
            imagE.setText(pic);
           image1= new Image("http://localhost/pidev4info/img/"+pic);
    }

    @FXML
    private void modifAction(ActionEvent event) {
        String nom=nomE.getText();
         String description=descE.getText();
       int frais = Integer.parseInt(FraisE.getText()) ;
         int nbre = Integer.parseInt(NbreE.getText()) ;
         String adresse=adrE.getText();
         String img =imagE.getText();
         
    }
    
}
