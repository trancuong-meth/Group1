/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import DomainModels.KhachHang;
import Repository.KhachHangRepository;
import Service.KhachHangService;
import Untility.Untilities;
import ViewModels.KhachHangViewModel;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author sangh
 */
public class KhachHangImplement implements KhachHangService{
    private KhachHangRepository khachHangRepository = new KhachHangRepository();

    @Override
    public List<KhachHangViewModel> getAll() {
        return khachHangRepository.getKH();
    }

    @Override
    public String add(KhachHang khachHang) {
                boolean isValidPhoneNumber = Untilities.validatePhoneNumber(khachHang.getSdt());
                boolean isValidName = Untilities.validateName(khachHang.getTenKH());
                boolean isPass = Untilities.validatePass(khachHang.getMatKhau());
                if(!isValidName){
                    JOptionPane.showMessageDialog(null,"Tên không được chứa số");
                }
                if (!isValidPhoneNumber && khachHang.getSdt().startsWith("0")) {
                    JOptionPane.showMessageDialog(null,"Số điện thoại không đúng định dạng");
                }
                if(!isPass){
                    JOptionPane.showMessageDialog(null,"Mật khẩu không đúng định dạng");
                }
                return khachHangRepository.insert(khachHang);
    }

    @Override
    public String update(KhachHang khachHang, String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<KhachHang> searchByName(String tenSP) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
