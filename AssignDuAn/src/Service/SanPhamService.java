/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModels.SanPham;
import java.util.List;

/**
 *
 * @author sangh
 */
public interface SanPhamService {
    List<SanPham> getAll();

    String add(SanPham sp);
}
