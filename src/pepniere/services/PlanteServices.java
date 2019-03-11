/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepniere.services;


import pepniere.entitys.Plante;
 import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author ASUS
 */
public class PlanteServices {
   static Connection cn = Connexion.getInstance().getConnection();
 
        public void ajoutPlante(Plante  l) 
       {           
           
           try {
               String requete="INSERT INTO Produit(nom,image,categorieProduit,quantite,prix,description,categorieplants,types,dure_vie,origine,poids,saison,taille,couleur,id_user,dateajout) values ('"+l.getNom()+"','"+l.getImage()+"','"+"Plante"+"','"+l.getQuantite()+"','"+l.getPrix()+"','"+l.getDescription()+"','"+l.getCategoriePlante()+"','"+l.getType_categorie()+"','"+l.getDuree_vie()+"','"+l.getOrigine()+"','"+l.getPoids()+"','"+l.getSaison()+"','"+l.getTaille()+"','"+l.getCouleur()+"','"+l.getId_user()+"','"+l.getDateAjout()+"')";
              
               Statement st;
               st = cn.createStatement();
               st.executeUpdate(requete);
          
            
        } catch (SQLException ex) {
            System.err.println("Error d'insertion"+ex);
        }
       
       }
        
        
        
            public  void supprimerPlante(int id) 
              {
                     try {
               cn.createStatement().execute("Delete from Produit where id_Produit="+id+";");
               
        } catch (SQLException ex) {
            System.err.println("Error d'suppression"+ex);
        }
              
              }
            
            
             public List<Plante> rechercher(String x,int id) {
    Plante reclamation = null;
        List<Plante> plantes = new ArrayList<>();
        String req = "select nom,image,quantite,prix,description,origine,poids,saison,taille,couleur,categorieplants,types,dure_vie,id_Produit from produit where (`categorieplants`LIKE '%"+x+"%' ) and id_user="+id;
        System.out.println(req);
        PreparedStatement preparedStatement;
        try {
            preparedStatement = cn.prepareStatement(req);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
   Plante ps = new Plante();
        ps.setNom(rs.getString(1));
        ps.setImage(rs.getString(2));
        ps.setQuantite(rs.getInt(3));
        ps.setPrix(rs.getInt(4));
        ps.setDescription(rs.getString(5));
        
        ps.setOrigine(rs.getString(6));


        ps.setPoids(rs.getInt(7));
        ps.setSaison(rs.getString(8));
        ps.setTaille(rs.getInt(9));
        ps.setCouleur(rs.getString(10));
         ps.setCategoriePlante(rs.getString(11));
        ps.setType_categorie(rs.getString(12));
        ps.setDuree_vie(rs.getString(13));
        ps.setId_produit(rs.getInt(14));

            System.out.println(ps.getCategoriePlante()+"***************");

                plantes.add(ps);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return plantes;}
            
        
    public void updatePlante(Plante l, int id ) throws SQLException {
         try {
            Statement statement= cn.createStatement();
            String requete="update Produit set nom='"+l.getNom()+"' ,  image='"+l.getImage()+"' ,  quantite='"+l.getQuantite()+"' ,  prix='"+l.getPrix()+"' ,  description='"+l.getDescription()+"' ,  categorieplants='"+l.getCategoriePlante()+"' ,  types='"+l.getType_categorie()+"' ,  dure_vie='"+l.getDuree_vie()+"' ,  poids='"+l.getPoids()+"' ,  saison='"+l.getSaison()+"' ,  taille='"+l.getTaille()+"' ,  couleur='"+l.getTaille()+"' ,  origine='"+l.getOrigine()+"'where id_Produit= '"+id+"'";
            statement.executeUpdate(requete);
            System.out.print("Updated !!");
        } catch (SQLException e) {
            e.printStackTrace();
        } 

        
    }
    public List<Plante> listerPlante(int id){
    List<Plante> mylist = new ArrayList();
    try{
    String requet = "select nom,image,quantite,prix,description,origine,poids,saison,taille,couleur,categorieplants,types,dure_vie,id_Produit from produit where categorieProduit = 'Plante' and id_user =" +id;
    Statement st2 = cn.createStatement();
        ResultSet rs = st2.executeQuery(requet);
        while(rs.next())
        {
        Plante ps = new Plante();
        ps.setNom(rs.getString(1));
        ps.setImage(rs.getString(2));
        ps.setQuantite(rs.getInt(3));
        ps.setPrix(rs.getInt(4));
        ps.setDescription(rs.getString(5));
        
        ps.setOrigine(rs.getString(6));


        ps.setPoids(rs.getInt(7));
        ps.setSaison(rs.getString(8));
        ps.setTaille(rs.getInt(9));
        ps.setCouleur(rs.getString(10));
         ps.setCategoriePlante(rs.getString(11));
        ps.setType_categorie(rs.getString(12));
        ps.setDuree_vie(rs.getString(13));
        ps.setId_produit(rs.getInt(14));

            System.out.println(ps.getCategoriePlante()+"***************");

        


        mylist.add(ps);
        }
    }
    catch(SQLException Ex)
            {System.out.print("errreur de selection");}
    
    
    return mylist;
    }
              
    
    public void afficherListePlante( int id)
            {
               List<Plante> arrayList = listerPlante(id);
        for(Plante m : arrayList){
           System.out.println(m.getNom()+","+m.getImage()+","+m.getQuantite()+","+m.getPrix()+","+m.getDescription()+","+m.getCategoriePlante()+","+m.getType_categorie()+","+m.getDuree_vie()+","+m.getOrigine()+","+m.getPoids()+","+m.getSaison()+","+m.getTaille()+","+m.getCouleur());
        }
            
            }   
    
}
