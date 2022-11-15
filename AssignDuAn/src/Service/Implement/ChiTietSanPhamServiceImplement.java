/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import java.util.List;
import DomainModels.ChiTietSanPham;
import Repository.SPCTRepository;
import Service.SpctService;
import ViewModels.testt;

/**
 *
 * @author NGUYEN THANH HUNG
 */
public class ChiTietSanPhamServiceImplement implements SpctService {

    SPCTRepository chiTietSP = new SPCTRepository();

    @Override
    public List<testt> getAll() {
        return chiTietSP.getAll();
    }

    @Override
    public String add(ChiTietSanPham ctsp) {
        boolean add = chiTietSP.add(ctsp);
        if (add) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";

        }
    }

    @Override
    public String update(ChiTietSanPham ctsp, String id) {
        boolean update = chiTietSP.update(ctsp, id);
        if (update) {
            return "Update thành công";
        } else {
            return "Update thất bại";

        }
    }

    @Override
    public String delete(String id) {
        boolean delete = chiTietSP.delete(id);
        if (delete) {
            return "Delete thành công";
        } else {
            return "Delete thất bại";
        }
    }

    @Override
    public List<ChiTietSanPham> searchByName(String tenSP) {
        return chiTietSP.searchByName(tenSP);
    }

    

}
