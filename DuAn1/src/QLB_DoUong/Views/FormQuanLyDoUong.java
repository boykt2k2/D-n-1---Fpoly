/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package QLB_DoUong.Views;

import QLB_DoUong.DomainModels.DanhMuc;
import QLB_DoUong.DomainModels.Size;
import QLB_DoUong.Services.DanhmucSevice;
import QLB_DoUong.Services.DoUongService;
import QLB_DoUong.Services.Impl.DanhmucImpl;
import QLB_DoUong.Services.Impl.DoUongServiceImpl;
import QLB_DoUong.Services.Impl.SizeServiceImpl;
import QLB_DoUong.Services.SizeService;
import QLB_DoUong.ViewModel.DoUongVM;

import java.math.BigDecimal;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author THUONG DINH
 */
public class FormQuanLyDoUong extends javax.swing.JPanel {
    private DefaultTableModel dtm;
    private DoUongService doUongService = new DoUongServiceImpl();
    private DanhmucSevice danhMucService = new DanhmucImpl();
    private SizeService sizeService = new SizeServiceImpl();

    
    public FormQuanLyDoUong() {
        initComponents();
        txtID.setEnabled(false);
        loadTable(doUongService.getList());
        loadCbbKindOfDrink();
        loadCbbSize();
    }
    
    public void loadTable(List<DoUongVM> list) {
        dtm = (DefaultTableModel) tblDrink.getModel();
        dtm.setRowCount(0);
        for (DoUongVM du : list) {
            Object[] row = {
                du.getId(),
                du.getMaDoUong(),
                du.getTenDoUong(),
                du.getDonGia(),
                du.getTrangThai() == 1 ? "Còn" : "Hết",
                du.getDanhMuc(),
                du.getSize(),};
            dtm.addRow(row);
        }
    }
    
    public String kind() {
        if (cbbKind.getSelectedIndex() == 0) {
            return "du.Id";
        } else if (cbbKind.getSelectedIndex() == 1) {
            return "MaDoUong";
        } else {
            return "TenDoUong";
        }
    }
    
    public DoUongVM getData() {
        DoUongVM du = new DoUongVM();
        du.setMaDoUong(txtCode.getText());
        du.setTenDoUong(txtName.getText());
        du.setDonGia(new BigDecimal(txtPrice.getText()));
        if (rdo0.isSelected() == true) {
            du.setTrangThai(0);
        }
        if (rdo1.isSelected() == true) {
            du.setTrangThai(1);
        }
        du.setDanhMuc((DanhMuc)cbbKindOfDrink.getSelectedItem());
        du.setSize((Size)cbbSize.getSelectedItem());
        
        return du;
    }
    
    
    private void loadCbbKindOfDrink() {
        cbbKindOfDrink.removeAllItems();
        List<DanhMuc> listDM = danhMucService.getlist();
        for (DanhMuc dm : listDM) {
            cbbKindOfDrink.addItem(dm);
        }
    }
    
    private void loadCbbSize() {
        cbbSize.removeAllItems();
        List<Size> listSZ = sizeService.getAll();
        for (Size sz : listSZ) {
            cbbSize.addItem(sz);
        }
    }
    
    public void clearForm() {
        txtID.setText("");
        txtCode.setText("");
        txtName.setText("");
        txtPrice.setText("");
        rdo0.setSelected(false);
        rdo1.setSelected(false);
        cbbKindOfDrink.setSelectedIndex(0);
        cbbSize.setSelectedIndex(0);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbbKindOfDrink = new javax.swing.JComboBox<DanhMuc>();
        txtSearch = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbbSize = new javax.swing.JComboBox<Size>();
        cbbKind = new javax.swing.JComboBox<>();
        rdo1 = new javax.swing.JRadioButton();
        btnSearch = new javax.swing.JButton();
        rdo0 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDrink = new javax.swing.JTable();
        txtCode = new javax.swing.JTextField();
        btnClearForm = new javax.swing.JButton();

        jPanel1.setPreferredSize(new java.awt.Dimension(1190, 700));

        jLabel8.setText("Danh mục");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 204, 0));
        jLabel1.setText("Danh sách đồ uống");

        jLabel6.setText("Đơn giá");

        cbbKindOfDrink.setModel(new javax.swing.DefaultComboBoxModel<DanhMuc>());

        jLabel9.setText("Size");

        jLabel2.setText("Tìm kiếm thông tin");

        jLabel7.setText("Trạng thái");

        cbbSize.setModel(new javax.swing.DefaultComboBoxModel<Size>());

        cbbKind.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Mã", "Tên" }));

        rdo1.setText("Còn");

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLB_DoUong/IMG/search.png"))); // NOI18N
        btnSearch.setText("Tìm kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        rdo0.setText("Hết");

        jLabel3.setText("ID");

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLB_DoUong/IMG/them.png"))); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel4.setText("Mã đồ uống");

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLB_DoUong/IMG/lamMoi.png"))); // NOI18N
        btnUpdate.setText("Sửa");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel5.setText("Tên đồ uống");

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLB_DoUong/IMG/xoa.png"))); // NOI18N
        btnDelete.setText("Xoá");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        txtID.setToolTipText("");
        txtID.setActionCommand("<Not Set>");

        tblDrink.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Mã đồ uống", "Tên đồ uống", "Đơn giá", "Trạng thái", "Danh mục", "Size"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDrink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDrinkMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDrink);

        btnClearForm.setText("Xoá form");
        btnClearForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearFormActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addGap(64, 64, 64)
                                .addComponent(btnUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDelete))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(108, 108, 108)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(39, 39, 39)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbbKind, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addGap(79, 79, 79)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rdo1)
                                .addGap(54, 54, 54)
                                .addComponent(rdo0))
                            .addComponent(cbbKindOfDrink, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbSize, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(179, 179, 179))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(btnClearForm)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(494, 494, 494)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cbbKind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(rdo1)
                    .addComponent(rdo0))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cbbKindOfDrink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cbbSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnUpdate)
                            .addComponent(btnDelete)
                            .addComponent(btnClearForm))
                        .addGap(42, 42, 42)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        loadTable(doUongService.search(kind(), txtSearch.getText()));
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        doUongService.add(getData());
        loadTable(doUongService.getList());
        clearForm();
        JOptionPane.showMessageDialog(this, "Thêm thành công");
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int row = tblDrink.getSelectedRow();
        doUongService.update(tblDrink.getValueAt(row, 0).toString(), getData());
        loadTable(doUongService.getList());
        clearForm();
        JOptionPane.showMessageDialog(this, "Sửa thành công");
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int row = tblDrink.getSelectedRow();
        doUongService.delete(tblDrink.getValueAt(row, 0).toString());
        loadTable(doUongService.getList());
        clearForm();
        JOptionPane.showMessageDialog(this, "Xoá thành công");
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblDrinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDrinkMouseClicked
        int row = tblDrink.getSelectedRow();
        txtID.setText(tblDrink.getValueAt(row, 0).toString());
        txtCode.setText(tblDrink.getValueAt(row, 1).toString());
        txtName.setText(tblDrink.getValueAt(row, 2).toString());
        txtPrice.setText(tblDrink.getValueAt(row, 3).toString());
        if (tblDrink.getValueAt(row, 4).toString().equals("Còn")) {
            rdo1.setSelected(true);
        }
        if (tblDrink.getValueAt(row, 4).toString().equals("Hết")) {
            rdo0.setSelected(true);
        }
        for (int i = 0; i < cbbKindOfDrink.getItemCount(); i++) {
            if (cbbKindOfDrink.getItemAt(i).getId().equals(((DanhMuc) tblDrink.getValueAt(row, 5)).getId())) {
                cbbKindOfDrink.setSelectedIndex(i);
            }
        }
        for (int i = 0; i < cbbSize.getItemCount(); i++) {
            if (cbbSize.getItemAt(i).getId().equals(((Size) tblDrink.getValueAt(row, 6)).getId())) {
                cbbSize.setSelectedIndex(i);
            }
        }
    }//GEN-LAST:event_tblDrinkMouseClicked

    private void btnClearFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearFormActionPerformed
        clearForm();
    }//GEN-LAST:event_btnClearFormActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClearForm;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbbKind;
    private javax.swing.JComboBox<DanhMuc> cbbKindOfDrink;
    private javax.swing.JComboBox<Size> cbbSize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdo0;
    private javax.swing.JRadioButton rdo1;
    private javax.swing.JTable tblDrink;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
