/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import java.util.List;
import DomainModels.NhaSanXuat;
import Repository.NhaSanXuatRepository;
import Service.NhaSanXuatService;

/**
 *
 * @author NGUYEN THANH HUNG
 */
public class NhaSanXuatServiceImplement implements NhaSanXuatService {

    NhaSanXuatRepository nhaSX = new NhaSanXuatRepository();

    @Override
    public List<NhaSanXuat> getAll() {
        return nhaSX.getList();
    }

    @Override
    public String add(NhaSanXuat nsx) {
        boolean add = nhaSX.add(nsx);
        if (add) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

}
