/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesos;

import Models.User;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zchann
 */
public class BDConnect {
    
    //Atributes
    private Connection con;
    
    public void Connect() throws ClassNotFoundException{
        
        try {
            var data = new String[]{"root", "", "jdbc:mysql://localhost:3306/login?useSSL=false"};
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(data[2], data[0], data[1]);
            System.out.println("Conexión lista");
        } catch (SQLException e) {
            System.err.println("Conexión no lograda");
            System.err.println(e.getMessage());
        }
        
    }
    
    public ResultSet Results(String string) throws SQLException{
        Statement consult = con.createStatement();
        return consult.executeQuery(string);
    }
    
    public void Execute(String string, User usuario) throws SQLException{
        var ps = con.prepareStatement(string);
        
        ps.setInt(1, 0);
        ps.setString(2, usuario.user);
        ps.setString(3, usuario.Fname);
        ps.setString(4, usuario.Lname);
        ps.setString(5, usuario.phone);
        ps.setString(6, usuario.email);
        ps.setString(7, usuario.pass);
        ps.executeUpdate();
    }
    
    public void CloseBD() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(BDConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
