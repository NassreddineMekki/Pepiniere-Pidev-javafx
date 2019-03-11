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
public class Store extends User {
    private String adress;
    private int telephone;
    private String description;

    public Store() {
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Store(int id,String email, String password, String role, String imgUrl,String dateLogOut) {
        super(id, email, password, role, imgUrl,dateLogOut);
    }

    public Store(int id,String adress, int telephone, String description, String username, String email, String password, String role, String imgUrl,String dateLogOut) {
        super(id,username, email, password, role, imgUrl,dateLogOut);
        this.adress = adress;
        this.telephone = telephone;
        this.description = description;
    }

   

    public Store(int id,String adress, int telephone, String description, String email, String password, String imgUrl,String dateLogOut) {
        super(id,email, password, imgUrl,dateLogOut);
        this.adress = adress;
        this.telephone = telephone;
        this.description = description;
    }

    public Store(String adress, int telephone, String description, String username, String email, int enabled,
            String password, String role, String imgUrl, String dateLogOut) {
        super(username, email, enabled, password, role, imgUrl, dateLogOut);
        this.adress = adress;
        this.telephone = telephone;
        this.description = description;
    }

    public Store(String adress, int telephone, String description, int id, String username, String email, int enabled, String password, String role, String imgUrl) {
        super(id, username, email, enabled, password, role, imgUrl);
        this.adress = adress;
        this.telephone = telephone;
        this.description = description;
    }

  
    
}
