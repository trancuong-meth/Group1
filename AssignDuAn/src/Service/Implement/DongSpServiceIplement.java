/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import DomainModels.DongSanPham;
import Repository.DongSanPhamRepository;
import Service.DongSpService;
import java.util.List;

/**
 *
 * @author sangh
 */
public class DongSpServiceIplement implements DongSpService{
    DongSanPhamRepository dongSP = new DongSanPhamRepository();

    @Override
    public List<DongSanPham> getAll() {
        return dongSP.getList();
    }

    @Override
    public String add(DongSanPham dsp) {
        boolean add = dongSP.add(dsp);
        if (add) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }
}
