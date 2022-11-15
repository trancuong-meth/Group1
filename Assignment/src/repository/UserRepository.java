/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.*;
import model.User;
import untility.DatabaseUtil;

/**
 *
 * @author sangh
 */
public class UserRepository {
    private static final Connection con = DatabaseUtil.getDatabaseConnection();
    public User getUserByUserName(String username) throws SQLException{
        User user = new User();
        
        String query = "SELECT * FROM [users] WHERE username = '" + username + "'";
        Statement st = con.createStatement();
        ResultSet rs = DatabaseUtil.runSelectQuery(st, query);
        while (rs.next()) {
            user.setUsername(rs.getString(1));
            user.setPassword(rs.getString(2));
            user.setRole(rs.getString(3));
        }
        System.out.println(user.toString());
        return user;
    }
}
