/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;
import DomainModels.NhaSanXuat;
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
public class NhaSanXuatRepository {
    private String Select_All = "Select * From NSX";
    private String Insert = "Insert into NSX (MA,TEN) values(?,?)";
    private String Update = "Update NSX Set MA=?,TEN=? Where ID=?";
    private String Delete = "Delete from NSX Where ID=?";
    
    public ArrayList<NhaSanXuat> getList(){
        ArrayList<NhaSanXuat> listNSX = new ArrayList<>();
        try {
            Connection con = (Connection) DBConnect.getDatabaseConnection();
            PreparedStatement ps = con.prepareStatement(Select_All);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()){
                NhaSanXuat nhaSanXuat = new NhaSanXuat();
                nhaSanXuat.setId(rs.getString(1));
                nhaSanXuat.setMa(rs.getString(2));
                nhaSanXuat.setTen(rs.getString(3));
                listNSX.add(nhaSanXuat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listNSX;
    }
    public boolean add(NhaSanXuat nsx) {
        String query = "INSERT INTO [dbo].[NSX]\n"
                + "           ([Ma]\n"
                + "           ,[Ten])\n"
                + "     VALUES(?,?)";
        int check = 0;
        try ( Connection con = DBConnect.getDatabaseConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, nsx.getMa());
            ps.setObject(2, nsx.getTen());
            check = ps.executeUpdate();
            System.out.println("Thành công");
        } catch (SQLException e) {
            System.out.println("Thất bại");
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    public void update(NhaSanXuat nhaSanXuat, String Id){
        try {
            Connection con = DBConnect.getDatabaseConnection();
            PreparedStatement ps = con.prepareStatement(Update);
            ps.setString(1, nhaSanXuat.getMa());
            ps.setString(2, nhaSanXuat.getTen());
            ps.setString(3, nhaSanXuat.getId());
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
