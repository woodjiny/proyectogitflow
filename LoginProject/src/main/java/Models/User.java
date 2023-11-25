/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author zchann
 */
public class User {
    public int id;
    public String user;
    public String Fname;
    public String Lname;
    public String phone;
    public String email;
    public String pass;

    public User(String user, String Fname, String Lname, String phone, String email, String pass) {
        this.user = user;
        this.Fname = Fname;
        this.Lname = Lname;
        this.phone = phone;
        this.email = email;
        this.pass = pass;
    }
    
    
    
}
