/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepiniere.gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import pepiniere.utils.StaticValue;
import pepniere.entitys.Client;
import pepniere.entitys.Store;
import pepniere.entitys.User;
import pepniere.services.UserService;

/**
 * FXML Controller class
 *
 * @author Nassreddine
 */
public class FXMLListAllUserController implements Initializable {

    @FXML
    private Circle cir;
    @FXML
    private Label name;
    @FXML
    private ScrollPane pane;
    @FXML
    private VBox vb;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        name.setText(StaticValue.admin.getUsername());
        Image img = new Image("http://localhost/pidev4info/img/"+StaticValue.admin.getImgUrl(),150,150,true,true);
        cir.setFill(new ImagePattern(img));
        UserService us = new UserService();
        ArrayList<User> list = us.listAllUser();
        pane.setPrefViewportWidth(800);
               for(User s : list ){
                   VBox vb1 = new VBox();
              VBox vb2 = new VBox();
               VBox vb3 = new VBox();
                HBox hb = new HBox();
              if(s.getRole().equals("store")){
                     
                Store store =(Store)s;
                ImageView imgg = new ImageView();
               imgg.setImage(new Image("http://localhost/pidev4info/img/"+store.getImgUrl(),200,200,true,true));
                  System.out.println("store"+store.getAdress()+" "+store.getEmail());
               vb1.setPrefSize(200,200);
               vb1.getChildren().add(imgg);
                  if(s.getEnabled()==0){vb2.getChildren().add(new Label("Boutique activée"));}
               vb2.getChildren().add(new Label(" - Nom Boutique "+store.getUsername()));
               vb2.getChildren().add(new Label(""));
                vb2.getChildren().add(new Label(" - Eadresse mail  "+store.getEmail()));
               vb2.getChildren().add(new Label(""));
               
                vb2.getChildren().add(new Label(" - Numero telephone "+store.getTelephone()));
               vb2.getChildren().add(new Label(""));
                
                vb2.setPrefSize(500, 200);
               
                Button del = new Button("supprimer");
                Button add = new Button("Autorisé");
                if(s.getEnabled()==0){add.setVisible(true);}
                
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
                    // us.activateStore(s.getId());
                     try{
                         int n = (s.getId()*store.getTelephone())/100;
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
              }else{if(s.getRole().equals("a:0:{}")){
                 Client client =(Client)s;
                ImageView imgg = new ImageView();
               imgg.setImage(new Image("http://localhost/pidev4info/img/"+client.getImgUrl(),200,200,true,true));
               
               vb1.setPrefSize(200,200);
               vb1.getChildren().add(imgg);
                vb2.getChildren().add(new Label("Comte")); 
               vb2.getChildren().add(new Label(" - Nom Client "+client.getName()+" "+client.getFirstName()));
               vb2.getChildren().add(new Label(""));
                vb2.getChildren().add(new Label(" - Eadresse mail  "+client.getEmail()));
               vb2.getChildren().add(new Label(""));
               
                vb2.getChildren().add(new Label(" - Numero telephone "+client.getTelephone()));
               vb2.getChildren().add(new Label(""));
                
                vb2.setPrefSize(500, 200);
               
                Button del = new Button("supprimer");
              
                
                vb3.getChildren().addAll(new Label(""),del);
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
              }
                
                
    
             
              }
        }
    }    

    @FXML
    private void buckAction(ActionEvent event) {
    }
    
}
