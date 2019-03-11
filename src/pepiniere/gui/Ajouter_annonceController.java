/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepiniere.gui;


import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JLabel;
import pepiniere.utils.StaticValue;
import pepiniere.utils.Upload;
//import org.controlsfx.control.Notifications;
import pepniere.entitys.Annonce;
import pepniere.entitys.Produit;
import pepniere.services.Crud_Annonce;
import pepniere.services.Crud_produit;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class Ajouter_annonceController implements Initializable {

    @FXML
    private TextField type;
    @FXML
    private TextField description;
    @FXML
    private DatePicker dat;
    @FXML
    private Slider prix;
    @FXML
    private Button ajouter;
    @FXML
    private Button annuler;

    java.sql.Date da;
    @FXML
    private Label lbl;
    
    
    
    private File file;
    String pic;
    @FXML
    private TextField txtimg;
    @FXML
    private TableView<Annonce> tab_annonce;
    @FXML
    
    
    private TableColumn<Annonce, Date> date_annonce;
    @FXML
    private TableColumn<Annonce, Integer> typ;
    @FXML
    private TableColumn<Annonce, String> descriptio;
    @FXML
    private TableColumn<Annonce, Float> prixx;
    @FXML
    private ImageView h;
    @FXML
    private ImageView g;
    @FXML
    private ImageView i;
    @FXML
    private ImageView j;
    @FXML
    private ImageView l;
    @FXML
    private ImageView n;
    private ListView<Annonce> liste_annonce;
    @FXML
    private ComboBox<String> combotype;
    
    @FXML
    private Label controlSaisie;
    @FXML
    private TextField nom_produit;
    private TextField categ_produit;
    @FXML
    private AnchorPane rootpane;
    @FXML
    private VBox vb;
    @FXML
    private TextField textmodif;
    @FXML
    private ImageView i1;
    @FXML
    private Slider modifprix;
    @FXML
    private DatePicker modifdat;
    @FXML
    private TextField modiftypeprod;
    @FXML
    private TextField modifdesc;
    @FXML
    private TextField modifnom;
    @FXML
    private Label modiflbl;
    @FXML
    private ComboBox<String> combotype1;
    @FXML
    private Label cst;
    @FXML
    private TextField textmodif1;
    @FXML
    private ScrollPane pane;
    @FXML
    private TextField rech;
     
      
         
       
    @FXML
    private ImageView panier;
       
       Image img = new Image("http://localhost/pidev4info/img/"+StaticValue.client.getImgUrl(),150,150,true,true);
    @FXML
    private Circle ima;
       
    
         public void calculdate(Annonce A){
         
      java.sql.Date da = null;
      da.valueOf(LocalDate.now());
   String datS=da.toString();
   String daSS=A.date_annonce.toString();
        System.out.println(daSS);
   
}
    
    
    
    
    @FXML
    public void ajouterAnnonce(ActionEvent envent) throws IOException{
          
          
    
        
           
       
         
        String url = txtimg.getText();
        da=java.sql.Date.valueOf(dat.getValue());
        Crud_Annonce c=new Crud_Annonce();
        String prix = lbl.getText();
       float pri= Float.parseFloat(prix);
       if(description.getText().equals("") || pri==0 || type.getText().equals("") || nom_produit.getText().equals("")){
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("control saisie");
        alert.setHeaderText("attention");
        alert.setContentText("veuillez remplir tous les champs");
        alert.showAndWait();}
       else{
       
       
        int tp = combotype.getSelectionModel().getSelectedIndex() + 1;
        
        if (tp==1){
            System.out.println("achat"+tp);
              Annonce A1=new Annonce(tp,description.getText(),da,pri,url);
              
              
              
        c.ajouterAnnonce1(A1);
     //   Notifications.create().title("ajout").text("votre annonce est ajouter").showWarning();
        
        switchToScene("ajouter_annonce.fxml",envent);
        
        
        }
        
           else{
           
        
        
       
       
         Produit p=new Produit(nom_produit.getText(),url, type.getText(),pri);
         
         Crud_produit cr=new Crud_produit();
        cr.ajouterProduit(p);
             System.out.println(cr.RecupererDernier());
        Annonce A=new Annonce(tp, type.getText(),description.getText(),da,pri,url,cr.RecupererDernier(),2);
        c.ajouterAnnonce(A);
        switchToScene("ajouter_annonce.fxml",envent);
        tab_annonce.getItems().setAll(c.lister());
        }}}
    
    public void ajouterProduit(ActionEvent envent){
        String prix = lbl.getText();
       float pri= Float.parseFloat(prix);
         Produit p=new Produit(nom_produit.getText(), categ_produit.getText(),pri);
         Crud_produit c=new Crud_produit();
        c.ajouterProduit(p);
        
        
    }
    
    
    @FXML
    public void supprimerAnnonce(ActionEvent envent){
        Crud_Annonce c=new Crud_Annonce();
        if (tab_annonce.getSelectionModel().getSelectedItem()!=null){
            Annonce A=tab_annonce.getSelectionModel().getSelectedItem();
            c.suppAnnonce(A);
            tab_annonce.getItems().setAll(c.lister());
        }}
    
    
    
    @FXML
         public void supprimerAnnonce1(ActionEvent envent) throws IOException{
        Crud_Annonce c=new Crud_Annonce();
        Crud_produit c1=new Crud_produit();
        
        if (textmodif.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                   alert.setHeaderText(null);
                   alert.setContentText("selectionnez l'annonce a supprimer ");
                   alert.showAndWait();}
        else{
            
            
            
            int tp= Integer.parseInt(textmodif1.getText());
            int idA= Integer.parseInt(textmodif.getText());
            
        if(tp==1){
            
            
              c.suppAnnonce1(idA);}
        else{
            
            int a= c1.rechercherproduit(idA);
            c.suppAnnonce1(idA);
             c1.suppproduit(a);
             
            
        }
        switchToScene("ajouter_annonce.fxml",envent);
              }
                    
                
                
            
            
        }
     public void supprimerproduit(ActionEvent envent){
        Crud_produit c=new Crud_produit();
        if (textmodif.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
                   alert.setHeaderText(null);
                   alert.setContentText("selectionnez l'annonce a supprimer ");
                   alert.showAndWait();}
        else{
            
        int idA= Integer.parseInt(textmodif.getText());
            
             int a= c.rechercherproduit(idA);
             c.suppproduit(a);
                    
                
                
            
            
        }}
    
    
    
    
    
    
    // public void modifierAnnonce(ActionEvent envent){
       //  Crud_Annonce c=new Crud_Annonce();
       //  Annonce A =new Annonce();
       //  String url = txtimg.getText();
       // da=java.sql.Date.valueOf(dat.getValue());
       // Crud_Annonce c=new Crud_Annonce();
       // String prix = lbl.getText();
       //float pri= Float.parseFloat(prix);
      //  int tp = combotype.getSelectionModel().getSelectedIndex() + 1;
        
  
         
        
    
    
     
    
     
     
     
     public void goToHomeScreen(MouseEvent event) throws IOException
    {
        Parent cinema_chose_parent = FXMLLoader.load(getClass().getResource("ajouter_annonce.fxml"));      
        Scene cinema_chose_scene = new Scene(cinema_chose_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(cinema_chose_scene);
        app_stage.show(); 
        
    }
     
      
     
     
     
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        combotype.setOnAction(e->{
        String s= combotype.getSelectionModel().getSelectedItem().toString();
           
           if(s.equals("Achat")){
               type.setVisible(false);
               cst.setVisible(true);
           }
                else{
               type.setVisible(true);
               cst.setVisible(false);
               
           }
        });
         
     
        
        
        //---------------//
       prix.valueProperty().addListener(new ChangeListener() {
      
           @Override
           public void changed(ObservableValue observable, Object oldValue, Object newValue) {
               lbl.textProperty().setValue(
                        String.valueOf((int) prix.getValue()));}
              
        });
        modifprix.valueProperty().addListener(new ChangeListener() {
      
           @Override
           public void changed(ObservableValue observable, Object oldValue, Object newValue) {
               modiflbl.textProperty().setValue(
                        String.valueOf((int) modifprix.getValue()));}
              
        });
       //-----------//
       
       
       date_annonce.setCellValueFactory(new PropertyValueFactory<>("date_annonce"));
        typ.setCellValueFactory(new PropertyValueFactory<>("type")); 
       descriptio.setCellValueFactory(new PropertyValueFactory<>("description"));
        prixx.setCellValueFactory(new PropertyValueFactory<>("prix"));
         
         Crud_Annonce cree= new Crud_Annonce();
           ObservableList<Annonce> oblist;
           oblist=cree.lister();
           
         tab_annonce.setItems(oblist);
         
         FilteredList<Annonce> filterData = new FilteredList<Annonce>(oblist, e -> true);
        rech.setOnKeyReleased(e -> {
            rech.textProperty().addListener((observableValue, oldValue, newValue) -> {
             
                filterData.setPredicate((Predicate<? super Annonce>) Ann -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String lowerCaseFilter = newValue.toLowerCase();
                    if (Ann.getDescription().contains(newValue)) {
                        return true;
                    } else if (Ann.getDescription().toLowerCase().contains(newValue)) {
                        return true;
                    } else if (Float.toString(Ann.getType()).contains(newValue)) {
                        return true;
                    } else if (Float.toString(Ann.getPrix()).contains(newValue)) {
                        return true;
                    }else if (Ann.getDescription().toLowerCase().contains(newValue)) {
                        return true;
                    }
                    
                    return false;
                });
            });
            SortedList<Annonce> sortedData = new SortedList<>(filterData);

            sortedData.comparatorProperty().bind(tab_annonce.comparatorProperty());
            tab_annonce.setItems(sortedData);
                
         });
         
         
        
         
         
        ObservableList<String> options = 
        FXCollections.observableArrayList(
            "Achat",
            "Echange",
            "Vente"
        );
        combotype.setItems(options);
        combotype.setEditable(true);
        
         ObservableList<String> option = 
        FXCollections.observableArrayList(
            "Achat",
            "Echange",
            "Vente"
        );
        combotype1.setItems(option);
        combotype1.setEditable(true);
        
        
        
        liste_annonce=new ListView();
        Crud_Annonce se =new Crud_Annonce();
       
      Annonce A1=new Annonce();
List<Annonce> lr = se.lister1(2);
 
 for (Annonce A: lr)
{
HBox hb =new HBox();

VBox vb1 = new VBox();
VBox vb2 = new VBox();
Pane p=new Pane();
p.setPrefWidth(800);
p.setPrefHeight(50);
vb1.setPrefWidth( 200);
vb2.setPrefWidth(200);


    Separator v=new Separator(Orientation.VERTICAL); 
     Separator v1=new Separator(Orientation.VERTICAL); 
     Separator sp=new Separator(Orientation.HORIZONTAL);
     Separator sp1=new Separator(Orientation.HORIZONTAL);
     Separator sp2=new Separator(Orientation.HORIZONTAL);
     String desc = A.description;
String prri= Float.toString(A.prix);
Date d=A.date_annonce;
String typep;

        

if(A.type==1){
     typep="Achat";}
    
    else{
       typep="vente"; }
        Label l=new Label("Description : "+desc);
        Label l1=new Label("Prix : "+prri);
        Label l2=new Label("Type : "+typep);
        Label l3=new Label("Date : "+d);
        l.setFont(Font.font("Cambria", 18));
        l1.setFont(Font.font("Cambria", 18));
        l2.setFont(Font.font("Cambria", 18));
        l3.setFont(Font.font("Cambria", 18));
        l.setTextFill(Color.web("#040404", 0.8));
        l1.setTextFill(Color.web("#040404", 0.8));
        l2.setTextFill(Color.web("#040404", 0.8));
        l3.setTextFill(Color.web("#040404", 0.8));
        l.setOnMouseEntered((MouseEvent e)-> {
            l.setScaleX(1.5);
            l.setScaleY(1.5);
});
        l.setOnMouseExited(new EventHandler<MouseEvent>() {
   @Override
   public void handle(MouseEvent e) {
       l.setScaleX(1);
       l.setScaleY(1);
   }
});
            l.setOnMouseEntered((MouseEvent e)-> {
            l.setScaleX(1.5);
            l.setScaleY(1.5);
});
        l1.setOnMouseExited(new EventHandler<MouseEvent>() {
   @Override
   public void handle(MouseEvent e) {
       l1.setScaleX(1);
       l1.setScaleY(1);
   }
});
            l2.setOnMouseEntered((MouseEvent e)-> {
            l2.setScaleX(1.5);
            l2.setScaleY(1.5);
});
        l2.setOnMouseExited(new EventHandler<MouseEvent>() {
   @Override
   public void handle(MouseEvent e) {
       l2.setScaleX(1);
       l2.setScaleY(1);
   }
});
            l3.setOnMouseEntered((MouseEvent e)-> {
            l3.setScaleX(1.5);
            l3.setScaleY(1.5);
});
        l3.setOnMouseExited(new EventHandler<MouseEvent>() {
   @Override
   public void handle(MouseEvent e) {
       l3.setScaleX(1);
       l3.setScaleY(1);
   }
});
        
   
        
        
ImageView img = new ImageView();
            img.setImage(new Image("http://localhost/image/img/"+A.img_url,400,1500,true,true));
            img.setFitHeight(200);
            img.setFitWidth(200);
            vb.getChildren().add(hb);
            vb.getChildren().add(p);
            vb1.getChildren().add(new Label(""));
            vb1.getChildren().add(img);
            vb1.getChildren().add(new Label(""));
            vb1.setPrefSize(200,200);
            vb2.setPrefSize(200,200);
            vb.setPrefWidth(400);
            
            vb2.getChildren().add(new Label(""));
            vb2.getChildren().add(new Label(""));
            vb2.getChildren().add(l);
             vb2.getChildren().add(new Label(""));
                 
            vb2.getChildren().add(l1);
            vb2.getChildren().add(new Label(""));
            vb2.getChildren().add(l2);
            vb2.getChildren().add(new Label(""));
            vb2.getChildren().add(l3);
            
            
            
            hb.getChildren().add(vb1);
            vb2.getChildren().add(new Label(""));
            
            
            hb.getChildren().add(v);
            
            
           
            
            
             hb.getChildren().add(vb2);
             hb.getChildren().add(v1);
             
             
              
              
              img.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

     @Override
     public void handle(MouseEvent event) {
         textmodif.setText(""+A.id_annonce);
         
        textmodif1.setText(""+A.type);
         System.out.println(""+A.type);
         event.consume();
     }
      public void handle1(MouseEvent event) {
           da=java.sql.Date.valueOf(modifdat.getValue());
         modifnom.setText(""+A.id_annonce);
         
        modiftypeprod.setText(""+A.type);
         modifdesc.setText(""+A.type);
         
         modiflbl.setText(""+A.type);
         
         System.out.println(""+A.type);
         event.consume();
     }
     
       public void annulerr(ActionEvent envent) throws IOException{
          
           
       }
     
      
    
});
              
    

}
 
 
 
    }    

    @FXML
    private void addImage(ActionEvent event) throws IOException {
        
        FileChooser fileChooser = new FileChooser();
            file= fileChooser.showOpenDialog(null);
             FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

            
            pic=(file.toURI().toString());
         //  pic=new Upload().upload(file,"uimg");
           pic=new Upload().upload(file,"");
            System.out.println(pic);
       //  image= new Image("http://localhost/uimg/"+pic);
            txtimg.setText(pic);
           //image= new Image("http://localhost/pidev4info/img/"+pic);
    }

  
    @FXML
    private void modifAction(ActionEvent event) {
         
        if (textmodif.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                   alert.setHeaderText(null);
                   alert.setContentText("selectionnez l'annonce a modifier ");
                   alert.showAndWait();
        }
        else{
            Crud_Annonce c=new Crud_Annonce();
            String url = txtimg.getText();
        da=java.sql.Date.valueOf(modifdat.getValue());
        
        String modifprix = modiflbl.getText();
       float pri= Float.parseFloat(modifprix);
       
    
       
        int tp = combotype1.getSelectionModel().getSelectedIndex() + 1;
        
           
           
        
       
       
         
        int id= Integer.parseInt(textmodif.getText());
        Annonce A=new Annonce(tp, modiftypeprod.getText(),modifdesc.getText(),da,pri,url);
             System.out.println("Annonce"+A);
        c.ModifierAnnonce(A,id);
        Crud_produit cr=new Crud_produit();
       int idp= cr.rechercherproduit(id);
            System.out.println(id);
            
        Produit p=new Produit(modifnom.getText(),url, modiftypeprod.getText(),pri);
        cr.Modifierproduit(p, idp);
         
         Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("control saisie");
        alert.setHeaderText("c'est bon");
        alert.setContentText("votre produit a ete modifier");
        alert.showAndWait();
        Crud_Annonce cree= new Crud_Annonce();
           ObservableList<Annonce> oblist;
           oblist=cree.lister();
        tab_annonce.setItems(oblist);
        
            
            
        }
        
        }

    private void sweet(ActionEvent event) throws IOException {
        switchToScene(".fxml",event);
    }
 private void switchToScene(String scene,ActionEvent event) throws IOException
    {
        Parent cinema_chose_parent = FXMLLoader.load(getClass().getResource(scene));      
        Scene cinema_chose_scene = new Scene(cinema_chose_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(cinema_chose_scene);
        
        app_stage.show(); 
        
    }


    @FXML
    private void annulerr(ActionEvent event) {
    }
 
  
}

    
   

