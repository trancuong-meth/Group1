/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author huyxo
 */
public class HoaDon {

    private int stt;
    private String idHD;
    private String idKH;
    private String maHD;
    private String ngayTao;
    private NhanVien idNV;
    private String ngayThanhToan;
    private String ngayShip;
    private String ngayNhan;
    private int tinhTrang;
    private String diaChi;
    private String sdt;
    private HoaDonChiTiet donGiaa;

    public HoaDon() {
    }

    public HoaDon(int stt, String idHD, String idKH, String maHD, String ngayTao, NhanVien idNV, String ngayThanhToan, String ngayShip, String ngayNhan, int tinhTrang, String diaChi, String sdt, HoaDonChiTiet donGiaa) {
        this.stt = stt;
        this.idHD = idHD;
        this.idKH = idKH;
        this.maHD = maHD;
        this.ngayTao = ngayTao;
        this.idNV = idNV;
        this.ngayThanhToan = ngayThanhToan;
        this.ngayShip = ngayShip;
        this.ngayNhan = ngayNhan;
        this.tinhTrang = tinhTrang;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.donGiaa = donGiaa;
    }

    public HoaDon(int stt, String maHD, String ngayTao, NhanVien idNV, int tinhTrang) {
        this.stt = stt;
        this.maHD = maHD;
        this.ngayTao = ngayTao;
        this.idNV = idNV;
        this.tinhTrang = tinhTrang;
    }
    
    public HoaDon(String maHD, String ngayTao, NhanVien idNV, int tinhTrang, HoaDonChiTiet donGiaa) {
        this.maHD = maHD;
        this.ngayTao = ngayTao;
        this.idNV = idNV;
        this.tinhTrang = tinhTrang;
        this.donGiaa = donGiaa;
    }

    public HoaDon( String maHD, String ngayTao, NhanVien idNV, int tinhTrang) {
        this.maHD = maHD;
        this.ngayTao = ngayTao;
        this.idNV = idNV;
        this.tinhTrang = tinhTrang;
    }

    public HoaDon(String maHD, String ngayTao, int tinhTrang) {
        this.maHD = maHD;
        this.ngayTao = ngayTao;
        this.tinhTrang = tinhTrang;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getIdHD() {
        return idHD;
    }

    public void setIdHD(String idHD) {
        this.idHD = idHD;
    }

    public String getIdKH() {
        return idKH;
    }

    public void setIdKH(String idKH) {
        this.idKH = idKH;
    }

    public NhanVien getIdNV() {
        return idNV;
    }

    public void setIdNV(NhanVien idNV) {
        this.idNV = idNV;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(String ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public String getNgayShip() {
        return ngayShip;
    }

    public void setNgayShip(String ngayShip) {
        this.ngayShip = ngayShip;
    }

    public String getNgayNhan() {
        return ngayNhan;
    }

    public void setNgayNhan(String ngayNhan) {
        this.ngayNhan = ngayNhan;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public HoaDonChiTiet getDonGiaa() {
        return donGiaa;
    }

    public void setDonGiaa(HoaDonChiTiet donGiaa) {
        this.donGiaa = donGiaa;
    }

    public Object[] getDataHD() {
        return new Object[]{stt, maHD, ngayTao, idNV.getTenNV(), tinhTrang == 1 ? "Đã thanh toán" : "Đã hủy", donGiaa};
    }
}
