/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepniere.entitys;

import java.sql.Date;
import javafx.scene.control.Button;

/**
 *
 * @author Nassreddine
 */
public class Offre_PlantSitting extends PlantSitting {
      int quantite_max;
            Button Reservation;

    public Offre_PlantSitting() {
    }

    public Button getReservation() {
        return Reservation;
    }

    public void setReservation(Button Reservation) {
        this.Reservation = Reservation;
    }

    public Offre_PlantSitting(int id_offre, String localisation, int quantite_max, Date date_debut, Date date_fin, float prix, String description, int type) {
        super(id_offre, localisation,  date_debut, date_fin, prix, description, type);
                this.quantite_max=quantite_max;

    }

    public Offre_PlantSitting(String localisation, int quantite_max, Date date_debut, Date date_fin, float prix, String description) {
        super(localisation, date_debut, date_fin, prix, description);
        this.quantite_max=quantite_max;
    }


    public int getQuantite_max() {
        return quantite_max;
    }

    public void setQuantite_max(int quantite_max) {
        this.quantite_max = quantite_max;
    }
        
}
