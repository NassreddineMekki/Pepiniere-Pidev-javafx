/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepniere.services;

import pepniere.entitys.Accessoire;

 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class AccessoireServices {
       static Connection cn = Connexion.getInstance().getConnection();
 
        public  void ajoutAccessoire(Accessoire  l) 
       {           
           
           try {
               String requete="INSERT INTO Produit(nom,image,categorieProduit,quantite,prix,description,reference,marque,poids,id_user,dateajout) values ('"+l.getNom()+"','"+l.getImage()+"','"+"Accessoire"+"','"+l.getQuantite()+"','"+l.getPrix()+"','"+l.getDescription()+"','"+l.getRefrence()+"','"+l.getMarque()+"','"+l.getPoids()+"','"+l.getId_user()+"','"+l.getDateAjout()+"')";
              
               Statement st;
               st = cn.createStatement();
               st.executeUpdate(requete);
            
        } catch (SQLException ex) {
            System.err.println("Error d'insertion"+ex);
        }
       
       }
        
        
        
            public  void supprimerAccessoire(int id) 
              {
                     try {
               cn.createStatement().execute("Delete from Produit where id_Produit="+id+";");
               
        } catch (SQLException ex) {
            System.err.println("Error d'suppression"+ex);
        }
              
              }
            
            
            
            
             
    public void updateAccessoire(Accessoire l, int id ) throws SQLException {
         try {
            Statement statement= cn.createStatement();
            String requete="update Produit set nom='"+l.getNom()+"' ,  image='"+l.getImage()+"' ,  quantite='"+l.getQuantite()+"' ,  prix='"+l.getPrix()+"' ,  description='"+l.getDescription()+"' ,  reference='"+l.getRefrence()+"' ,  marque='"+l.getMarque()+"' ,  poids='"+l.getPoids()+"'where id_Produit= '"+id+"'";
            statement.executeUpdate(requete);
            System.out.print("Updated !!");
        } catch (SQLException e) {
            e.printStackTrace();
        } 

        
    }
    public List<Accessoire> listerAccessoire(int id){
    List<Accessoire> mylist = new ArrayList();
    try{
    String requet = "select nom,image,quantite,prix,description,reference,marque,poids,id_Produit from produit where categorieProduit = 'Accessoire' and id_user="+id;
    Statement st2 = cn.createStatement();
        ResultSet rs = st2.executeQuery(requet);
        while(rs.next())
        {
        Accessoire ps = new Accessoire();
        ps.setNom(rs.getString(1));
        ps.setImage(rs.getString(2));
        ps.setQuantite(rs.getInt(3));
        ps.setPrix(rs.getInt(4));
        ps.setDescription(rs.getString(5));
        ps.setRefrence(rs.getString(6));
        ps.setMarque(rs.getString(7));
        ps.setPoids(rs.getInt(8));
        ps.setId_produit(rs.getInt(9));
        
        


        mylist.add(ps);
        }
    }
    catch(SQLException Ex)
            {System.out.print("errreur de selection");}
    
    
    return mylist;
    }
              
    
    public void afficherListeAccessoire(int id)
            {
               List<Accessoire> arrayList = listerAccessoire(id);
        for(Accessoire m : arrayList){
           System.out.println(m.getNom()+","+m.getImage()+","+m.getQuantite()+","+m.getPrix()+","+m.getDescription()+","+m.getRefrence()+","+m.getMarque()+","+m.getPoids());
        }
            
            }        

    
}
