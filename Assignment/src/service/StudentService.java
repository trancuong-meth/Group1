/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.awt.Color;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.Utilities;
import javax.xml.validation.Validator;
import model.Student;
import repository.StudentRepository;
import untility.Untilities;
import view.QLSV;
import view.QULSV;

/**
 *
 * @author sangh
 */
public class StudentService {

    StudentRepository studentRepository = new StudentRepository();

    public StudentService() {
        this.studentRepository = new StudentRepository();
    }

    public List<Student> getListStudent() {
        return studentRepository.getListStudent();
    }

    public void addStu(Student student) {
        boolean isExists = studentRepository.isExists(student.getStudentId());
        if (!student.getStudentId().startsWith("sv")) {
            throw new RuntimeException("Mã sinh viên phải bắt đầu bằng SV");
        } else {
            if (isExists) {
                throw new RuntimeException("Mã sinh viên đã tồn tại");
            } else {
                boolean isValidEmail = Untilities.validateEmail(student.getEmail());
                boolean isValidPhoneNumber = Untilities.validatePhoneNumber(student.getPhoneNumber());
                boolean isValidName = Untilities.validateName(student.getStudentName());
                if(!isValidName){
                    throw new RuntimeException("Tên không được chứa số");
                }
                if (!isValidEmail) {
                    throw new RuntimeException("Địa chỉ email không đúng định dạng");
                }
                if (!isValidPhoneNumber) {
                    throw new RuntimeException("Số điện thoại không đúng định dạng");
                }
                // Validate số điện thoại phải là số
                studentRepository.addStudent(student);
            }
        }
        studentRepository.addStudent(student);

    }

    public int updateStudent(Student student) {
        return studentRepository.updateStudent(student);
    }

    public int deleteStudent(String masv) {
        return studentRepository.deleteStudent(masv);
    }

//    public static boolean isEmpty(JTextField txtField, StringBuilder str, String msg) {
//        String strField = txtField.getText().trim();
//        if (strField.equals("")) {
//            str.append(msg).append("\n");
////            txtField.setBackground(Color.red);
//            return false;
//        }
////        txtField.setBackground(Color.white);
//        return true;
//    }
}
