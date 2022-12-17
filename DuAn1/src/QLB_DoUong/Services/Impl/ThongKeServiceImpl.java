/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLB_DoUong.Services.Impl;

import QLB_DoUong.DomainModels.Thongke;
import QLB_DoUong.Repositories.ThongKeRepository;
import java.util.List;
import QLB_DoUong.Services.ThongKeService;

/**
 *
 * @author OSC
 */
public class ThongKeServiceImpl implements ThongKeService{
private ThongKeRepository doUongRepository=new ThongKeRepository();
    @Override
    public List<Thongke> getList() {
        return doUongRepository.getList();
    }

    @Override
    public List<Thongke> timKiem(String ma) {
        return doUongRepository.timKiem(ma);
    }
    
}
