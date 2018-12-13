/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ensat;

import DAO.DaoBd;
import java.sql.Connection;

/**
 *
 * @author Toshiba
 */
public class Essai {
    public static void main(String[] args){
        DaoBd dao= new DaoBd();
        dao.setPilote("com.mysql.jdbc.Driver");
        dao.setUrl("jdbc:mysql://localhost:3306/DB18");
        dao.setLogin("root");
        dao.setPassword("");
        dao.SeConnecter();
    }
}
