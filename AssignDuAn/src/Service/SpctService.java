/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModels.ChiTietSanPham;
import ViewModels.testt;
import java.util.List;

/**
 *
 * @author sangh
 */
public interface SpctService {

    List<testt> getAll();

    String add(ChiTietSanPham spct);

    String update(ChiTietSanPham spct, String id);

    String delete(String id);

    List<ChiTietSanPham> searchByName(String tenSP);
}
