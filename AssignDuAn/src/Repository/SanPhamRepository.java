/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.SanPham;
import Untility.DBConnect;
import ViewModels.SPReponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sangh
 */
public class SanPhamRepository {
    private String Select_All = "Select * From SanPham";
    private String Insert = "Insert into SanPham (MA,TEN) values(?,?)";
    private String Update = "Update SanPham Set MA=?,TEN=? Where ID=?";
    private String Delete = "Delete from SanPham Where ID=?";
    private String GetAllById = "SELECT Ma,Ten,NamBH,ChiTietSP.MoTa,SoLuongTon,GiaNhap,ChiTietSP.GiaBan "
                        + "from SanPham inner join ChiTietSP on SanPham.Id=ChiTietSP.IdSP";
    
    public ArrayList<SPReponse> getAllById() {
        ArrayList<SPReponse> listSP = new ArrayList<>();
        try {
            Connection conn = DBConnect.getDatabaseConnection();

            PreparedStatement ps = conn.prepareStatement(GetAllById);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                SPReponse spr = new SPReponse();
                spr.setMa(rs.getString(1));
                spr.setTen(rs.getString(2));
                spr.setNamBH(rs.getInt(3));
                spr.setSoLuongSP(rs.getInt(4));
                spr.setGiaNhap(rs.getFloat(5));
                spr.setGiaBan(rs.getFloat(6));
                listSP.add(spr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listSP;
    }
    public ArrayList<SanPham> getList(){
        ArrayList<SanPham> listSP = new ArrayList<>();
        try {
            Connection con = (Connection) DBConnect.getDatabaseConnection();
            PreparedStatement ps = con.prepareStatement(Select_All);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()){
                SanPham sanPham = new SanPham();
                sanPham.setId(rs.getString(1));
                sanPham.setMa(rs.getString(2));
                sanPham.setTen(rs.getString(3));
                listSP.add(sanPham);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listSP;
    }
    public boolean add(SanPham sp) {
        String query = "INSERT INTO [dbo].[SanPham]\n"
                + "           ([Ma]\n"
                + "           ,[Ten])\n"
                + "     VALUES(?,?)";
        int check = 0;
        try ( Connection con = DBConnect.getDatabaseConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, sp.getMa());
            ps.setObject(2, sp.getTen());
            check = ps.executeUpdate();
            System.out.println("Thành công");
        } catch (SQLException e) {
            System.out.println("Thất bại");
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    public void update(SanPham sanPham, String Id){
        try {
            Connection con = DBConnect.getDatabaseConnection();
            PreparedStatement ps = con.prepareStatement(Update);
            ps.setString(1, sanPham.getMa());
            ps.setString(2, sanPham.getTen());
            ps.setString(3, sanPham.getId());
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
