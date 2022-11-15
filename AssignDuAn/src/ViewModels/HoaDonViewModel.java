/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import java.util.Date;

/**
 *
 * @author NGUYEN THANH HUNG
 */
public class HoaDonViewModel {

    private String id;
    private String maHD;
    private Date ngayTao;
    private String tenNV;
    private int tinhTrang;

    public HoaDonViewModel() {
    }

    public HoaDonViewModel(String id, String maHD, Date ngayTao, String tenNV, int tinhTrang) {
        this.id = id;
        this.maHD = maHD;
        this.ngayTao = ngayTao;
        this.tenNV = tenNV;
        this.tinhTrang = tinhTrang;
    }

    public HoaDonViewModel(String maHD, Date ngayTao, String tenNV, int tinhTrang) {
        this.maHD = maHD;
        this.ngayTao = ngayTao;
        this.tenNV = tenNV;
        this.tinhTrang = tinhTrang;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public String toString() {
        return "ChiTietHoaDonViewModel{" + "id=" + id + ", maHD=" + maHD + ", ngayTao=" + ngayTao + ", tenNV=" + tenNV + ", tinhTrang=" + tinhTrang + '}';
    }

}
