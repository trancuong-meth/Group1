/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author sangh
 */
public class MauSac {
    private String id;
    private String maMau;
    private String tenMau;

    public MauSac() {
    }

    public MauSac(String id, String maMau, String tenMau) {
        this.id = id;
        this.maMau = maMau;
        this.tenMau = tenMau;
    }

    public MauSac(String maMau, String tenMau) {
        this.maMau = maMau;
        this.tenMau = tenMau;
    }

    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaMau() {
        return maMau;
    }

    public void setMaMau(String maMau) {
        this.maMau = maMau;
    }

    public String getTenMau() {
        return tenMau;
    }

    public void setTenMau(String tenMau) {
        this.tenMau = tenMau;
    }

    
}
