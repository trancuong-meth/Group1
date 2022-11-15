/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModels.KhachHang;
import ViewModels.KhachHangViewModel;
import java.util.List;

/**
 *
 * @author sangh
 */
public interface KhachHangService {
    List<KhachHangViewModel> getAll();

    String add(KhachHang khachHang);

    String update(KhachHang khachHang, String id);

    String delete(String id);

    List<KhachHang> searchByName(String tenSP);
}
