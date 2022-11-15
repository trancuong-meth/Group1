/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import DomainModels.ChucVu;
import DomainModels.CuaHang;
import DomainModels.NhanVien;
import java.util.List;
import Repository.NhanVienRepository;
import Service.NhanVienService;

/**
 *
 * @author huyxo
 */
public class NhanVienServiceIplement implements NhanVienService{

    NhanVienRepository repo = new NhanVienRepository();
    @Override
    public List<NhanVien> getALLNV() {
        return repo.getNV();
    }

    @Override
    public List<ChucVu> getALLCV() {
        return repo.getCV();
    }

    @Override
    public List<CuaHang> getALLCH() {
        return repo.getCH();
    }

    @Override
    public String insertNV(NhanVien nv) {
        return repo.insert(nv);        
    }

    @Override
    public String updateNV(NhanVien nv) {
        return repo.update(nv);
    }

    @Override
    public String deleteNV(NhanVien nv) {
        return repo.delete(nv);
    }
    
}
