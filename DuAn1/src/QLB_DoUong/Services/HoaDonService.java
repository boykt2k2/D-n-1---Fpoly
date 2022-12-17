/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package QLB_DoUong.Services;

import QLB_DoUong.DomainModels.HoaDon;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public interface HoaDonService {
    public ArrayList<HoaDon> getList();
    public Boolean add(HoaDon hoaDon);
    
    public Boolean update(HoaDon hoaDon, String ma);
   
    public ArrayList<HoaDon> timKiem(String ma);
}
