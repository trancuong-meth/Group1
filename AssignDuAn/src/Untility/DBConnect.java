/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Untility;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sangh
 */
public class DBConnect {
    private static final String HOSTNAME = "localhost";
    private static final String PASSWORD = "123456";
    private static final String USER = "sa";
    private static final String DB = "FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041";
    private static final String CONNECTION_STRING = "jdbc:sqlserver://" + HOSTNAME + ":1433;databaseName=" + DB;
    private static Connection con;
    
          public static Connection getDatabaseConnection() {
    try {
        con = DriverManager.getConnection(CONNECTION_STRING,USER,PASSWORD);
        if (con != null) {
        DatabaseMetaData metaData = con.getMetaData();
        System.out.println("Connection to database successfull");
        System.out.println("Driver name: " + metaData.getDriverName());
        System.out.println("Driver version: " + metaData.getDriverVersion());
        System.out.println("Product name: " + metaData.getDatabaseProductName());
        System.out.println("Product version: " + metaData.getDatabaseProductVersion());
        }
        return con;
    } catch (SQLException ex) {
        Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("Connection to database failed");
        return null;
    }
    }
         public static void main(String[] args) {
        getDatabaseConnection();
    }
}
