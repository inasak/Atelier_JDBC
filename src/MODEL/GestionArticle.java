/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import DAO.DaoBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Clock;

/**
 *
 * @author Toshiba
 */
public class GestionArticle {
    private Connection Con;
    private Statement St;
    private DaoBd dao;
    public GestionArticle(){
        dao= new DaoBd();
        dao.setPilote("com.mysql.jdbc.Driver");
        dao.setUrl("jdbc:mysql://localhost:3306/DB18");
        dao.setLogin("root");
        dao.setPassword("");
        dao.SeConnecter();
        Con=dao.getConnexion();
    }
    public void Create(int code, String Des, float prix){
        String Req;
        Req = "insert into Article values('"+code+"','"+Des+"','"+prix+"');";
        try{
            if(Con!=null)
            {
                St =Con.createStatement();
                St.executeUpdate(Req);
            }
        }
        catch(SQLException ex){
            System.out.println("Erreur dans la requete Create : "+ex.getMessage());
        }
    }
    public void Add(int code, String nom, float prix){
        try{
            PreparedStatement Pst = Con.prepareStatement("insert into Article values(?,?,?)");
            Pst.setInt(1, code);
            Pst.setString(2, nom);
            Pst.setFloat(3, prix);
            Pst.executeUpdate();
            System.out.println("Ajout effectue avec succes");
        }
        catch(SQLException e){
            System.err.println("Erreur dans la requete Add: "+e.getMessage());
        }
    }
    public void All_Articles(){
        ResultSet Res;
        try{
            St= Con.createStatement();
            Res=St.executeQuery("select * from Article");
            while(Res.next()){
                System.out.println(Res.getInt(1)+"  "+ Res.getString(2)+"  "+Res.getFloat(3));
            }
        }
        catch(SQLException e){
            System.err.println("Erreur de la requete select ou St: "+e.getMessage());
            
        }
    }
    public ResultSet
        LesArticles(){
        ResultSet Res=null;
        try{
            St= Con.createStatement();
            Res=St.executeQuery("select * from Article");
        }
        catch(SQLException e){
            System.err.println("Erreur de la requete select ou St: "+e.getMessage());
        }
        return Res;
    }
    public void Update(int code, String nom, float prix)
    {
      
        try{
            PreparedStatement Pst = Con.prepareStatement("update Article set designation=?, prix=? where Code=?");
            Pst.setString(1, nom);
            Pst.setFloat(2, prix);
            Pst.setInt(3, code);
            Pst.executeUpdate();
            int nb= Pst.executeUpdate();
            System.out.println("MAJ reussie, nbre de lignes affectees est :"+nb);
        }
        catch(SQLException e){
            System.err.println("Erreur dans la requete Update: "+e.getMessage());
        }
    }
}
