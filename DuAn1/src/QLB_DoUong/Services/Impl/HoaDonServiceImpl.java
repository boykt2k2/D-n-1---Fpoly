/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLB_DoUong.Services.Impl;

import QLB_DoUong.DomainModels.HoaDon;
import QLB_DoUong.Repositories.HoaDonRepository;
import QLB_DoUong.Services.HoaDonService;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class HoaDonServiceImpl implements HoaDonService{
private HoaDonRepository hoaDonRepository = new HoaDonRepository();

    @Override
    public ArrayList<HoaDon> getList() {
        return hoaDonRepository.getList();
    }

    @Override
    public Boolean add(HoaDon hoaDon) {
        return hoaDonRepository.add(hoaDon);
    }

    @Override
    public Boolean update(HoaDon hoaDon, String ma) {
        return hoaDonRepository.update(hoaDon,ma);
    }

   

    @Override
    public ArrayList<HoaDon> timKiem(String ma) {
        return hoaDonRepository.timKiem(ma);
    }
    
}
