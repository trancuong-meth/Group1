/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author sangh
 */
public class testt {
    private String id;
    private int namBh;
    private String moTa;
    private int sLton;
    private double  giaNhap;

    public testt() {
    }

    public testt(String id, int namBh, String moTa, int sLton, double giaNhap) {
        this.id = id;
        this.namBh = namBh;
        this.moTa = moTa;
        this.sLton = sLton;
        this.giaNhap = giaNhap;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNamBh() {
        return namBh;
    }

    public void setNamBh(int namBh) {
        this.namBh = namBh;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getsLton() {
        return sLton;
    }

    public void setsLton(int sLton) {
        this.sLton = sLton;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    
}
