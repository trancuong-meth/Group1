/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.DongSanPham;
import Untility.DBConnect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sangh
 */
public class DongSanPhamRepository {
    
    private final String Select_All = "Select * From DongSP";
    private final String Insert = "Insert into DongSP (MA,TEN) values(?,?)";
    private final String Update = "Update DongSP Set MA=?,TEN=? Where ID=?";
    private final String Delete = "Delete from DongSP Where ID=?";
    
    public ArrayList<DongSanPham> getList(){
        ArrayList<DongSanPham> listDongSP = new ArrayList<>();
        try {
            Connection con = DBConnect.getDatabaseConnection();
            PreparedStatement ps = con.prepareStatement(Select_All);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()){
                DongSanPham dongSanPham = new DongSanPham();
                dongSanPham.setId(rs.getString(1));
                dongSanPham.setMa(rs.getString(2));
                dongSanPham.setTen(rs.getString(3));
                listDongSP.add(dongSanPham);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listDongSP;
    }
        public boolean add(DongSanPham dsp) {
        String query = "INSERT INTO [dbo].[DongSP]\n"
                + "           ([Ma]\n"
                + "           ,[Ten])\n"
                + "     VALUES(?,?)";
        int check = 0;
        try ( Connection con = DBConnect.getDatabaseConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, dsp.getMa());
            ps.setObject(2, dsp.getTen());
            check = ps.executeUpdate();
            System.out.println("Thành công");
        } catch (SQLException e) {
            System.out.println("Thất bại");
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    public void update(DongSanPham dongSanPham, String Id){
        try {
            Connection con = DBConnect.getDatabaseConnection();
            PreparedStatement ps = con.prepareStatement(Update);
            ps.setString(1, dongSanPham.getMa());
            ps.setString(2, dongSanPham.getTen());
            ps.setString(3, dongSanPham.getId());
            ps.execute();
        } catch (SQLException e) {
             e.printStackTrace();
        }
    }
    public void Delete(String Id){
        try {
            Connection con = DBConnect.getDatabaseConnection();
            PreparedStatement ps = con.prepareStatement(Delete);
            ps.setString(1, Id);
            ps.execute();
        } catch (SQLException e) {
             e.printStackTrace();
        }
    }
}
