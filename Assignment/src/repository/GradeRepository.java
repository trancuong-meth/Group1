/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Grade;
import model.Student;
import untility.DatabaseUtil;

/**
 *
 * @author sangh
 */
public class GradeRepository {
   List<Grade> grades;
    public List<Grade> getListGrade() {
        Connection con = DatabaseUtil.getDatabaseConnection();
         grades = new ArrayList<>();
        String query = "select student.masv, tensv, tienganh, tinhoc, GDTC from GRADE join student on Grade.masv = student.masv";
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Grade grade = new Grade();
                grade.setStudentId(rs.getString(1));
                grade.setTen(rs.getString(2));
                grade.setAnhVan(rs.getDouble(3));
                grade.setTinHoc(rs.getDouble(4));
                grade.setGDTC(rs.getDouble(5));
                grades.add(grade);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GradeRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return grades;
    }

    public boolean isExists(String studentId) {
        Connection con = DatabaseUtil.getDatabaseConnection();
        boolean isExists = false;
        String query = "SELECT * FROM [Grade] WHERE masv = '" + studentId + "'";
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                isExists = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GradeRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isExists;
    }
    public List<Grade> searchGrade(String masv) {
        List<Grade> listTemp = new ArrayList<>();
        for (Grade d : grades) {
            if(d.getStudentId().equalsIgnoreCase(masv)) {
                listTemp.add(d);
            }
        }
        return listTemp;
    }
    public void addGrade(Grade grade) {
        Connection con = DatabaseUtil.getDatabaseConnection();
        String query = "INSERT INTO [Grade] VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, grade.getStudentId());
            ps.setDouble(2, grade.getAnhVan());
            ps.setDouble(3, grade.getTinHoc());
            ps.setDouble(4, grade.getGDTC());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(GradeRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int updateGrade(Grade grade) {
        int result = 0;
        Connection con = DatabaseUtil.getDatabaseConnection();
        String query = "UPDATE [Grade]"
                + "SET tienganh = ?, "
                + "tinhoc = ?, "
                + "GDTC = ? "
                + "WHERE masv = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);

            ps.setDouble(1, grade.getAnhVan());
            ps.setDouble(2, grade.getTinHoc());
            ps.setDouble(3, grade.getGDTC());
            ps.setString(4, grade.getStudentId());
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GradeRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public int deleteGrade(String masv){
        int result = 0;
        Connection con = DatabaseUtil.getDatabaseConnection();
        String query = "DELETE FROM [Grade]"
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
