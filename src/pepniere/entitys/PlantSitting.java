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
public class PlantSitting {
     int id_offre;
    String localisation;
    java.util.Date date_debut;
    java.util.Date date_fin;
    float prix;
    String description;
    int type;
    int id_plante;
    int id_user;
     public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_plante() {
        return id_plante;
    }

    public void setId_plante(int id_plante) {
        this.id_plante = id_plante;
    }

    public PlantSitting(int id_offre, String localisation,java.util.Date date_debut, java.util.Date date_fin, float prix, String description, int type) {
        this.id_offre = id_offre;
        this.localisation = localisation;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.prix = prix;
        this.description = description;
        this.type = type;
    }

    public PlantSitting(String localisation,Date date_debut, Date date_fin, float prix, String description) {
        this.localisation = localisation;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.prix = prix;
        this.description = description;
    }

    public PlantSitting() {
    }

    public PlantSitting(int id_offre, int id_plante) {
        this.id_offre = id_offre;
        this.id_plante = id_plante;
    }

    public int getId_offre() {
        return id_offre;
    }

    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public Date getDate_debut() {
        return (Date) date_debut;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    
}
