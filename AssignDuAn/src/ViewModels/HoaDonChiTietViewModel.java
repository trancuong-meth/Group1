/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import DomainModels.SanPham;

/**
 *
 * @author NGUYEN THANH HUNG
 */
public class HoaDonChiTietViewModel {
    private SanPham sp;
    private int soLuong;
    private double donGia;

    public HoaDonChiTietViewModel() {
    }

    public HoaDonChiTietViewModel(SanPham sp, int soLuong, double donGia) {
        this.sp = sp;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public SanPham getSp() {
        return sp;
    }

    public void setSp(SanPham sp) {
        this.sp = sp;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    @Override
    public String toString() {
        return "HoaDonChiTietViewModel{" + "sp=" + sp + ", soLuong=" + soLuong + ", donGia=" + donGia + '}';
    }
    
}
