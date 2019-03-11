/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepniere.entitys;

import java.sql.Date;

/**
 *
 * @author Nassreddine
 */
public class Service_PlantSitting extends PlantSitting{
     int quantite;

    public Service_PlantSitting(int id_offre, String localisation, Date date_debut, Date date_fin, float prix, String description, int type) {
        super(id_offre, localisation, date_debut, date_fin, prix, description, type);

        this.quantite=quantite;
    }

    public Service_PlantSitting(int quantite, String localisation, java.sql.Date date_debut, java.sql.Date date_fin, float prix, String description) {
        super(localisation, date_debut, date_fin, prix, description);
        this.quantite = quantite;
    }

    

    public Service_PlantSitting() {
    }

    

    public int getQuantite() {
        return quantite;
    }

    public Service_PlantSitting(int id_offre, int id_plante) {
        super(id_offre, id_plante);
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    
}
