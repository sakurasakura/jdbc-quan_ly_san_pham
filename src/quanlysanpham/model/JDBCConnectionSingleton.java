/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysanpham.model;

/**
 *
 * @author Admin
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCConnectionSingleton {
    static final String url = "jdbc:mysql://localhost:3306/quan_ly_san_pham";
    static final String user= "root";
    static final String password="1234";
    
    private static Connection connection;

    private static void createConnection() {
        try {
            connection=DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(JDBCConnectionSingleton.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private JDBCConnectionSingleton() {
    }
    public static Connection connect(){
        if(connection==null){
            createConnection();
        }
        return connection;
    }
}
