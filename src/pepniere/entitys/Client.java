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
public class Client extends User{
   private String name;
   private String firstName;
   private String adress;
   private int nb_Participation;
   private int telephone;
   private String sex;
   private String description;

   
//******************************  CONSTRUCTEUR AUTHENTIFICATION **************************
    public Client(String name, String firstName, String adress, int nb_Participation, int telephone, String sex, String description, int id,String email, 
            String password, String imgUrl,String dateLogOut) {
        super(id,email, password, imgUrl,dateLogOut);
        this.name = name;
        this.firstName = firstName;
        this.adress = adress;
        this.nb_Participation = nb_Participation;
        this.telephone = telephone;
        this.sex = sex;
        this.description = description;
    }

    public Client(String name, String firstName, String adress, int nb_Participation, int telephone, String sex, String description, 
            int id,String email, String password, String role, String imgUrl,String dateLogOut) {
        super(id,email, password, role, imgUrl,dateLogOut);
        this.name = name;
        this.firstName = firstName;
        this.adress = adress;
        this.nb_Participation = nb_Participation;
        this.telephone = telephone;
        this.sex = sex;
        this.description = description;
    }
    
//********************************

    public Client(String name, String firstName, String adress, int nb_Participation, int telephone, String sex, String description,
            String email, String password, String imgUrl, String dateLogOut) {
        super(email, password, imgUrl, dateLogOut);
        this.name = name;
        this.firstName = firstName;
        this.adress = adress;
        this.nb_Participation = nb_Participation;
        this.telephone = telephone;
        this.sex = sex;
        this.description = description;
    }

    public Client() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  



  

  

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getNb_Participation() {
        return nb_Participation;
    }

    public void setNb_Participation(int nb_Participation) {
        this.nb_Participation = nb_Participation;
    }


    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

 
   
   
}
