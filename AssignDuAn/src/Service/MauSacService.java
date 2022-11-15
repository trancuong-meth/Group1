/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModels.MauSac;
import java.util.List;

/**
 *
 * @author sangh
 */
public interface MauSacService {
    List<MauSac> getAll();

    String add(MauSac ms);
}
