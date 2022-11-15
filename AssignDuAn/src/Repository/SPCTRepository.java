/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.ChiTietSanPham;
import DomainModels.DongSanPham;
import DomainModels.MauSac;
import DomainModels.NhaSanXuat;
import DomainModels.SanPham;
import Untility.DBConnect;
import ViewModels.testt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sangh
 */
public class SPCTRepository {

    public List<testt> getAll() {
        String query = "SELECT \n"
                + "      [ID],\n"
                + "      [NamBH]\n"
                + "      ,[MoTa]\n"
                + "      ,[SoLuongTon]\n"
                + "      ,[GiaNhap]\n"
                + "  FROM [dbo].[ChiTietSP]";
        try ( Connection con = DBConnect.getDatabaseConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            List<testt> listCTSP = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                testt test = new testt(rs.getString(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getDouble(5));
                listCTSP.add(test);
            }
            return listCTSP;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(ChiTietSanPham ctsp) {
        String query = "INSERT INTO [dbo].[ChiTietSP]\n"
                + "           [NamBH]\n"
                + "           ,[MoTa]\n"
                + "           ,[SoLuongTon]\n"
                + "           ,[GiaNhap]\n"
                + "     VALUES(?,?,?,?)";
        int check = 0;
        try ( Connection con = DBConnect.getDatabaseConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ctsp.getNamBH());
            ps.setObject(2, ctsp.getMoTa());
            ps.setObject(3, ctsp.getSoLuong());
            ps.setObject(4, ctsp.getGiaNhap());
            check = ps.executeUpdate();
            System.out.println("Thành công");
        } catch (SQLException e) {
            System.out.println("Thất bại");
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(ChiTietSanPham ctsp, String id) {
        String query = "UPDATE [dbo].[ChiTietSP]\n"
                + "   SET [IdSP] = ?\n"
                + "      ,[IdNsx] = ?\n"
                + "      ,[IdMauSac] = ?\n"
                + "      ,[IdDongSP] = ?\n"
                + "      ,[NamBH] = ?\n"
                + "      ,[MoTa] = ?\n"
                + "      ,[SoLuongTon] = ?\n"
                + "      ,[GiaNhap] = ?\n"
                + "      ,[GiaBan] = ?\n"
                + " WHERE [Id] = ?";
        int check = 0;
        try ( Connection con = DBConnect.getDatabaseConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ctsp.getIdsp().getId());
            ps.setObject(2, ctsp.getIdNSX().getId());
            ps.setObject(3, ctsp.getIdMS().getId());
            ps.setObject(4, ctsp.getIdDSP().getId());
            ps.setObject(5, ctsp.getNamBH());
            ps.setObject(6, ctsp.getMoTa());
            ps.setObject(7, ctsp.getSoLuong());
            ps.setObject(8, ctsp.getGiaNhap());
            ps.setObject(9, ctsp.getGiaBan());
            ps.setObject(10, id);
            check = ps.executeUpdate();
            System.out.println("Thành công");
        } catch (SQLException e) {
            System.out.println("Thất bại");
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String id) {
        String query = "DELETE FROM [dbo].[ChiTietSP]\n"
                + "      WHERE [Id] = ?";
        int check = 0;
        try ( Connection con = DBConnect.getDatabaseConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
            System.out.println("Thành công");
        } catch (SQLException e) {
            System.out.println("Thất bại");
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public List<ChiTietSanPham> searchByName(String tenSP) {
        String query = "SELECT SanPham.Ma, SanPham.Ten, NamBH, MoTa, SoLuongTon, GiaNhap, GiaBan \n"
                + "FROM ChiTietSP join SanPham on ChiTietSP.IdSP = SanPham.Id\n"
                + "WHERE SanPham.Ten = ?";
        List<ChiTietSanPham> listCTSP = new ArrayList<>();
        try ( Connection con = DBConnect.getDatabaseConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, tenSP);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham(rs.getString(1), rs.getString(2));
                ChiTietSanPham ctsp = new ChiTietSanPham(sp, rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getDouble(6), rs.getDouble(7));
                listCTSP.add(ctsp);
            }
            return listCTSP;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public static void main(String[] args) {
        List<testt> lists = new SPCTRepository().getAll();
        for (testt list : lists) {
            System.out.println(list.toString());
        }
    }
    
}
