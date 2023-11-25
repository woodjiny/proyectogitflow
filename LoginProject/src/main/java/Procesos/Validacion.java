/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesos;

import com.woodcompany.loginproject.LoginProject;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zchann
 */
public class Validacion {
    public static boolean isValid(String[] value) throws SQLException {
        BDConnect bDConnect = new BDConnect();
        try {
            bDConnect.Connect();
            var resultados = bDConnect.Results("select * from reg");
            while (resultados.next()) {
                if (value[0].equals(resultados.getString("username")) && value[1].equals(resultados.getString("pass"))) {
                    bDConnect.CloseBD();
                    return true;
                }
                
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginProject.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        bDConnect.CloseBD();
        return false;
    }
}
