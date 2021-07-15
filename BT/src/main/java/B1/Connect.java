package B1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Hud
 */
public class Connect {
    
    private String url;
    private String name;
    private String pass;
    
    public Connect(){
        url = "jdbc:mysql://localhost:3306/sp";
        name= "root";
        pass = "root";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(this.url,this.name,this.pass);
    } 
    public static void main(String[] args) {
        Connect c= new Connect();
    }
}
