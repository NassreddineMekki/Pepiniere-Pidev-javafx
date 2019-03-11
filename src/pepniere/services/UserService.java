/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepniere.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pepiniere.utils.BCrypt;
import pepiniere.utils.DataSource;
import pepniere.entitys.Admin;
import pepniere.entitys.Client;

import pepniere.entitys.Store;
import pepniere.entitys.User;


/**
 *
 * @author Nassreddine
 */
public class UserService {
    
      Connection connection = null;
     
     private PreparedStatement ps;
    public UserService(){
     connection = DataSource.getInstance().getConnection();
    }

    public Client FindClientById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    public Admin FindAdmintById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    public User Authentification(String login, String password) {
        User u = null;
        String request = "SELECT * FROM fos_user where username=?";
        try{
           PreparedStatement st;
        st = connection.prepareStatement(request);
        st.setString(1,login);
        
        ResultSet rs = st.executeQuery();
         
          
        
        while(rs.next()){
             if(BCrypt.checkpw(password,rs.getString(8))==true){
             
              if(rs.getString(12).equals("a:0:{}")){
                                  

                           u = new Client(
                                  
                                   rs.getString(15),
                                   rs.getString(16),
                                   rs.getString(17),
                                   rs.getInt(18),
                                   rs.getInt(19),
                                   rs.getString(20),
                                   rs.getString(21),
                                    rs.getInt(1),
                                   rs.getString(4),
                                   rs.getString(8),
                                   rs.getString(12),
                                   rs.getString(13),
                                   rs.getString(14)
                        );
                    }
              else {if(rs.getString(12).equals("admin")){
              
                u = new Admin(   
                                   
                                   rs.getString(15),
                                   rs.getString(16),
                                   rs.getString(17),
                                   rs.getInt(1),
                                   rs.getString(4),
                                   rs.getString(8),
                                   rs.getString(12),
                                   rs.getString(13),
                                    rs.getString(14)
                );
              
              }else{
                                    u = new Store(   
                                   
                                   rs.getString(17),
                                   rs.getInt(18),
                                   rs.getString(21),
                                   rs.getInt(1),
                                   rs.getString(2),
                                   rs.getString(4),
                                   rs.getInt(6),
                                   rs.getString(8),
                                   rs.getString(12),
                                   rs.getString(13)
                );
              }
          }}
        }
        }catch(Exception ex){
            System.out.println("erreur authentification "+ex);
        }
        return u ;
    }
    
     public ArrayList listAllUser() {
        User u = null;
        ArrayList<User> list = new ArrayList<>();
        String request = "SELECT * FROM fos_user ";
        try{
           PreparedStatement st;
        st = connection.prepareStatement(request);
       
        
        ResultSet rs = st.executeQuery();
         
          
        
        while(rs.next()){
            
             
              if(rs.getString(12).equals("a:0:{}")){
                                  

                           u = new Client(
                                  
                                   rs.getString(15),
                                   rs.getString(16),
                                   rs.getString(17),
                                   rs.getInt(18),
                                   rs.getInt(19),
                                   rs.getString(20),
                                   rs.getString(21),
                                    rs.getInt(1),
                                   rs.getString(4),
                                   rs.getString(8),
                                   rs.getString(12),
                                   rs.getString(13),
                                   rs.getString(14)
                        );
                           list.add(u);
                    }
              else {if(rs.getString(12).equals("admin")){
              
                u = new Admin(   
                                   
                                   rs.getString(15),
                                   rs.getString(16),
                                   rs.getString(17),
                                   rs.getInt(1),
                                   rs.getString(4),
                                   rs.getString(8),
                                   rs.getString(12),
                                   rs.getString(13),
                                    rs.getString(14)
                );
              list.add(u);
              }else{
                                    u = new Store(   
                                   
                                   rs.getString(17),
                                   rs.getInt(18),
                                   rs.getString(21),
                                   rs.getInt(1),
                                   rs.getString(2),
                                   rs.getString(4),
                                   rs.getInt(6),
                                   rs.getString(8),
                                   rs.getString(12),
                                   rs.getString(13)
                );
                                    list.add(u);
              }
          }
        }
        }catch(Exception ex){
            System.out.println("erreur authentification "+ex);
        }
        return list ;
    }

  
    public void adduserClient(Client c) {
       String request = "INSERT INTO fos_user SET username=?,username_canonical=?,email=?,email_canonical=?,enabled=?,"
               + "salt=?,password=?,last_login=?,confirmation_token=?,password_requested_at=?,roles=?,img_url=?,datelogout=?,name=?,first_name=?,adress=?,nb_Participation=?,telephone=?,sex=?,description=?";
       try{
        String passwd = BCrypt.hashpw(c.getPassword(),BCrypt.gensalt(13));
        PreparedStatement st = connection.prepareStatement(request);
        st.setString(1,c.getName());
        st.setString(2,"");
        st.setString(3,c.getEmail());
        st.setString(4,"");
        st.setInt(5,10);
        st.setString(6,"");
        st.setString(7,passwd);
        st.setString(8,"" );
        st.setString(9,"" );
        st.setString(10,c.getPassword());
        st.setString(11,"a:0:{}");//store
        st.setString(12,c.getImgUrl());
        st.setString(13,c.getDateLogOut());
        st.setString(14,c.getName());
        st.setString(15,c.getName());
        st.setString(16,c.getAdress());
        st.setInt(17,0);
        st.setInt(18,c.getTelephone());
        st.setString(19,"");
        st.setString(20,c.getDescription());
           System.err.println("AAAAAAAAAAAAAAAAAAAAjooooooooooooooooooooouuuuuuuuuuuuuuuuuuuuutttttttttttttttttttttttttt");
         
        
     st.executeUpdate();
       }catch(Exception ex){
           System.out.println("Error in method add "+ex);
       }
               
    }

   
      public void adduserStrore(Store c) {
       String request = "INSERT INTO fos_user SET username=?,username_canonical=?,email=?,email_canonical=?,enabled=?,"
               + "salt=?,password=?,last_login=?,confirmation_token=?,password_requested_at=?,roles=?,img_url=?,datelogout=?,name=?,first_name=?,adress=?,nb_Participation=?,telephone=?,sex=?,description=?";
       try{
        String passwd = BCrypt.hashpw(c.getPassword(),BCrypt.gensalt(13));
        PreparedStatement st = connection.prepareStatement(request);
        st.setString(1,c.getUsername());
        st.setString(2,"");
        st.setString(3,c.getEmail());
        st.setString(4,"");
        st.setInt(5,c.getEnabled());
        st.setString(6,"");
        st.setString(7,passwd);
        st.setString(8,"" );
        st.setString(9,"" );
        st.setString(10,c.getPassword());
        st.setString(11,"store");//
        st.setString(12,c.getImgUrl());
        st.setString(13,c.getDateLogOut());
        st.setString(14,c.getUsername());
        st.setString(15,c.getUsername());
        st.setString(16,c.getAdress());
        st.setInt(17,0);
        st.setInt(18,c.getTelephone());
        st.setString(19,"");
        st.setString(20,c.getDescription());
           System.err.println("AAAAAAAAAAAAAAAAAAAAjooooooooooooooooooooouuuuuuuuuuuuuuuuuuuuutttttttttttttttttttttttttt");
         
        
     st.executeUpdate();
       }catch(Exception ex){
           System.out.println("Error in method add Store "+ex);
       }
               
    }

  
  
    
    public ArrayList <Store> selectStoreBloqedUser() {
        Store s = null;
       ArrayList<Store> arrayList = new ArrayList<Store>();
       String request = "SELECT * FROM fos_user WHERE enabled=?";
       try{
           PreparedStatement st;
            st = connection.prepareStatement(request);
             st.setInt(1,0);
            ResultSet rs = st.executeQuery();
             while(rs.next()){
                                     s = new Store(   
                                   
                                   rs.getString(17),
                                   rs.getInt(18),
                                   rs.getString(21),
                                   rs.getInt(1),
                                   rs.getString(2),
                                   rs.getString(4),
                                   rs.getInt(6),
                                   rs.getString(8),
                                   rs.getString(12),
                                   rs.getString(13)
                );
                  arrayList.add(s);
            }
       }catch(Exception ex){
           System.out.println("exeptionn in nb commande"+ex);
       }
       return arrayList;
    }

   
    public void updateDateLogOutUserClient(String d ,int id) {
              String request = "UPDATE fos_user SET datelogout=? WHERE id=?";
        try{
           PreparedStatement st = connection.prepareStatement(request);
           st.setString(1, d);
            st.setInt(2, id);
            st.executeUpdate();
            System.out.println("*************************************************date + id "+d+" "+id);
        }
        catch(Exception ex){
            System.out.println("erreur update "+ex);
        }
    }

   
    public void updateUserAdmin(Admin a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
   

   
    public void updateUserStore(Store a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public Store FindStoreById(int id)  {
        Store s = null;
        String request = "SELECT * FROM fos_user where id=?";
        try{
         
             PreparedStatement st;
            st = connection.prepareStatement(request);
           st.setInt(1,id);
        
        ResultSet rs = st.executeQuery();
      
        while(rs.next()){
             s= new Store(   
                                   
                                   rs.getString(17),
                                   rs.getInt(18),
                                   rs.getString(21),
                                   rs.getInt(1),
                                   rs.getString(2),
                                   rs.getString(4),
                                   rs.getInt(6),
                                   rs.getString(8),
                                   rs.getString(12),
                                   rs.getString(13));
        }
        }catch(Exception ex){
            System.out.println(" find stire by id"+ex  ); 
        }  
        
        return s;
    }
      public int nbStoreBloque(){
      int nb=0;
       String request = "SELECT count(*) FROM fos_user WHERE enabled=?";
       try{
           PreparedStatement st;
            st = connection.prepareStatement(request);
             st.setInt(1,0);
            ResultSet rs = st.executeQuery();
             while(rs.next()){
              nb = rs.getInt(1);
            }
       }catch(Exception ex){
           System.out.println("exeptionn in nb commande"+ex);
       }
      return nb;
    }
          public void deleteStore(int id) {
        try {
              String request = "delete from fos_user where id=?";
         
               PreparedStatement  st = connection.prepareStatement(request);
               st.setInt(1,id);
               st.executeUpdate();
        } catch (Exception ex) {
             System.out.println("erroe in delete store "+ex);
        }
    }
           public void activateStore(int id ){
             String request = "UPDATE fos_user SET enabled=? WHERE id=?";
        try{
           PreparedStatement st = connection.prepareStatement(request);
           st.setInt(1, 10);
            st.setInt(2, id);
            st.executeUpdate();
        }
        catch(Exception ex){
            System.out.println("erreur update "+ex);
        }
    }
           public boolean findbynum(int num) {
        String req = "select * from fos_user where Telephone =?";
        boolean u = false;
        

        try {
            ps = connection.prepareStatement(req);
            ps.setInt(1, num);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                            if(rs.getInt(19)==num)
                                u=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }
    
    public List<Store> listerBoutique()  {
    List<Store> mylist = new ArrayList();
    try{
    String requet = "SELECT id,username,adress,telephone FROM fos_user where roles = 'store'";
    Statement st2 = connection.createStatement();
        ResultSet rs = st2.executeQuery(requet);
        while(rs.next())
        {
            
            
        Store ps = new Store();
        
ps.setId(rs.getInt(1));
ps.setUsername(rs.getString(2));
ps.setAdress(rs.getString(3));
ps.setTelephone(rs.getInt(4));

        mylist.add(ps);
        }
    }catch(SQLException Ex)
            {System.out.print("errreur de selection");}
   
    
    return mylist;

    }
    
       public void afficherBoutique() 
            {
               List<Store> arrayList = listerBoutique();
        for(Store m : arrayList){
           System.out.println(m.getId()+","+m.getUsername()+","+m.getAdress()+","+m.getTelephone());
        }
            
            }
       
       
       
             
    public String findbypwd(int num) {
        String req = "select * from fos_user where Telephone =?";
        String u = "";
        

        try {
            ps = connection.prepareStatement(req);
            ps.setInt(1, num);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                            if(rs.getInt(19)==num) //telephone
                                u=rs.getString(11); // pwd
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }
       
}