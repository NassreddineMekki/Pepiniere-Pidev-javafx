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

   

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author FERID
 */

public class Event {
    private  int id_event;
    private java.sql.Date date_deb;

  
    private  String description;
    private int id_user;
    private int frais_particpation;
    private String adresse_event;
    private String nom_event;
    private int nbre_participant;
    private String img_Event ;
  private int confirmer;

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getConfirmer() {
        return confirmer;
    }

    public void setConfirmer(int confirmer) {
        this.confirmer = confirmer;
    }

 

    /*   public Events(String nom_event,java.sql.Date date_deb, java.sql.Date date_fin, String description, int id_user, String adresse_event,int frais_particpation) {
    this.nom_event = nom_event;
    this.date_deb = date_deb;
    this.date_fin = date_fin;
    this.description = description;
    this.id_user = id_user;
    this.adresse_event = adresse_event;
    this.frais_particpation=frais_particpation;
    }
     */
   

    public Event(String description, String adresse_event, String nom_event, int frais_particpation, int nbre_participant) {
        this.description = description;
        this.adresse_event = adresse_event;
        this.nom_event = nom_event;
        this.frais_particpation=frais_particpation;
        this.nbre_participant=nbre_participant;
    }
    
  public Event(Date date_deb,  String description, String adresse_event, String nom_event,int frais_particpation,int nbre_participant,String img_Event,int id_user) {
        this.date_deb = date_deb;
     this.id_user=id_user;
        this.description = description;
        this.adresse_event = adresse_event;
        this.nom_event = nom_event;
                this.frais_particpation=frais_particpation;
                this.nbre_participant=nbre_participant;
              this.img_Event=img_Event;
             
    }

    public void setNbre_participant(int nbre_participant) {
        this.nbre_participant = nbre_participant;
    }

    public int getNbre_participant() {
        return nbre_participant;
    }

    public void setNom_event(String nom_event) {
        this.nom_event = nom_event;
    }

    public String getNom_event() {
        return nom_event;
    }

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public java.sql.Date getDate_deb() {
        return date_deb;
    }

    public void setDate_deb(java.sql.Date date_deb) {
        this.date_deb = date_deb;
    }

 

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getid_user() {
        return id_user;
    }

    public void setid_user(int id_user) {
        this.id_user = id_user;
    }

    public String getAdresse_event() {
        return adresse_event;
    }

    public void setAdresse_event(String adresse_event) {
        this.adresse_event = adresse_event;
    }
   @Override
    public String toString() {
        return "Events{" + "date_deb=" + date_deb +  ", description=" + description + ", id_user=" + id_user + ", adresse_event=" + adresse_event + ", nom_event=" + nom_event + '}';
    }

    public Event(int id_event) {
    this.id_event=id_event;
    
    }   
     public Event(){}

    public void setFrais_particpation(int frais_particpation) {
        this.frais_particpation = frais_particpation;
    }

    public int getFrais_particpation() {
        return frais_particpation;
    }

    public String getImg_Event() {
        return img_Event;
    }

    public void setImg_Event(String img_Event) {
        this.img_Event = img_Event;
    }
    
    
    
}
