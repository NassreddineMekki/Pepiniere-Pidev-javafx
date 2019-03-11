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
public class Command {
      private int id_command;
    private int quantite;
    private double prix_total;
    private String dateAdd;
    private String ctegorieProduit;
    private String categoriePlante;
    private int id_user;
    private int id_produit;
    

    public int getId_command() {
        return id_command;
    }

    public void setId_command(int id_command) {
        this.id_command = id_command;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrix_total() {
        return prix_total;
    }

    public void setPrix_total(double prix_total) {
        this.prix_total = prix_total;
    }

    public String getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(String dateAdd) {
        this.dateAdd = dateAdd;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public Command(int quantite, double prix_total, String dateAdd, int id_user, int id_produit) {
        this.quantite = quantite;
        this.prix_total = prix_total;
        this.dateAdd = dateAdd;
        this.id_user = id_user;
        this.id_produit = id_produit;
    }

    public Command(int id_command,int quantite, double prix_total, String dateAdd, String ctegorieProduit, String categoriePlante, int id_user, int id_produit) {
        this.id_command=id_command;
        this.quantite = quantite;
        this.prix_total = prix_total;
        this.dateAdd = dateAdd;
        this.ctegorieProduit = ctegorieProduit;
        this.categoriePlante = categoriePlante;
        this.id_user = id_user;
        this.id_produit = id_produit;
    }
     public Command(int quantite, double prix_total, String dateAdd, String ctegorieProduit, String categoriePlante, int id_user, int id_produit) {
        this.id_command=id_command;
        this.quantite = quantite;
        this.prix_total = prix_total;
        this.dateAdd = dateAdd;
        this.ctegorieProduit = ctegorieProduit;
        this.categoriePlante = categoriePlante;
        this.id_user = id_user;
        this.id_produit = id_produit;
    }

    public String getCtegorieProduit() {
        return ctegorieProduit;
    }

    public void setCtegorieProduit(String ctegorieProduit) {
        this.ctegorieProduit = ctegorieProduit;
    }

    public String getCategoriePlante() {
        return categoriePlante;
    }

    public void setCategoriePlante(String categoriePlante) {
        this.categoriePlante = categoriePlante;
    }

    
    
    @Override
    public String toString() {
        return "Comand{" + "id_command=" + id_command + ", quantite=" + quantite + ", prix_total=" + prix_total + ", dateAdd=" + dateAdd + ", id_user=" + id_user + ", id_produit=" + id_produit + '}';
    }

    
}
