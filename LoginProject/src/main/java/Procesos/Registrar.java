/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesos;

import Models.User;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zchann
 */
public class Registrar {
    public static boolean register(User usuario) throws SQLException {
        BDConnect bDConnect = new BDConnect();
        try {
            bDConnect.Connect();
            bDConnect.Execute("insert into reg values(?,?,?,?,?,?,?)", usuario);
            return true;
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
