/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModels.HoaDon;
import java.util.List;

/**
 *
 * @author huyxo
 */
public interface ThanhToanService {
    
    
    List<HoaDon> getAllHD();
    
    String getALLMaHD(String hd);
    
    String addHD(HoaDon hd);
    
    
    
}
