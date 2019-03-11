/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepniere.entitys;

/**
 *
 * @author FERID
 */
public class ParticipationEvent {
    private int id_p;
    private int id;
    private int id_event;
    private int confirmer ;

    public ParticipationEvent(int id_p, int id, int id_event, int confirmer) {
        this.id_p = id_p;
        this.id = id;
        this.id_event = id_event;
        this.confirmer = confirmer;
    }
    
    
public ParticipationEvent(int id, int id_event) {
        
        this.id = id;
        this.id_event = id_event;
       
    }
    public int getId_p() {
        return id_p;
    }

    public void setId_p(int id_p) {
        this.id_p = id_p;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public int getConfirmer() {
        return confirmer;
    }

    public void setConfirmer(int confirmer) {
        this.confirmer = confirmer;
    }

    @Override
    public String toString() {
        return "ParticipationEvent{" + "id_p=" + id_p + ", id=" + id + ", id_event=" + id_event + ", confirmer=" + confirmer + '}';
    }
    
    
}
