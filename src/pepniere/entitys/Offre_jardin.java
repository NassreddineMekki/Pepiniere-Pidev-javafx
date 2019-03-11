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
public class Offre_jardin {
     int id_offre_jardin;
    java.util.Date date_debut;
    java.util.Date date_fin;
    String localisation;
    float prix;
    String description;

    public Offre_jardin() {
    }
    public Offre_jardin(Date date_debut, Date date_fin, String localisation, float prix, String description) {
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.localisation = localisation;
        this.prix = prix;
        this.description = description;
    }

    public Offre_jardin(int id_offre_jardin, Date date_debut, Date date_fin, String localisation, float prix, String description) {
        this.id_offre_jardin = id_offre_jardin;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.localisation = localisation;
        this.prix = prix;
        this.description = description;
    }

    public int getId_offre_jardin() {
        return id_offre_jardin;
    }

    public void setId_offre_jardin(int id_offre_jardin) {
        this.id_offre_jardin = id_offre_jardin;
    }

    public Date getDate_debut() {
        return(Date) date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return (Date) date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
