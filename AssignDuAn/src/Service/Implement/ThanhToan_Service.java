/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import DomainModels.HoaDon;
import java.util.List;
import Repository.ThanhToanRepository;
import Service.ThanhToanService;

/**
 *
 * @author huyxo
 */
public class ThanhToan_Service implements ThanhToanService{

    ThanhToanRepository repo;

    public ThanhToan_Service() {
        repo = new ThanhToanRepository();
    }

    @Override
    public List<HoaDon> getAllHD() {
        return repo.getHD();
    }

    @Override
    public String getALLMaHD(String hd) {
        return repo.getMaHD(hd);
    }

    @Override
    public String addHD(HoaDon hd) {
        return repo.insert(hd);
    }

}
