/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import java.util.List;
import DomainModels.SanPham;
import Repository.SanPhamRepository;
import Service.SanPhamService;

/**
 *
 * @author NGUYEN THANH HUNG
 */
public class SanPhamServiceImplement implements SanPhamService {

    SanPhamRepository sanPham = new SanPhamRepository();

    @Override
    public List<SanPham> getAll() {
        return sanPham.getList();
    }

    @Override
    public String add(SanPham sp) {
        boolean add = sanPham.add(sp);
        if (add) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

}
