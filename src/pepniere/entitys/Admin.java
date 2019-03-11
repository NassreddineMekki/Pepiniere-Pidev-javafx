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
public class Admin extends User{
  private String name;
   private String firstName;
   private String adress;
   
   
    public Admin(String name, String firstName, String adress,int id, String email, String password, String role, String imgUrl,String dateLogOut) {
        super(id,email, password, role, imgUrl,dateLogOut);
        this.name = name;
        this.firstName = firstName;
        this.adress = adress;
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
 

    


   
   

  

   

}
