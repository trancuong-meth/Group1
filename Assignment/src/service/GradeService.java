/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.Collections;
import static java.util.Collections.list;
import java.util.Comparator;
import java.util.List;
import model.Grade;
import model.Student;
import repository.GradeRepository;
import untility.Untilities;

/**
 *
 * @author sangh
 */
public class GradeService {
    GradeRepository gradeRepository = new GradeRepository();

    public GradeService() {
        this.gradeRepository = new GradeRepository();
    }
    public List<Grade> getList() {
        return gradeRepository.getListGrade();
    }
    public List<Grade> searchGrade(String masv){
        return gradeRepository.searchGrade(masv);
    }
    public void addGrade(Grade grade) {
        boolean isExists = gradeRepository.isExists(grade.getStudentId());
        if (!grade.getStudentId().startsWith("sv")) {
            throw new RuntimeException("Mã sinh viên phải bắt đầu bằng sv");
        } else {
            if (isExists) {
                throw new RuntimeException("Mã sinh viên đã tồn tại");
            } else {
                if(grade.getAnhVan()>=0&&grade.getAnhVan()<=10
                        &&grade.getTinHoc()>=0&&grade.getTinHoc()<=10
                        &&grade.getGDTC()>=0&&grade.getGDTC()<=10){
                    gradeRepository.addGrade(grade);
                }else{
                    throw new RuntimeException("Điểm trong khoảng 0 đến 10.");
                }  
            }
        }
    }
    public int deleteGrade(String masv){
        return gradeRepository.deleteGrade(masv);
    }
    public int updateGrade(Grade grade){
       return gradeRepository.updateGrade(grade);
    }
    
}
