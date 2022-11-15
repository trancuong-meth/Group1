/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author huyxo
 */
public class ChucVu {
    private String idCH , maCV , tenCV;

    public ChucVu() {
    }

    public ChucVu(String idCH, String maCV, String tenCV) {
        this.idCH = idCH;
        this.maCV = maCV;
        this.tenCV = tenCV;
    }

    public ChucVu(String tenCV) {
        this.tenCV = tenCV;
    }

    public String getIdCH() {
        return idCH;
    }

    public void setIdCH(String idCH) {
        this.idCH = idCH;
    }

    public String getMaCV() {
        return maCV;
    }

    public void setMaCV(String maCV) {
        this.maCV = maCV;
    }

    public String getTenCV() {
        return tenCV;
    }

    public void setTenCV(String tenCV) {
        this.tenCV = tenCV;
    }

    @Override
    public String toString() {
        return idCH;
    }
    
}
