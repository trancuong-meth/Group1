/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import ViewModels.HoaDonViewModel;
import Untility.DBConnect;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author NGUYEN THANH HUNG
 */
public class HoaDonRepository {

    public List<HoaDonViewModel> getAll() {
        String query = "select HoaDon.Ma, HoaDon.NgayTao, NhanVien.Ten, HoaDon.TinhTrang \n"
                + "from HoaDon JOIN NhanVien on HoaDon.IdNV = NhanVien.Id\n"
                + "            JOIN KhachHang on HoaDon.IdKH = KhachHang.Id";
        try ( Connection con = DBConnect.getDatabaseConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            List<HoaDonViewModel> listHD = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonViewModel hd = new HoaDonViewModel(rs.getString(1), rs.getDate(2), rs.getString(3), rs.getInt(4));
                listHD.add(hd);
            }
            return listHD;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public static void main(String[] args) {
        List<HoaDonViewModel> lists = new HoaDonRepository().getAll();
        for (HoaDonViewModel list : lists) {
            System.out.println(list.toString());
        }
    }
}
