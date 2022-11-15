/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;
import DomainModels.MauSac;
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
public class MauRepository {
    private String Select_All = "Select * From MauSac";
    private String Insert = "Insert into MauSac (MA,TEN) values(?,?)";
    private String Update = "Update MauSac Set MA=?,TEN=? Where ID=?";
    private String Delete = "Delete from MauSac Where ID=?";
    
    public ArrayList<MauSac> getList(){
        ArrayList<MauSac> listMauSac = new ArrayList<>();
        try {
            Connection con = (Connection) DBConnect.getDatabaseConnection();
            PreparedStatement ps = con.prepareStatement(Select_All);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()){
                MauSac mauSac = new MauSac();
                mauSac.setId(rs.getString(1));
                mauSac.setMaMau(rs.getString(2));
                mauSac.setTenMau(rs.getString(3));
                listMauSac.add(mauSac);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listMauSac;
    }
    public boolean add(MauSac ms) {
        String query = "INSERT INTO [dbo].[MauSac]\n"
                + "           ([Ma]\n"
                + "           ,[Ten])\n"
                + "     VALUES(?,?)";
        int check = 0;
        try ( Connection con = DBConnect.getDatabaseConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ms.getMaMau());
            ps.setObject(2, ms.getTenMau());
            check = ps.executeUpdate();
            System.out.println("Thành công");
        } catch (SQLException e) {
            System.out.println("Thất bại");
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    public void update(MauSac mauSac, String Id){
        try {
            Connection con = DBConnect.getDatabaseConnection();
            PreparedStatement ps = con.prepareStatement(Update);
            ps.setString(1, mauSac.getMaMau());
            ps.setString(2, mauSac.getTenMau());
            ps.setString(3, mauSac.getId());
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
