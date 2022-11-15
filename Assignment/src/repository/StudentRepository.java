/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Student;
import untility.DatabaseUtil;

/**
 *
 * @author sangh
 */
public class StudentRepository {

    public List<Student> getListStudent() {
        Connection con = DatabaseUtil.getDatabaseConnection();
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM student";
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Student student = new Student();
                student.setStudentId(rs.getString(1));
                student.setStudentName(rs.getString(2));
                student.setEmail(rs.getString(3));
                student.setPhoneNumber(rs.getString(4));
                student.setSex(rs.getBoolean(5));
                student.setAddress(rs.getString(6));
                student.setImage(rs.getString(7));
                students.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }

    public boolean isExists(String studentId) {
        Connection con = DatabaseUtil.getDatabaseConnection();
        boolean isExists = false;
        String query = "SELECT * FROM [student] WHERE masv = '" + studentId + "'";
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                isExists = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isExists;
    }

    public void addStudent(Student student) {
        Connection con = DatabaseUtil.getDatabaseConnection();
        String query = "INSERT INTO [student] VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, student.getStudentId());
            ps.setString(2, student.getStudentName());
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getPhoneNumber());
            ps.setBoolean(5, student.getSex());
            ps.setString(6, student.getAddress());
            ps.setString(7, student.getImage());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(StudentRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int updateStudent(Student student) {
        int result = 0;
        Connection con = DatabaseUtil.getDatabaseConnection();
        String query = "UPDATE [student]"
                + "SET tensv = ?, "
                + "email = ?, "
                + "sodt = ?, "
                + "gioitinh = ?, "
                + "diachi = ?, "
                + "hinh = ? "
                + "WHERE masv = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setString(1, student.getStudentName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getPhoneNumber());
            ps.setBoolean(4, student.getSex());
            ps.setString(5, student.getAddress());
            ps.setString(6, student.getImage());
            ps.setString(7, student.getStudentId());
            result=ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public int deleteStudent(String masv){
        int result = 0;
        Connection con = DatabaseUtil.getDatabaseConnection();
        String query = "DELETE FROM [student]"
                +"WHERE masv = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, masv);
            result=ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("a");
        }
        return result;
    }
}
