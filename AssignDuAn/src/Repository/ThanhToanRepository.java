/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.ChiTietSanPham;
import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import DomainModels.NhanVien;
import DomainModels.SanPham;
import Untility.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author huyxo
 */
public class ThanhToanRepository {

    
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement psm = null;
    List<SanPham> listSP = new ArrayList<>();
    List<ChiTietSanPham> listCT = new ArrayList<>();
    List<NhanVien> listNV = new ArrayList<>();
    List<HoaDon> listHD = new ArrayList<>();
    List<HoaDonChiTiet> listHDCT = new ArrayList<>();

    public ThanhToanRepository() {
        
    }

    public List<HoaDon> getHD() {
        listHD = new ArrayList<>();
        String select = "  SELECT Ma , NgayTao , TinhTrang FROM HoaDon";
        try {
            st = DBConnect.getDatabaseConnection().createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                listHD.add(new HoaDon(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ThanhToanRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listHD;
    }

    public String getMaHD(String hd) {

        String select = "SELECT * FROM HoaDon WHERE Ma = ?";
        try {
            psm = DBConnect.getDatabaseConnection().prepareStatement(select);
            psm.setString(1, hd);
            rs = psm.executeQuery();
            while (rs.next()) {
                listHD.add(new HoaDon(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
            return "ok";
        } catch (SQLException ex) {
            Logger.getLogger(ThanhToanRepository.class.getName()).log(Level.SEVERE, null, ex);
            return "k";
        }
    }

    public String insert(HoaDon hd) {
        String insert = "INSERT INTO HoaDon (Ma , NgayTao , TinhTrang ) VALUES (?,?,?)";
        try {
            psm = DBConnect.getDatabaseConnection().prepareStatement(insert);
            psm.setObject(1, hd.getMaHD());
            psm.setObject(2, hd.getNgayTao());
            psm.setObject(3, hd.getTinhTrang());
            psm.executeUpdate();
            return "ok";
        } catch (SQLException ex) {
            Logger.getLogger(ThanhToanRepository.class.getName()).log(Level.SEVERE, null, ex);
            return "k";
        }
    }
//    public String addGH(String idSPCT){
//        String insert = "SELECT S.Ma , S.Ten , NamBH , MoTa , SoLuongTon , GiaNhap ,GiaBan FROM SanPham S INNER JOIN ChiTietSP CT \n" +
//                        "ON S.Id = CT.IdSP WHERE S.Ma = ?";
//        try {
//            psm = db.openDbConnection().prepareStatement(insert);
//            psm.setObject(1, idSPCT);
//            rs = psm.executeQuery();
//            while (rs.next()) {    
//                listCT.add(new ChiTietSP( rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4),rs.getInt(5), rs.getString(6), rs.getString(7)));
//            }
//            return "ok";
//        } catch (SQLException ex) {
//            Logger.getLogger(ThanhToan_Repository.class.getName()).log(Level.SEVERE, null, ex);
//            return "k";
//        }
//    }
    
}
     
//, (DonGia * SoLuong) AS N'Tổng tiền' 
