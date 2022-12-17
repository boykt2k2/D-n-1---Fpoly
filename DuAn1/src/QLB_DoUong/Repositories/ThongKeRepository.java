/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLB_DoUong.Repositories;

import QLB_DoUong.DomainModels.DanhMuc;
import QLB_DoUong.DomainModels.Thongke;
import QLB_DoUong.DomainModels.Size;
import QLB_DoUong.Utilities.DBConnection;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author OSC
 */
public class ThongKeRepository {

    private DBConnection dbConnect;

    public List<Thongke> getList() {
        List<Thongke> list = new ArrayList<>();
        String sql = "select DoUong.Id, DoUong.MaDoUong, DoUong.TenDoUong, DoUong.DonGia,DoUong.TrangThai, DanhMuc.TenDanhMuc,Size.TenSize\n"
                + "from DoUong \n"
                + "join DanhMuc on DoUong.IdDanhMuc = DanhMuc.Id\n"
                + "join Size on DoUong.IdSize = Size.Id";
        try ( Connection con = dbConnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Thongke du = new Thongke();
                du.setId(rs.getString(1));
                du.setMaDoUong(rs.getString(2));
                du.setTenDoUong(rs.getString(3));
                du.setDonGia(rs.getFloat(4));
                du.setTrangThai(rs.getInt(5));
                DanhMuc danhMuc = new DanhMuc();
                danhMuc.setTenDanhMuc(rs.getString(6));
                Size size = new Size();
                size.setTenSize(rs.getString(7));
                du.setDanhMuc(danhMuc);
                du.setSize(size);

                list.add(du);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Thongke> timKiem(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
