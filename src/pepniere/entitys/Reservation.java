/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepniere.entitys;

/**
 *
 * @author Nassreddine
 */
public class Reservation {
    int id_reservation;
    int id_plante;
    int quantite;
    int id_offre;
    String status;
    int id_user;

    public Reservation(int id_offre, int quantite) {
        this.id_offre = id_offre;
        this.quantite = quantite;
    }

    public Reservation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_offre() {
        return id_offre;
    }

    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    }

    public Reservation(int id_offre, int quantite,int id_user) {
        this.id_offre = id_offre;
        
        this.quantite = quantite;
        this.id_user = id_user;
    }
    

    public int getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(int id_reservation) {
        this.id_reservation = id_reservation;
    }

    public int getId_plante() {
        return id_plante;
    }

    public void setId_plante(int id_plante) {
        this.id_plante = id_plante;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    
}
