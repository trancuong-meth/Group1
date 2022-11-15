/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author sangh
 */
public class Grade {

    private String ten;
    private String ID;
    private String StudentId;
    private double anhVan;
    private double tinHoc;
    private double GDTC;
    private double DTB;

    public Grade() {
    }

    public Grade(String ten, String ID, String StudentId, double anhVan, double tinHoc, double GDTC, double DTB) {
        this.ten = ten;
        this.ID = ID;
        this.StudentId = StudentId;
        this.anhVan = anhVan;
        this.tinHoc = tinHoc;
        this.GDTC = GDTC;
        this.DTB = DTB;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getStudentId() {
        return StudentId;
    }

    public void setStudentId(String StudentId) {
        this.StudentId = StudentId;
    }

    public double getAnhVan() {
        return anhVan;
    }

    public void setAnhVan(double anhVan) {
        this.anhVan = anhVan;
    }

    public double getTinHoc() {
        return tinHoc;
    }

    public void setTinHoc(double tinHoc) {
        this.tinHoc = tinHoc;
    }

    public double getGDTC() {
        return GDTC;
    }

    public void setGDTC(double GDTC) {
        this.GDTC = GDTC;
    }

    public double getDTB() {
        double dtb = (anhVan + tinHoc + GDTC) / 3;
        String dt = String.format("%.2f", dtb);
        return dtb;
    }

    public double setDTB(double DTB) {
        return DTB;
    }

}
