/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLB_DoUong.Repositories;

import QLB_DoUong.DomainModels.HoaDon;
import QLB_DoUong.Utilities.DBConnection;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author DELL
 */
public class HoaDonRepository {
private DBConnection connection;
    public ArrayList<HoaDon> getList() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Boolean add(HoaDon hoaDon) {
        String sql ="insert into HoaDon(MaHoaDon,NgayTao,NgayThanhToan,TinhTrang,IdNhanVien,IdKhuyenMai) values (?,?,?,?,?,?)";
        try (Connection con = connection.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, hoaDon.getMaHoaDon());
            pst.setDate(2, hoaDon.getNgayTao());
            pst.setDate(3, hoaDon.getNgayThanhToan());
            pst.setInt(4, hoaDon.getTinhTrang());
            pst.setString(5, hoaDon.getNhanVien().getId());
            pst.setString(6, hoaDon.getKhuyenMai().getId());
            pst.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return false;
        }
        return true;
    }

    public Boolean update(HoaDon hoaDon, String ma) {
         String sql ="update HoaDon set NgayThanhToan = ? ,TinhTrang = ? where MaHoaDon= ? ";
        try (Connection con = connection.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setDate(1, hoaDon.getNgayThanhToan());
           pst.setInt(2, hoaDon.getTinhTrang());
           pst.setString(3, ma);
            pst.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return false;
        }
        return true;
    }

    

    public ArrayList<HoaDon> timKiem(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
