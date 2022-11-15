/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package untility;

import view.LOGIN;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sangh
 */
public class DatabaseUtil {
    private static final String HOSTNAME = "localhost";
    private static final String PASSWORD = "sang2003";
    private static final String USER = "sa";
    private static final String DB = "QLSV";
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
        Logger.getLogger(DatabaseUtil.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("Connection to database failed");
        return null;
    }
    }
         public static void main(String[] args) {
        getDatabaseConnection();
    }
     public static ResultSet runSelectQuery(Statement st, String sql) {
	ResultSet rs = null;
	try {
	    rs = st.executeQuery(sql);
	} catch (SQLException e) {
	    Logger.getLogger(LOGIN.class.getName()).log(Level.SEVERE, null, e);
	}
	return rs;
    }

    //2. Trả lại 1 tập đối tượng
    public static ResultSet getDataFromQuery(String sql, Object... args) throws SQLException {
	PreparedStatement pstm = getStatement(sql, args);
	return pstm.executeQuery(sql);
    }

    //3. Chuẩn bị câu truy vấn trước khi thực thi với các tham số
    private static PreparedStatement getStatement(String sql, Object... args) {
	try {
	    con = getDatabaseConnection();
	    PreparedStatement ps;
	    // Dùng để triển khai các câu lệnh truy vấn thường
	    ps = con.prepareStatement(sql);
	    // Cộng các value sau câu truy vấn
	    for (int i = 0; i < args.length; i++) {
		ps.setObject(i + 1, args[i]);
	    }
	    return ps;
	} catch (SQLException ex) {
	    Logger.getLogger(LOGIN.class.getName()).log(Level.SEVERE, null, ex);
	    return null;
	}
    }
}
