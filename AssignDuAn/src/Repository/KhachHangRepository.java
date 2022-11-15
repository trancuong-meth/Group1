/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;
import DomainModels.KhachHang;
import Untility.DBConnect;
import ViewModels.KhachHangViewModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author huyxo
 */
public class KhachHangRepository {

    
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement psm = null;
    List<KhachHang> listKH = new ArrayList<>();
    
    public KhachHangRepository() {
        
    }
    public List<KhachHangViewModel> getKH(){
        String query = "SELECT MA, HO +' '+TenDem+' '+Ten,NgaySinh,Sdt,DiaChi +'-'+ThanhPho+'-'+QuocGia FROM KhachHang";
        Connection con = DBConnect.getDatabaseConnection();
        List<KhachHangViewModel> kvm = new ArrayList<>();
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                KhachHangViewModel khvm = new KhachHangViewModel();
                khvm.setMa(rs.getString(1));
                khvm.setHoTen(rs.getString(2));
                khvm.setNgaySinh(rs.getString(3));
                khvm.setSdt(rs.getString(4));
                khvm.setDiaChi(rs.getString(5));
                kvm.add(khvm);
            }
        } catch (SQLException ex) {
            
        }
        return kvm;
    }
    public String insert(KhachHang kh){
        String insert = "INSERT INTO KhachHang (Ma , Ten, TenDem, Ho , NgaySinh , Sdt , DiaChi , ThanhPho , QuocGia , MatKhau ) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            psm = DBConnect.getDatabaseConnection().prepareStatement(insert);
            
            psm.setObject(1,kh.getMaKH());
            psm.setObject(2,kh.getTenKH());
            psm.setObject(3,kh.getTenDem());
            psm.setObject(4,kh.getHo());
            psm.setObject(5,kh.getNgaySinh());
            psm.setObject(6,kh.getSdt());
            psm.setString(7,kh.getDiaChi());
            psm.setObject(8,kh.getThanhPho());
            psm.setObject(9,kh.getQuocGia());
            psm.setObject(10,kh.getMatKhau());
            
            psm.executeUpdate();
            return "Thêm thành công";
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangRepository.class.getName()).log(Level.SEVERE, null, ex);
            return "Thêm không thành công";
        }
    }
    public String update(KhachHang kh){
        String update = "UPDATE  KhachHang SET  Ten = ?, NgaySinh = ?, Sdt = ?, DiaChi = ?, ThanhPho = ?, QuocGia = ?, MatKhau = ? WHERE Ma = ?";
        try {
            psm = DBConnect.getDatabaseConnection().prepareStatement(update);
            psm.setObject(8,kh.getMaKH());
            psm.setObject(1,kh.getTenKH());
            psm.setObject(2,kh.getNgaySinh());
            psm.setObject(3,kh.getSdt());
            psm.setString(4,kh.getDiaChi());
            psm.setObject(5,kh.getThanhPho());
            psm.setObject(6,kh.getQuocGia());
            psm.setObject(7,kh.getMatKhau());
            psm.executeUpdate();
            return "Sửa thành công";
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangRepository.class.getName()).log(Level.SEVERE, null, ex);
            return "Sửa không thành công";
        }
    }
    public String delete(String id){
        String delete = "DELETE FROM  KhachHang WHERE Id = ?";
        try {
            psm = DBConnect.getDatabaseConnection().prepareStatement(delete);
            psm.setObject(1,id);

            psm.executeUpdate();
            return "Xóa thành công";
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangRepository.class.getName()).log(Level.SEVERE, null, ex);
            return "Xóa không thành công";
        }
    }

}
