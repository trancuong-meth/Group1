/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModels.NhaSanXuat;
import java.util.List;

/**
 *
 * @author sangh
 */
public interface NhaSanXuatService {
    List<NhaSanXuat> getAll();

    String add(NhaSanXuat nsx);
}
