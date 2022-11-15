/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author sangh
 */
public class KhachHangViewModel {
    private String Ma;
    private String HoTen;
    private String NgaySinh;
    private String Sdt;
    private String DiaChi;

    public KhachHangViewModel() {
    }

    public KhachHangViewModel(String Ma, String HoTen, String NgaySinh, String Sdt, String DiaChi) {
        this.Ma = Ma;
        this.HoTen = HoTen;
        this.NgaySinh = NgaySinh;
        this.Sdt = Sdt;
        this.DiaChi = DiaChi;
    }

    

    public String getMa() {
        return Ma;
    }

    public void setMa(String Ma) {
        this.Ma = Ma;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }
    
    
}
