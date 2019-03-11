/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepiniere.gui;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import pepniere.services.CommandService;

/**
 * FXML Controller class
 *
 * @author Nassreddine
 */
public class FXMLStatCommandController implements Initializable {

    @FXML
    private BarChart<?, ?> chart;
    @FXML
    private Circle cir;
    @FXML
    private Label lbl1;
    @FXML
    private Label lbl2;
    @FXML
    private Label lbl3;
    @FXML
    private Label lbl4;
    @FXML
    private Label lb;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        CommandService cs = new CommandService();
        
        int nbPlante =  cs.nbCatPlante();
        int nbLivre =  cs.nbCatLivre();
        int nbMed =  cs.nbCatMed();
        int nbAcc =  cs.nbCatAccesoire();
        
        double nbTot = (double)cs.nbComand();
        
        double moyPlante =  (nbPlante/nbTot)*100;
        double moyLivre =  (nbLivre/nbTot)*100;
        double moyMed =  (nbMed/nbTot)*100;
        double moyAcc =  (nbAcc/nbTot)*100;
        
        System.out.println("nombre plante = "+nbPlante);
        System.out.println("nombre plante = "+nbLivre);
        System.out.println("nombre plante = "+nbMed);
        System.out.println("nombre plante = "+nbAcc);
        
        System.out.println("************************************************");
         
        System.out.println("moy plante = "+moyPlante);
        System.out.println("moy plante = "+moyLivre);
        System.out.println("moy plante = "+moyMed);
        System.out.println("moy plante = "+moyAcc);
        
        XYChart.Series set1 = new XYChart.Series<>();
        set1.getData().add(new XYChart.Data("Plante",(int)moyPlante));
        set1.getData().add(new XYChart.Data("Livre",(int)moyLivre));
        set1.getData().add(new XYChart.Data("Medicament",(int)moyMed));
        set1.getData().add(new XYChart.Data("Accesoire",(int)moyAcc));
        
        chart.getData().addAll(set1);
        
         lbl1.setText("- Pourcentage de Catégorie Plante est : "+(int)moyPlante+"%");
        lbl2.setText("- Pourcentage de Catégorie Livre est : "+(int)moyLivre+"%");
        lbl3.setText("- Pourcentage de Catégorie Medicament est : "+(int)moyMed+"%");
        lbl4.setText("- Pourcentage de Catégorie Accesoire est : "+(int)moyAcc+"%");
        
       
        
        int[] tab = {nbPlante,nbLivre,nbMed,nbAcc};
        
        int j=nbPlante;
        int k = 0;
        for(int i = 0 ; i<4 ; i++){
            if(tab[i]>j){
              j=tab[i];
                System.out.println(" tableau "+tab[i]);
              k=i;
              System.out.println(" tableau11111 "+k);
            }
        }
        String s = "";
        if(k==0){
          s="Plante";
        }else if(k==1){
          s="Livre";
        }
        else if(k==2){
          s="Medicament";
        }
        else if(k==3){
           s="Accesoire";
        }
        lb.setText("la categorie la plus demandé est la categorie " +s);
         
    }    
    
}
