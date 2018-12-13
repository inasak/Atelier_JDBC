/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Toshiba
 */
public class DaoBd { //add library
    public static String Pilote;
    public static String Url;
    public static String Login;
    public static String Password;
    public static Connection Connexion;
    public void SeConnecter(){
        try {
            System.out.println("Chargement de Pilote...");
            Class.forName(Pilote);
            System.out.println("Chargement de Pilote reussi...");
            Connexion = DriverManager.getConnection(Url, Login, Password);
            
            
        } catch (ClassNotFoundException ex) {
            System.err.println("Pb de Pilote!");
        } catch (SQLException ex) {
            System.err.println("Pb de Connexion !");
        }
              
    }

    public static String getPilote() {
        return Pilote;
    }

    public static void setPilote(String Pilote) {
        DaoBd.Pilote = Pilote;
    }

    public static String getUrl() {
        return Url;
    }

    public static void setUrl(String Url) {
        DaoBd.Url = Url;
    }

    public static String getLogin() {
        return Login;
    }

    public static void setLogin(String Login) {
        DaoBd.Login = Login;
    }

    public static String getPassword() {
        return Password;
    }

    public static void setPassword(String Password) {
        DaoBd.Password = Password;
    }

    public static Connection getConnexion() {
        return Connexion;
    }

    public static void setConnexion(Connection Connexion) {
        DaoBd.Connexion = Connexion;
    }
    
}
