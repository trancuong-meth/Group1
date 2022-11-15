/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.ChucVu;
import DomainModels.CuaHang;
import DomainModels.NhanVien;
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
public class NhanVienRepository {

    
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement psm = null;
    List<NhanVien> listNV = new ArrayList<>();
    List<ChucVu> listCV = new ArrayList<>();
    List<CuaHang> listCH = new ArrayList<>();

    public NhanVienRepository() {
        
    }

    public List<NhanVien> getNV() {
        listNV = new ArrayList<>();
        String select = "SELECT N.Ma , N.Ten ,GioiTinh , NgaySinh , N.DiaChi , Sdt , MatKhau , CV.Ten , CH.Ten , TrangThai FROM NhanVien N INNER JOIN ChucVu CV \n"
                + "ON N.IdCV = CV.Id INNER JOIN CuaHang CH \n"
                + "ON N.IdCH = CH.Id";
        try {
            Connection con = DBConnect.getDatabaseConnection();
            st = con.createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                ChucVu cv = new ChucVu(rs.getString(8));
                CuaHang ch = new CuaHang(rs.getString(9));
                listNV.add(new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), cv, ch, rs.getInt(10)));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listNV;
    }

    public List<ChucVu> getCV() {
        listCV = new ArrayList<>();
        String select = "SELECT * FROM ChucVu";
        try {
            Connection con = DBConnect.getDatabaseConnection();
            st = con.createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                listCV.add(new ChucVu(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCV;
    }

    public List<CuaHang> getCH() {
        listCH = new ArrayList<>();
        String select = "SELECT * FROM CuaHang";
        try {
            Connection con = DBConnect.getDatabaseConnection();
            st = con.createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                listCH.add(new CuaHang(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCH;
    }
    public String insert(NhanVien nv){
        String insert = "INSERT INTO NhanVien (Ma , Ten ,GioiTinh , NgaySinh , DiaChi , Sdt , MatKhau , IdCV , IdCH , TrangThai) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            psm = DBConnect.getDatabaseConnection().prepareStatement(insert);
            psm.setObject(1, nv.getMaNV());
            psm.setObject(2, nv.getTenNV());
            psm.setObject(3, nv.getGioiTinh());
            psm.setObject(4, nv.getNgaySinh());
            psm.setObject(5, nv.getDiaChi());
            psm.setObject(6,nv.getSdt());
            psm.setObject(7, nv.getMatKhau());
            psm.setObject(8, nv.getIdCV().getTenCV());
            psm.setObject(9, nv.getIdCH().getTenCH());
            psm.setObject(10, nv.getTrangThai());
            psm.executeUpdate();
            return "Thêm thành công";
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
            return "Thêm không thành công";
        }
    }
    public String update(NhanVien nv){
        String update = "UPDATE NhanVien SET Ten =? ,GioiTinh  =?, NgaySinh  =?, DiaChi  =?, Sdt  =?, MatKhau  =?, IdCV  =?, IdCH  =?, TrangThai  =? WHERE Ma = ?";
        try {
            psm = DBConnect.getDatabaseConnection().prepareStatement(update);
            psm.setObject(10, nv.getMaNV());
            psm.setObject(1, nv.getTenNV());
            psm.setObject(2, nv.getGioiTinh());
            psm.setObject(3, nv.getNgaySinh());
            psm.setObject(4, nv.getDiaChi());
            psm.setObject(5,nv.getSdt());
            psm.setObject(6, nv.getMatKhau());
            psm.setObject(7, nv.getIdCV().getTenCV());
            psm.setObject(8, nv.getIdCH().getTenCH());
            psm.setObject(9, nv.getTrangThai());
            psm.executeUpdate();
            return "Sửa thành công";
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
            return "Sủa không thành công";
        }
    }
    public String delete(NhanVien nv){
        String update = "DELETE FROM NhanVien  WHERE Ma = ?";
        try {
            psm = DBConnect.getDatabaseConnection().prepareStatement(update);
            psm.setObject(1, nv.getMaNV());
            psm.executeUpdate();
            return "Xóa thành công";
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
            return "Xóa không thành công";
        }
    }

}
