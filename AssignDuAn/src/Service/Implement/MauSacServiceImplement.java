/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import java.util.List;
import DomainModels.MauSac;
import Repository.MauRepository;
import Service.MauSacService;

/**
 *
 * @author NGUYEN THANH HUNG
 */
public class MauSacServiceImplement implements MauSacService {

    MauRepository mauSac = new MauRepository();

    @Override
    public List<MauSac> getAll() {
        return mauSac.getList();
    }

    @Override
    public String add(MauSac ms) {
        boolean add = mauSac.add(ms);
        if (add) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

}
