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
public class User {
    private int id;
    private String username;
    private String usernameCan;
    private String email;
    private String emailCan;
    private int enabled;
    private String salt;
    private String password;
    private String lastLogin;
    private String passwordAt;
    private String role;
    private String imgUrl;
    private String dateLogOut; 

    public User(int id,String email, String password, String role, String imgUrl,String dateLogOut) {
        this.id=id;
        this.email = email;
        this.password = password;
        this.role = role;
        this.imgUrl = imgUrl;
        this.dateLogOut=dateLogOut;
    }

    public User() {
    }
  

    public User(int id,String email, String password, String imgUrl,String dateLogOut) {
        this.id=id;
        this.email = email;
        this.password = password;
        this.imgUrl = imgUrl;
        this.dateLogOut=dateLogOut;
    }
    
    public User(String email, String password, String imgUrl,String dateLogOut) {
        
        this.email = email;
        this.password = password;
        this.imgUrl = imgUrl;
        this.dateLogOut=dateLogOut;
    }
    
      public User(int id,String username,String email, String password, String role, String imgUrl,String dateLogOut) {
        this.id=id;
        this.username=username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.imgUrl = imgUrl;
        this.dateLogOut=dateLogOut;
    }

    public String getDateLogOut() {
        return dateLogOut;
    }

    public void setDateLogOut(String dateLogOut) {
        this.dateLogOut = dateLogOut;
    }
    

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public User(String username, String email, int enabled, String password, String role, String imgUrl, String dateLogOut) {
        this.username = username;
        this.email = email;
        this.enabled = enabled;
        this.password = password;
        this.role = role;
        this.imgUrl = imgUrl;
        this.dateLogOut = dateLogOut;
    }

    public User(int id, String username, String email, int enabled, String password, String role, String imgUrl) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.enabled = enabled;
        this.password = password;
        this.role = role;
        this.imgUrl = imgUrl;
    }
    
    


 

 



    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsernameCan() {
        return usernameCan;
    }

    public void setUsernameCan(String usernameCan) {
        this.usernameCan = usernameCan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailCan() {
        return emailCan;
    }

    public void setEmailCan(String emailCan) {
        this.emailCan = emailCan;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getPasswordAt() {
        return passwordAt;
    }

    public void setPasswordAt(String passwordAt) {
        this.passwordAt = passwordAt;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", usernameCan=" + usernameCan + ", email=" + email + ", emailCan=" + emailCan + ", enabled=" + enabled + ", salt=" + salt + ", password=" + password + ", lastLogin=" + lastLogin + ", passwordAt=" + passwordAt + ", role=" + role + ", imgUrl=" + imgUrl + '}';
    }

}
