/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author huyxo
 */
public class NhanVien {
    private String idNV;
    private String maNV;
    private String tenNV;
    private String gioiTinh;
    private String ngaySinh;
    private String diaChi;
    private String sdt;
    private String matKhau;
    private ChucVu idCV;
    private CuaHang idCH;
    private int trangThai;

    public NhanVien() {
    }

    public NhanVien(String maNV, String tenNV, String gioiTinh, String ngaySinh, String diaChi, String sdt, String matKhau, ChucVu idCV, CuaHang idCH, int trangThai) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.matKhau = matKhau;
        this.idCV = idCV;
        this.idCH = idCH;
        this.trangThai = trangThai;
    }


    public NhanVien(String idNV, String tenNV) {
        this.idNV = idNV;
        this.tenNV = tenNV;
    }

    public NhanVien(String tenNV) {
        this.tenNV = tenNV;
    }


    public String getIdNV() {
        return idNV;
    }

    public void setIdNV(String idNV) {
        this.idNV = idNV;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
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

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public ChucVu getIdCV() {
        return idCV;
    }

    public void setIdCV(ChucVu idCV) {
        this.idCV = idCV;
    }

    public CuaHang getIdCH() {
        return idCH;
    }

    public void setIdCH(CuaHang idCH) {
        this.idCH = idCH;
    }
    public Object[] getDataNV(){
        return new Object[]{maNV , tenNV , gioiTinh , ngaySinh , diaChi , sdt , matKhau,idCV.getTenCV() , idCH.getTenCH() , trangThai == 1?"Hoạt động":"Không hoạt động"};
    }
    
}
