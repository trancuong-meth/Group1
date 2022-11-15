/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModels.ChucVu;
import DomainModels.CuaHang;
import DomainModels.NhanVien;
import java.util.List;

/**
 *
 * @author huyxo
 */
public interface NhanVienService {
    
    List<NhanVien> getALLNV();
    
    List<ChucVu> getALLCV();
    
    List<CuaHang> getALLCH();
    
    String insertNV(NhanVien nv);
    
    String updateNV(NhanVien nv);
    
    String deleteNV(NhanVien nv);

}
