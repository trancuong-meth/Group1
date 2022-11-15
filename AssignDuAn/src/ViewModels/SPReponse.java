/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author sangh
 */
public class SPReponse {
    private String ma;
    private String ten;
    private int namBH;
    private String moTa;
    private int soLuongSP;
    private double giaNhap;
    private double giaBan;
    private String mau;
    private String dongSp;
    private String nSx;

    public SPReponse() {
    }

    public SPReponse(String ma, String ten, int namBH, String moTa, int soLuongSP, double giaNhap, double giaBan, String mau, String dongSp, String nSx) {
        this.ma = ma;
        this.ten = ten;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongSP = soLuongSP;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.mau = mau;
        this.dongSp = dongSp;
        this.nSx = nSx;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
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

    public int getSoLuongSP() {
        return soLuongSP;
    }

    public void setSoLuongSP(int soLuongSP) {
        this.soLuongSP = soLuongSP;
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

    public String getMau() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }

    public String getDongSp() {
        return dongSp;
    }

    public void setDongSp(String dongSp) {
        this.dongSp = dongSp;
    }

    public String getnSx() {
        return nSx;
    }

    public void setnSx(String nSx) {
        this.nSx = nSx;
    }

    

    
    
    
}
