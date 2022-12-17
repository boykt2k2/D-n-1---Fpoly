/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package QLB_DoUong.Views;

import QLB_DoUong.DomainModels.KhuyenMai;
import QLB_DoUong.Services.BanHangService;
import QLB_DoUong.Services.Impl.BanHangServiceImpl;
import QLB_DoUong.Services.Impl.KhuyenMaiServiceImpl;
import QLB_DoUong.Services.KhuyenMaiService;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author THUONG DINH
 */
public class FormKhuyenMai extends javax.swing.JPanel {

    public KhuyenMaiService khuyenMaiService = new KhuyenMaiServiceImpl();
private BanHangService banHangService = new BanHangServiceImpl();
    /**
     * Creates new form FormKhuyenMai
     */
    public FormKhuyenMai() {
        initComponents();
        loadData(khuyenMaiService.getList());
        tinhTrang();
        tinhTrang1();
        JOptionPane.showMessageDialog(this, "Cập nhật thành công ");
    }

    public void loadData(ArrayList<KhuyenMai> list) {
        DefaultTableModel dtm = (DefaultTableModel) tblKhuyenMai.getModel();
        dtm.setRowCount(0);
        for (KhuyenMai khuyenMai : list) {
            Object[] rowData = new Object[]{
                khuyenMai.getId(),
                khuyenMai.getMaKhuyenMai(),
                khuyenMai.getPhamTramKhuyenMai(),
                khuyenMai.getNgayBatDau(),
                khuyenMai.getNgayKetThuc(),
                khuyenMai.getTrangThai() == 1 ? "Đang khuyến mãi" : "Hết khuyến mãi",};

            dtm.addRow(rowData);

        }

    }

    private void tinhTrang() {
        ArrayList<Date> ngayBatDau = khuyenMaiService.ngayBatDau();
        ArrayList<Date> ngayKetThuc = khuyenMaiService.ngayKetThuc();
        Date ngayTao = genNgay();
        ArrayList<KhuyenMai> list = khuyenMaiService.loc(ngayTao);
        loadData(list);
        for (KhuyenMai khuyenMai : list) {
            khuyenMai.setNgayBatDau(khuyenMai.getNgayBatDau());
            khuyenMai.setNgayKetThuc(khuyenMai.getNgayKetThuc());
            khuyenMai.setTrangThai(1);
            if (khuyenMaiService.updateTinhTrang(khuyenMai, khuyenMai.getNgayBatDau(), khuyenMai.getNgayKetThuc())) {
                loadData(khuyenMaiService.getList());
                clearForm();
            }
        }
        

    }
     private void tinhTrang1() {
        ArrayList<Date> ngayBatDau = khuyenMaiService.ngayBatDau();
        ArrayList<Date> ngayKetThuc = khuyenMaiService.ngayKetThuc();
        Date ngayTao = genNgay();
        ArrayList<KhuyenMai> list = khuyenMaiService.loc1(ngayTao);
        loadData(list);
        for (KhuyenMai khuyenMai : list) {
            khuyenMai.setNgayBatDau(khuyenMai.getNgayBatDau());
            khuyenMai.setNgayKetThuc(khuyenMai.getNgayKetThuc());
            khuyenMai.setTrangThai(0);
            if (khuyenMaiService.updateTinhTrang(khuyenMai, khuyenMai.getNgayBatDau(), khuyenMai.getNgayKetThuc())) {
                loadData(khuyenMaiService.getList());
                clearForm();
            }
        }

    }
     
    private void clearForm() {
        txtmaKM.setText("");
        txtid.setText("");
        lblTrangThai.setText("");
        txtphantramKM.setText("");
        txtNgayBatDau.setText("");
        txtNgayKetThuc.setText("");
    }

    private KhuyenMai getFormData() {
        String maKM = txtmaKM.getText();
        String PhanTramKM = txtphantramKM.getText();
        Date date = null;
        Date date1 = null;
        String ngayBatDau = txtNgayBatDau.getText();
        String ngayKetThuc = txtNgayKetThuc.getText();
        int trangThai = 0;
        if (maKM.trim().length() == 0
                || PhanTramKM.trim().length() == 0
                || ngayBatDau.trim().length() == 0
                || ngayKetThuc.trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được bỏ trống");
            return null;
        }
        try {
            date = Date.valueOf(ngayBatDau);
            date1 = Date.valueOf(ngayKetThuc);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Không đúng định dạng ngày");
            return null;
        }
        if (Date.valueOf(ngayBatDau).before(genNgay()) && genNgay().before(Date.valueOf(ngayKetThuc))) {
            trangThai = 1;
        }
        KhuyenMai khuyenMai = new KhuyenMai();
        khuyenMai.setMaKhuyenMai(maKM);
        khuyenMai.setPhamTramKhuyenMai(Float.parseFloat(PhanTramKM));
        khuyenMai.setNgayBatDau(date);
        khuyenMai.setNgayKetThuc(date1);
        khuyenMai.setTrangThai(trangThai);
        return khuyenMai;

    }

    public Date genNgay() {
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        return date;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhuyenMai = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtmaKM = new javax.swing.JTextField();
        btnthem = new javax.swing.JButton();
        txtphantramKM = new javax.swing.JTextField();
        btnsua = new javax.swing.JButton();
        txtNgayBatDau = new javax.swing.JTextField();
        btnxoa = new javax.swing.JButton();
        txtNgayKetThuc = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblTrangThai = new javax.swing.JLabel();

        jPanel1.setPreferredSize(new java.awt.Dimension(1190, 700));

        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });

        jLabel2.setText("Mã KM");

        jLabel7.setText("ID");

        jLabel4.setText("% KM");

        jLabel5.setText("Ngày Bắt Đầu");

        tblKhuyenMai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Mã KM", "Phần trăm KM", "Ngày bắt đầu", "Ngày kết thúc", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhuyenMaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhuyenMai);

        jLabel6.setText("Ngày Kết Thúc");

        btnthem.setText("Thêm");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        txtphantramKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtphantramKMActionPerformed(evt);
            }
        });

        btnsua.setText("Sửa");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        btnxoa.setText("Xóa");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        jButton4.setText("jButton4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setText("Khuyến Mãi");

        jLabel8.setText("Trạng thái");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 984, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(265, 265, 265)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtphantramKM, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtmaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(btnthem)
                        .addGap(82, 82, 82)
                        .addComponent(btnsua, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnxoa)
                        .addGap(64, 64, 64)
                        .addComponent(jButton4)))
                .addContainerGap(194, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtmaKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel8)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtphantramKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(81, 81, 81))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(lblTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(174, 174, 174)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(btnxoa)
                            .addComponent(btnsua)
                            .addComponent(btnthem))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(168, 168, 168))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 55, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        int row = tblKhuyenMai.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần xóa");
            return;
        }
        String id = txtid.getText();
        int confim = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa bản ghi này");
        if (confim == JOptionPane.NO_OPTION) {
            return;
        } else if (confim == JOptionPane.CANCEL_OPTION) {
            return;
        } else {

            if (khuyenMaiService.delete(id)) {
                JOptionPane.showMessageDialog(this, "Xóa thành công");
                loadData(khuyenMaiService.getList());
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }
        }
    }//GEN-LAST:event_btnxoaActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        int row = tblKhuyenMai.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa");
            return;
        }
        KhuyenMai khuyenMai = getFormData();
        if (khuyenMai == null) {
            return;
        }
        String id = txtid.getText();
        if (khuyenMaiService.update(khuyenMai, id)) {
            JOptionPane.showMessageDialog(this, "Sửa thành công");
            loadData(khuyenMaiService.getList());
            clearForm();
        } else {
            JOptionPane.showMessageDialog(this, "Sửa thất bại");
        }
    }//GEN-LAST:event_btnsuaActionPerformed

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        KhuyenMai khuyenMai = getFormData();
        if (khuyenMai == null) {
            return;
        }
        if (khuyenMaiService.addNew(khuyenMai)) {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            loadData(khuyenMaiService.getList());

        } else {
            JOptionPane.showMessageDialog(this, "Thêm Thất Bại");
        }
    }//GEN-LAST:event_btnthemActionPerformed

    private void tblKhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhuyenMaiMouseClicked
        int row = tblKhuyenMai.getSelectedRow();
        if (row == -1) {
            return;
        }
        txtid.setText(tblKhuyenMai.getValueAt(row, 0).toString());
        txtmaKM.setText(tblKhuyenMai.getValueAt(row, 1).toString());
        txtphantramKM.setText(tblKhuyenMai.getValueAt(row, 2).toString());
        txtNgayBatDau.setText(tblKhuyenMai.getValueAt(row, 3).toString());
        txtNgayKetThuc.setText(tblKhuyenMai.getValueAt(row, 4).toString());
        lblTrangThai.setText(tblKhuyenMai.getValueAt(row, 5).toString());
    }//GEN-LAST:event_tblKhuyenMaiMouseClicked

    private void txtphantramKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtphantramKMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtphantramKMActionPerformed

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        clearForm();
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btnxoa;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTrangThai;
    private javax.swing.JTable tblKhuyenMai;
    private javax.swing.JTextField txtNgayBatDau;
    private javax.swing.JTextField txtNgayKetThuc;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtmaKM;
    private javax.swing.JTextField txtphantramKM;
    // End of variables declaration//GEN-END:variables
}
