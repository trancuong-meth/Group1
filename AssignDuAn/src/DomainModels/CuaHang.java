/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author huyxo
 */
public class CuaHang {
        private String idCH , maCH , tenCH;

    public CuaHang() {
    }

    public CuaHang(String idCH, String maCH, String tenCH) {
        this.idCH = idCH;
        this.maCH = maCH;
        this.tenCH = tenCH;
    }

    public CuaHang(String tenCH) {
        this.tenCH = tenCH;
    }

    public String getIdCH() {
        return idCH;
    }

    public void setIdCH(String idCH) {
        this.idCH = idCH;
    }

    public String getMaCH() {
        return maCH;
    }

    public void setMaCH(String maCH) {
        this.maCH = maCH;
    }

    public String getTenCH() {
        return tenCH;
    }

    public void setTenCH(String tenCH) {
        this.tenCH = tenCH;
    }

    @Override
    public String toString() {
        return idCH;
    }      
}
