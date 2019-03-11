/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepiniere.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import pepiniere.utils.StaticValue;
import pepniere.entitys.Event;
import pepniere.entitys.ParticipationEvent;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author FERID
 */
public class FXMLaffichageCLientController implements Initializable {

   
    @FXML
    private Circle image;
    @FXML
    private Label name;
    @FXML
    private Label mail;
    @FXML
    private VBox vb;
    @FXML
    private ImageView panel;

    /**
     * Initializes the controller class.
     */
    @FXML
    public void retourClient (ActionEvent event)  {
    try {
        
           Parent   url =  FXMLLoader.load( getClass().getResource("FXMLInterface.fxml"))  ;  
         
          Scene scene = new Scene(url);
             Stage stage =  (Stage) ((Node) event.getSource()).getScene().getWindow();
             stage.hide();
              stage.setScene(scene);
              stage.show();
            
             
         
           } catch(Exception e) 
           {e.printStackTrace();}
    
      }
    public boolean max(int c,int o)
    {if(c>o)
    {return true;
    }
    return false;
    }
  /*  public boolean comparer(int a, int c)        
    {
    
    }*/
            
       public int   discount(int u)
            
       {int c=0;
           c= u*20/100;
           System.out.println("cccccccccccc"+c);
           return c;
           
       }

          
    @Override
       public void initialize(URL url, ResourceBundle rb) {
            if(StaticValue.listProduct==null){
            Image imag= new Image("/pepiniere/gui/images/shopping-cart-empty-side-view.png");
            panel.setImage(imag);
           }else{
                if(StaticValue.listProduct!=null){
             Image imag= new Image("/pepiniere/gui/images/318-39938.jpg");
             panel.setImage(imag);}
           }
        
      name.setText(StaticValue.client.getName());
      mail.setText(StaticValue.client.getEmail());
      
      Image img = new Image("http://localhost/pidev4info/img/"+StaticValue.client.getImgUrl(),150,150,true,true);
      image.setFill(new ImagePattern(img));
     pepniere.services.EventService se =new pepniere.services.EventService();
      ParticipationEvent pa;
       
ArrayList<Event> li = se.affichageEvent();
 pepniere.services.Participation ps=new pepniere.services.Participation();
for(Event k : li) 
{
   
    Pane p=new Pane();
p.setPrefWidth(1200);
p.setPrefHeight(50);

HBox hb =new HBox();
VBox vb3 =new VBox();
VBox vb1 = new VBox();
VBox vb2 = new VBox();
    Separator v=new Separator(Orientation.VERTICAL); 
     Separator v1=new Separator(Orientation.VERTICAL); 
     Separator sp=new Separator(Orientation.HORIZONTAL); 
     String frais = Integer.toString(k.getFrais_particpation());
vb1.setPrefWidth( 300);
vb2.setPrefWidth(300);
vb3.setPrefWidth(300);
      String Nbre= Integer.toString(k.getNbre_participant());
ImageView imgg = new ImageView();
            imgg.setImage(new Image("http://localhost/image/img/"+k.getImg_Event(),200,200,true,true));

  Button b = new Button("participer");

 
  // System.out.println("ideveeeeeeeeeeennnnnnnt"+k.getId_event());
    //   System.out.println("iduserrrrrrrrrrrrr"+StaticValue.store.getId());
       
       //  System.out.println("resultatttttttt"+ps.RechercherParticipation(k.getId_event(), StaticValue.store.getId()));
  /*   if( ps.RechercherParticipation(k.getId_event(), StaticValue.store.getId())==1)
{b.setVisible(false);
}*/               
    
       //System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+k.getNbre_participant());
     //  System.out.println("parttttrrrrrrrrrrrrttttttttoooooo"+k.getNbre_participant());
       ///       if ((ps.RechercherParticipation(k.getId_event(), StaticValue.store.getId())==1))/////temchiiiii 
       //||(ps.RechercherParticipation(k.getId_event(), StaticValue.store.getId())==0)//)
    //   (k.getNbre_participant()>ps.nbreParticipationMax(k.getId_event()))
    // ps.nbreParticipationMax(k.getId_event())<(k.getNbre_participant()) &&  
       vb3.getChildren().add(b);
       
       //System.out.println("azertyyyyyyyyyyyyy"+ps.nbreParticipationMax(k.getId_event()));
     //System.out.println("888888888888888888888"+k.getNbre_participant());
   //  System.out.println("resultattttttttttttt"+(ps.nbreParticipationMax(k.getId_event())>(k.getNbre_participant()));
   boolean  l= max(ps.nbreParticipationMax(k.getId_event()),k.getNbre_participant());
       
            
            
             int n=(ps.fondateurEvent(k.getId_event()));
         
     System.out.println("!!!!!!!!!!!!!!!!! "+n);
     if ((ps.RechercherParticipation(k.getId_event(),9)==1)||(l==true) || (n== StaticValue.client.getId()))
     {b.setVisible(false);
     
     }      
                 
            
   
       System.out.println("+++++++++++++++"+ps.remise(9)  );  
      if(ps.remise(StaticValue.client.getId())>3)
      { int c=discount(k.getFrais_particpation());
      String R=Integer.toString(c);
    vb2.getChildren().add(new Label ("remiseeee"));
      vb2.getChildren().add(new Label(R));
      }
   //pa=new ParticipationEvent(f,k.getId_event());
   // b.setOnAction(ps.ajouterParticipation(pa));

String m=Integer.toString(k.getId_event());
Label id=new Label(m);

vb1.getChildren().add(imgg);
vb2.getChildren().add(new Label (""));
vb2.getChildren().add(id);

id.setVisible(false);
  
vb2.getChildren().add(new Label ("Nom_event"));
vb2.getChildren().add(new Label(k.getNom_event()));

vb2.getChildren().add(new Label (""));
vb2.getChildren().add(new Label ("Description"));

vb2.getChildren().add(new Label(k.getDescription()));
vb2.getChildren().add(new Label (""));
vb2.getChildren().add(new Label ("Adresse Event"));
vb2.getChildren().add(new Label(k.getAdresse_event()));
vb2.getChildren().add(new Label (""));
vb2.getChildren().add(new Label ("Frais de participation"));
vb2.getChildren().add(new Label (frais));
vb2.getChildren().add(new Label (""));
vb2.getChildren().add(new Label ("Nbre de participation"));
vb2.getChildren().add(new Label (Nbre));

hb.getChildren().add(vb1);
hb.getChildren().add(v);
hb.getChildren().add(vb2);
hb.getChildren().add(v1);
hb.getChildren().add(vb3);

EventHandler<ActionEvent> h = new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            ParticipationEvent pv = new ParticipationEvent(StaticValue.client.getId(), k.getId_event());
            ps.ajouterParticipation(pv);
           // se.update_confirmer(k.getId_event());
 
        TrayNotification tray = new TrayNotification();

//       aa.setImage(image);
                   String nom ="merci pour votre participation" ;
                   String prenom = "il y'a quelques secondes" ;
                   
                   tray.setTray("Notification", nom +" "+prenom ,NotificationType.INFORMATION);
                   // tray.setT
                   tray.showAndDismiss(javafx.util.Duration.seconds(5));
        
        
        }
     
    };

  
b.setOnAction(h);
vb.getChildren().add(hb);   
    
vb.getChildren().add(sp);

     
        //sepHor.setValignment(VPos.);
             

              }
    
       }
}

  
      


