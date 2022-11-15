/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.Base64;
import javax.swing.JOptionPane;
import model.LoginResult;
import model.User;
import repository.UserRepository;
import view.QULSV;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.LOGIN;
import view.QLSV;

/**
 *
 * @author sangh
 */
public class UserService {

    private final UserRepository userRepository;

    public UserService() {
        userRepository = new UserRepository();
    }

    public LoginResult doLogin(String username, String password) {
        LoginResult result = new LoginResult();
        try {
            User user = userRepository.getUserByUserName(username);
            String base64Password = Base64.getEncoder().encodeToString(password.getBytes());
            if (user.getUsername() != null) {
                if (user.getUsername().equals(username)
                        && user.getPassword().equals(base64Password)) {
                    result.setStatus(Boolean.TRUE);
                    LOGIN login = new LOGIN();
                    login.setVisible(false);
                    result.setMessage("Đăng nhập thành công");
                    if (user.getRole().equals("staff")) {
                        login.setVisible(false);
                        QLSV qlsv = new QLSV();
                        qlsv.setVisible(true);
                    } else {
                        login.setVisible(false);
                        QULSV qulsv = new QULSV();
                        qulsv.setVisible(true);
                    }

                } else {
                    result.setStatus(Boolean.FALSE);
                    result.setMessage("Mật khẩu không đúng");
                }
            } else {
                result.setStatus(Boolean.FALSE);
                result.setMessage("Không tìm thấy thông tin tài khoản");
            }
        } catch (SQLException ex) {
            result.setStatus(Boolean.FALSE);
            result.setMessage("Đã xảy ra lỗi");
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
