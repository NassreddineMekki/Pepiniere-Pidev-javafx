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
public class Payer {
     int id_prod;
     int id_user;
     int id_comand;
     String nomProduti;
     String nomBoutique;
     String datePay;
     int quantite;
     float montant;

    public Payer(int id_prod, int id_user, int id_comand, String nomProduti, String nomBoutique, String datePay, int quantite, float montant) {
        this.id_prod = id_prod;
        this.id_user = id_user;
        this.id_comand = id_comand;
        this.nomProduti = nomProduti;
        this.nomBoutique = nomBoutique;
        this.datePay = datePay;
        this.quantite = quantite;
        this.montant = montant;
    }

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_comand() {
        return id_comand;
    }

    public void setId_comand(int id_comand) {
        this.id_comand = id_comand;
    }

    public String getNomProduti() {
        return nomProduti;
    }

    public void setNomProduti(String nomProduti) {
        this.nomProduti = nomProduti;
    }

    public String getNomBoutique() {
        return nomBoutique;
    }

    public void setNomBoutique(String nomBoutique) {
        this.nomBoutique = nomBoutique;
    }

    public String getDatePay() {
        return datePay;
    }

    public void setDatePay(String datePay) {
        this.datePay = datePay;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    @Override
    public String toString() {
        return "Payer{" + "id_prod=" + id_prod + ", id_user=" + id_user + 
                ", id_comand=" + id_comand + ", nomProduti=" + nomProduti +
                ", nomBoutique=" + nomBoutique + ", datePay=" + datePay + ", "
                + "quantite=" + quantite + ", montant=" + montant + '}';
    }
     
     
}
