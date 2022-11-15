/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author NGUYEN THANH HUNG
 */
public class ChiTietSanPham {

    private String id;
    private SanPham idsp;
    private NhaSanXuat idNSX;
    private MauSac idMS;
    private DongSanPham idDSP;
    private int namBH;
    private String moTa;
    private int soLuong;
    private double giaNhap;
    private double giaBan;

    public ChiTietSanPham() {
    }
    
    public ChiTietSanPham(String id, SanPham idsp, NhaSanXuat idNSX, MauSac idMS, DongSanPham idDSP, int namBH, String moTa, int soLuong, double giaNhap, double giaBan) {
        this.id = id;
        this.idsp = idsp;
        this.idNSX = idNSX;
        this.idMS = idMS;
        this.idDSP = idDSP;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuong = soLuong;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }
    
    
    public ChiTietSanPham(SanPham idsp, NhaSanXuat idNSX, MauSac idMS, DongSanPham idDSP, int namBH, String moTa, int soLuong, double giaNhap, double giaBan) {
        this.idsp = idsp;
        this.idNSX = idNSX;
        this.idMS = idMS;
        this.idDSP = idDSP;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuong = soLuong;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public ChiTietSanPham(SanPham idsp, int namBH, String moTa, int soLuong, double giaNhap, double giaBan) {
        this.idsp = idsp;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuong = soLuong;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public ChiTietSanPham(String id, SanPham idsp, int namBH, String moTa, int soLuong, double giaNhap, double giaBan) {
        this.id = id;
        this.idsp = idsp;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuong = soLuong;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public ChiTietSanPham(NhaSanXuat idNSX, MauSac idMS, DongSanPham idDSP, int namBH, String moTa, int soLuong, double giaNhap, double giaBan) {
        this.idNSX = idNSX;
        this.idMS = idMS;
        this.idDSP = idDSP;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuong = soLuong;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SanPham getIdsp() {
        return idsp;
    }

    public void setIdsp(SanPham idsp) {
        this.idsp = idsp;
    }

    public NhaSanXuat getIdNSX() {
        return idNSX;
    }

    public void setIdNSX(NhaSanXuat idNSX) {
        this.idNSX = idNSX;
    }

    public MauSac getIdMS() {
        return idMS;
    }

    public void setIdMS(MauSac idMS) {
        this.idMS = idMS;
    }

    public DongSanPham getIdDSP() {
        return idDSP;
    }

    public void setIdDSP(DongSanPham idDSP) {
        this.idDSP = idDSP;
    }

    public int getNamBH() {
        return namBH;
    }

    public void setNamBH(int namBH) {
        this.namBH = namBH;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    @Override
    public String toString() {
        return "ChiTietSanPham{" + "id=" + id + ", idsp=" + idsp + ", idNSX=" + idNSX + ", idMS=" + idMS + ", idDSP=" + idDSP + ", namBH=" + namBH + ", moTa=" + moTa + ", soLuong=" + soLuong + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + '}';
    }


}
