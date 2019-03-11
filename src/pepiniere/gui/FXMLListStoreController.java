/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepiniere.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import pepiniere.utils.StaticValue;
import pepniere.entitys.Store;
import pepniere.services.UserService;

/**
 * FXML Controller class
 *
 * @author Nassreddine
 */
public class FXMLListStoreController implements Initializable {

    @FXML
    private Circle cir;
    @FXML
    private Label name;
    @FXML
    private VBox vb;
    @FXML
    private ScrollPane pane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       name.setText(StaticValue.admin.getUsername());
        Image img = new Image("http://localhost/pidev4info/img/"+StaticValue.admin.getImgUrl(),150,150,true,true);
        cir.setFill(new ImagePattern(img));
        UserService us = new UserService();
        ArrayList<Store> list = us.selectStoreBloqedUser();
        pane.setPrefViewportWidth(800);
        for(Store s : list ){
            
             VBox vb1 = new VBox();
              VBox vb2 = new VBox();
               VBox vb3 = new VBox();
                HBox hb = new HBox();
                
                ImageView imgg = new ImageView();
               imgg.setImage(new Image("http://localhost/pidev4info/img/"+s.getImgUrl(),200,200,true,true));
               
               vb1.setPrefSize(200,200);
               vb1.getChildren().add(imgg);
               
               vb2.getChildren().add(new Label(" - Nom Boutique "+s.getUsername()));
               vb2.getChildren().add(new Label(""));
                vb2.getChildren().add(new Label(" - Eadresse mail  "+s.getEmail()));
               vb2.getChildren().add(new Label(""));
                vb2.getChildren().add(new Label(" - Numero telephone "+s.getTelephone()));
               vb2.getChildren().add(new Label(""));
                
                vb2.setPrefSize(500, 200);
               
                Button del = new Button("supprimer");
                Button add = new Button("Autorisé");
                  
                
                vb3.getChildren().addAll(del,new Label(""),add);
                vb2.setPrefSize(200, 200);
                hb.getChildren().addAll(vb1,vb2,vb3);
                
                vb.getChildren().add(hb);
                EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
                 @Override
                 public void handle(ActionEvent event) {
                     us.deleteStore(s.getId());
                 }
             };
                del.setOnAction(buttonHandler);
                
                 EventHandler<ActionEvent> buttonActiv = new EventHandler<ActionEvent>() {
                 @Override
                 public void handle(ActionEvent event) {
                    us.activateStore(s.getId());
                     try{
                         int n = (s.getId()*s.getTelephone())/100;
            String host ="smtp.gmail.com" ;
            String user = "nasredinemeki@gmail.com";
            String pass = "22216323admisesprit";
            String to = "nassreddine.mekki@esprit.tn";
            String from = "nasredinemeki@gmail.com";
            String subject = "This is confirmation number "+n+" for your expertprogramming account. Please insert this number to activate your account.";
            String messageText = "Your Is Test Email :";
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject); msg.setSentDate(new Date());
            msg.setText(messageText);

           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("message send successfully");
           System.out.println("message send successfully");
        }catch(Exception ex)
        {
            System.out.println("erruer "+ex);
        }
                 }
             };
                add.setOnAction(buttonActiv);
        }
    }    

    @FXML
    private void buckAction(ActionEvent event) throws IOException {
        Parent parentInscit = FXMLLoader.load(getClass().getResource("FXMLAdmin.fxml"));
        
              Scene sceneInscit = new Scene(parentInscit);
              Stage stageInscit  = (Stage)((Node)event.getSource()).getScene().getWindow();
       
             stageInscit .hide();
        
             stageInscit .setScene(sceneInscit );
             stageInscit .show();
             StaticValue.listProduct=null;
    }
    
}
