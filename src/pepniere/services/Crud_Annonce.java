/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepniere.services;




import Utile.Datasource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import pepniere.entitys.Annonce;


/**
 *
 * @author HP
 */
public class Crud_Annonce {

    Connection cn = new Datasource().getInstance().getConnecion();

    public void ajouterAnnonce(Annonce A) {
        String requet = "Insert Into annonce Set type=?,description=?,date_annonce=?,prix=?,img_url=?,id_user=?,type_produit=?,id_produit=?";
        try {
            PreparedStatement pr = cn.prepareStatement(requet);
            //pr.setInt(1, A.id_annonce);
            pr.setInt(1, A.type);
            pr.setString(2, A.description);
            pr.setDate(3, A.date_annonce);
            pr.setFloat(4, A.prix);
            pr.setString(5, A.img_url);
            pr.setInt(6, 2);
            pr.setString(7, A.type_produit);
            pr.setInt(8, A.id_produit);

            pr.executeUpdate();

            if (A.type == 3) {
                List<String> myList = new ArrayList<>();
                Crud_Annonce cr = new Crud_Annonce();
                myList = cr.rechercherAnnonce("fleur");
                for (String user : myList) {
                    // Recipient's email ID needs to be mentioned.
                    String to = user;

                    // Sender's email ID needs to be mentioned
                    String from = "web@gmail.com";

                    // Assuming you are sending email from localhost
                    String host = "localhost";

                    // Get system properties
                    Properties properties = System.getProperties();
                    properties.put("mail.smtp.auth", "true");
                    properties.put("mail.smtp.starttls.enable", "true");
                    properties.put("mail.smtp.host", "smtp.gmail.com");
                    properties.put("mail.smtp.port", "587");
                    Session session = Session.getInstance(properties,
                            new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication("mohamed.benabedelfattah@esprit.tn", "hesoyam@");
                        }
                    });
                    session.setDebug(true);
                    try {
                        MimeMessage message = new MimeMessage(session);
                        message.setFrom(new InternetAddress(from));
                        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                        message.setSubject("Annonce d'achat disponible");
                        message.setText("quelque'un a publié une annonce d'achat sur ton produit");
                        Transport.send(message);
                        System.out.println("Sent message successfully....");
                    } catch (MessagingException mex) {
                        mex.printStackTrace();
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("erreur " + ex);

        }

    }
//
     public void ajouterAnnonce1(Annonce A) {
           String requet = "Insert Into annonce Set type=?,description=?,date_annonce=?,prix=?,img_url=?,id_user=?";
        try {
            PreparedStatement pr = cn.prepareStatement(requet);
            //pr.setInt(1, A.id_annonce);
            pr.setInt(1, A.type);
            pr.setString(2, A.description);
            pr.setDate(3, A.date_annonce);
            pr.setFloat(4, A.prix);
            pr.setString(5, A.img_url);
             pr.setInt(6,2);
            
            

            pr.executeUpdate();
        }
             catch (Exception ex) {
            System.out.println("erreur " + ex);

        }
         
     }
    
    
    
    

    public ObservableList<Annonce> lister() {
        ObservableList<Annonce> myList = FXCollections.observableArrayList();
        try {
            String requete2 = "SELECT id_annonce,type,description,date_annonce,prix from annonce";
            Statement st2 = cn.createStatement();
            ResultSet rs = st2.executeQuery(requete2);
            while (rs.next()) {
                Annonce A = new Annonce();
                A.setId_annonce(rs.getInt(1));
                A.setType(rs.getInt(2));
                A.setDescription(rs.getString(3));
                A.setDate_annonce(rs.getDate(4));
                A.setPrix(rs.getInt(5));

                myList.add(A);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return myList;

    }
    //____________________________
    public ArrayList<Annonce> lister1(int id) {
        ArrayList<Annonce> myList = new ArrayList<>();
        try {
            String requete2 = "SELECT id_annonce,type,description,date_annonce,prix,img_url from annonce where id_user='"+id+"'";
            Statement st2 = cn.createStatement();
            ResultSet rs = st2.executeQuery(requete2);
            while (rs.next()) {
                Annonce A = new Annonce();
                A.setId_annonce(rs.getInt(1));
                A.setType(rs.getInt(2));
                A.setDescription(rs.getString(3));
                A.setDate_annonce(rs.getDate(4));
                A.setPrix(rs.getInt(5));
                A.setImg_url(rs.getString(6));

                myList.add(A);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return myList;

    }
    
    
    
    
    
    
    

    public void ModifierAnnonce(Annonce o, int id) {
        try {
            String requete = "update annonce set type='" + o.getType() + "' , description='" + o.getDescription() + "' ,  date_annonce='" + o.getDate_annonce() + "' ,  prix='" + o.getPrix() + "' ,  img_url='" + o.getImg_url() + "' where id_annonce= '" + id + "'";
            PreparedStatement st = cn.prepareStatement(requete);

            st.executeUpdate(requete);
            System.out.print("Annonce Modifiee");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public boolean suppAnnonce1(int id) {
        boolean dell = true;
        try {
            String requete2 = "Delete FROM annonce where id_annonce ='"+id+"'";
            PreparedStatement pr = cn.prepareStatement(requete2);
            
            dell = pr.execute();

        } catch (Exception e) {
            
            System.err.println(e.getMessage());
        }
        return dell;
    }

    public boolean suppAnnonce(Annonce A) {
        boolean dell = true;
        try {
            String requete2 = "Delete FROM annonce where id_annonce =?";
            PreparedStatement pr = cn.prepareStatement(requete2);
            pr.setInt(1, A.getId_annonce());
            dell = pr.execute();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return dell;
    }
    
               

            
        


    public List<String> rechercherAnnonce(String type) {
        List<String> myList = new ArrayList<>();
        try {
            String requete2 = "SELECT email,type_produit from annonce left join user on annonce.id_user=user.id where type_produit='" + type + "' and type=1";
            Statement st2 = cn.createStatement();
            ResultSet rs = st2.executeQuery(requete2);
            while (rs.next()) {

                myList.add(rs.getString(1));

            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return myList;
    }
    public int getdate(Annonce A){
        String daSS=A.date_annonce.toString();
              String str=daSS.substring(8);
              int strr= Integer.parseInt(str);
              return strr;
    }
    
    public void supprimerAnnoncePasse2(){
        //String query = "DELETE from annonce WHERE DATEDIFF(NOW(),date_annonce) > 7 ";
        String query = "SELECT id_user from annonce WHERE DATEDIFF(NOW(),date_annonce) > 7 ";
        try{
            Statement st = cn.createStatement();
            PreparedStatement pst = cn.prepareStatement("Insert Into notifications (id_user, message) values(?,?)");
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                pst.setInt(1, rs.getInt(1));
                pst.setString(2, "Votre annonce à été supprimée ");
                pst.executeUpdate();
            }
            Statement dst = cn.createStatement();
            dst.executeQuery("DELETE from annonce WHERE DATEDIFF(NOW(),date_annonce) > 7 ");
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }
    
    
    public void supprimerAnnoncePasse(){
        
        
        try{
            
             Statement dst = cn.createStatement();
             dst.executeUpdate("DELETE from annonce WHERE DATEDIFF(NOW(),date_annonce) > 7 ");
             
            
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }
    
 }
