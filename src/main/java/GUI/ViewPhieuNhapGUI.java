package GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import BUS.SanPhamBUS;
import DAO.SanPhamDAO;
import DAO.CTPhieuNhapDAO;
import DTO.CTPhieuNhap;
import DTO.PhieuNhap;
import DTO.SanPham;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ViewPhieuNhapGUI extends javax.swing.JPanel {
    private SanPhamBUS sanPhamBUS;

    public ViewPhieuNhapGUI() {
        initComponents();
        
        sanPhamBUS = SanPhamBUS.getInstance();
        populateSanPhamTable();
        
        // Add mouse listener to the table
        SanPhamTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = SanPhamTable.getSelectedRow();
                if (row >= 0) {
                    // Get data from selected row
                    DefaultTableModel model = (DefaultTableModel) SanPhamTable.getModel();
                    String maSanPham = model.getValueAt(row, 0).toString();
                    String tenSanPham = model.getValueAt(row, 1).toString();
                    
                    // Set data to text fields
                    txtMaSp.setText(maSanPham);
                    txtTenSp.setText(tenSanPham);
                }
            }
        });
    }

    public JTextField getTxtMaSp() {
        return txtMaSp;
    }

    public JTextField getTxtTenSp() {
        return txtTenSp;
    }

    public JTextField getTxtSoLuong() {
        return txtSoLuong;
    }

    public JTextField getTxtDonGia() {
        return txtDonGia;
    }

    public JButton getBtnNhapHang() {
        return btnNhapHang;
    }

    private void populateSanPhamTable() {
        sanPhamBUS.populateSanPhamTable(SanPhamTable);
    }
    
 


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        SanPhamTable = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMaSp = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTenSp = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        btnNhapHang = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jcbNhaCungCap = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jcbNhanVien = new javax.swing.JComboBox<>();
        btnXoa = new javax.swing.JButton();
        btnXacNhan = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        HangChoTable = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        btnTimKiem = new javax.swing.JButton();

        jLabel3.setText("jLabel3");

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Tìm kiếm");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        SanPhamTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        SanPhamTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        SanPhamTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SanPhamTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        SanPhamTable.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                SanPhamTableAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(SanPhamTable);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Hàng chờ Nhập");
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Thông tin sản phẩm");
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setText("Mã SP");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtMaSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSpActionPerformed(evt);
            }
        });

        jLabel5.setText("Tên SP");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtTenSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenSpActionPerformed(evt);
            }
        });

        jLabel6.setText("Số lượng nhập");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongActionPerformed(evt);
            }
        });

        jLabel7.setText("Đơn giá nhập");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtDonGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDonGiaActionPerformed(evt);
            }
        });

        btnNhapHang.setText("Nhập hàng");
        btnNhapHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapHangActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Thông tin phiếu nhập");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setText("Nhà cung cấp");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jcbNhaCungCap.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Điện máy Đà Nẵng", "Điện máy Viettronimex", "Điện máy Mediamart", "Điện máy Việt Tuấn" }));

        jLabel10.setText("Nhân viên");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jcbNhanVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Trịnh Lê Huy", "Phạm Duy Khánh", "Nguyễn Anh Khoa", "Nguyễn Trương Gia Huy" }));
        jcbNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbNhanVienActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnXacNhan.setText("Xác Nhận");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        HangChoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Số Lượng", "Giá", "Thành Tiền"
            }
        ));
        HangChoTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        HangChoTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(HangChoTable);

        jLabel13.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Kho Hàng");
        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSoLuong)
                            .addComponent(txtDonGia)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenSp)
                            .addComponent(txtMaSp)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnNhapHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jcbNhaCungCap, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbNhanVien, 0, 268, Short.MAX_VALUE)))
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTimKiem))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMaSp, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTenSp, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDonGia, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 15, Short.MAX_VALUE)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
    
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void txtMaSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSpActionPerformed

    }//GEN-LAST:event_txtMaSpActionPerformed

    private void txtTenSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenSpActionPerformed
 
    }//GEN-LAST:event_txtTenSpActionPerformed

    private void txtDonGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDonGiaActionPerformed
    
    }//GEN-LAST:event_txtDonGiaActionPerformed

    private void txtSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongActionPerformed
   
    }//GEN-LAST:event_txtSoLuongActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
       DefaultTableModel model = (DefaultTableModel) HangChoTable.getModel();
    int selectedRow = HangChoTable.getSelectedRow();
    if (selectedRow != -1) { // Ensure a row is selected
        model.removeRow(selectedRow);
    }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void SanPhamTableAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_SanPhamTableAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_SanPhamTableAncestorAdded

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
// Kiểm tra xem bảng HangChoTable có hàng nào được chọn không
     if (HangChoTable.getSelectedRowCount() > 0) {
        for (int i : HangChoTable.getSelectedRows()) {
            Object maSPObject = HangChoTable.getValueAt(i, 0);
            Object soLuongObject = HangChoTable.getValueAt(i, 2);
            Object donGiaObject = HangChoTable.getValueAt(i, 3);
            Object thanhTienObject = HangChoTable.getValueAt(i, 4);

            if (maSPObject == null || soLuongObject == null || donGiaObject == null || thanhTienObject == null) {
                continue;
            }

            int MaSP = Integer.parseInt(maSPObject.toString());
            int SoLuong = Integer.parseInt(soLuongObject.toString());
            double DonGia = Double.parseDouble(donGiaObject.toString());
            double ThanhTien = Double.parseDouble(thanhTienObject.toString());

            // Tạo một đối tượng CTPhieuNhap từ thông tin hàng được chọn
            CTPhieuNhap ctPhieuNhap = new CTPhieuNhap();
            ctPhieuNhap.setMaSP(MaSP);
            ctPhieuNhap.setSoLuong(SoLuong);
            ctPhieuNhap.setDonGia((int) (float) DonGia);
            ctPhieuNhap.setThanhTien((int) (float) ThanhTien);
            
            // Tạo một đối tượng SanPham để cập nhật số lượng
                   
            SanPham sanPham = SanPhamDAO.getSanPhamById(MaSP);
            if (sanPham != null) {
                int currentQuantity = sanPham.getSoLuong();
                int newQuantity = currentQuantity + SoLuong; // Calculate the new quantity

                sanPham.setSoLuong(newQuantity); // Update the quantity in the object

                // Cập nhật số lượng sản phẩm vào cơ sở dữ liệu
                SanPhamDAO.updateSoLuongSanPham(MaSP, newQuantity); // Just update the database without expecting a return value
            }



            // Thêm đối tượng CTPhieuNhap vào cơ sở dữ liệu
            boolean addCTPhieuNhapSuccess = DAO.CTPhieuNhapDAO.addCTPhieuNhap(ctPhieuNhap);

            if (!addCTPhieuNhapSuccess) {
                // Xử lý khi thêm chi tiết phiếu nhập thất bại (nếu cần)
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn ít nhất một hàng từ bảng.");
        return;
    }
 
        // Khai báo và khởi tạo HashMap để ánh xạ giá trị hiển thị với mã tương ứng
    HashMap<String, Integer> nhaCungCapMap = new HashMap<>();
    HashMap<String, Integer> nhanVienMap = new HashMap<>();

    // Đặt các giá trị ánh xạ cho nhà cung cấp
    nhaCungCapMap.put("Điện máy Đà Nẵng", 111);
    nhaCungCapMap.put("Điện máy Viettronimex", 112);
    nhaCungCapMap.put("Điện máy Mediamart", 113);
    nhaCungCapMap.put("Điện máy Việt Tuấn", 114);

    // Đặt các giá trị ánh xạ cho nhân viên
    nhanVienMap.put("Admin", 1);
    nhanVienMap.put("Phạm Duy Khánh", 2);
    nhanVienMap.put("Nguyễn Anh Khoa", 3);
    nhanVienMap.put("Nguyễn Trương Gia Huy", 4);
    nhanVienMap.put("Trịnh Lê Huy", 5);

    // Lấy dữ liệu từ JComboBox nhaCungCap và nhanVien
String nhaCungCapSelected = jcbNhaCungCap.getSelectedItem().toString();
String nhanVienSelected = jcbNhanVien.getSelectedItem().toString();

// Kiểm tra xem các giá trị được chọn có null không
if (nhaCungCapSelected == null || nhanVienSelected == null || nhaCungCapSelected.isEmpty() || nhanVienSelected.isEmpty()) {
    // Nếu có giá trị null hoặc rỗng, xử lý khi dữ liệu từ JComboBox không hợp lệ
    JOptionPane.showMessageDialog(this, "Vui lòng chọn nhà cung cấp và nhân viên.");
    return; // Kết thúc phương thức nếu dữ liệu không hợp lệ
}

// Lấy mã tương ứng từ HashMap
Integer maNhaCungCap = nhaCungCapMap.get(nhaCungCapSelected);
Integer maNhanVien = nhanVienMap.get(nhanVienSelected);

if (maNhaCungCap == null || maNhanVien == null) {
    // Kiểm tra xem mã nhà cung cấp hoặc mã nhân viên có tồn tại không
    JOptionPane.showMessageDialog(this, "Không tìm thấy mã tương ứng cho nhà cung cấp hoặc nhân viên.");
    return; // Kết thúc phương thức nếu không tìm thấy mã
}

 if (HangChoTable.getSelectedRowCount() > 0) {
        // Lặp qua các hàng được chọn trong bảng HangChoTable
        for (int i : HangChoTable.getSelectedRows()) {
    // Kiểm tra dữ liệu từ bảng có null không
    Object thanhTienObject = HangChoTable.getValueAt(i, 4);

    if (thanhTienObject == null) {
        // Nếu có dữ liệu null, bỏ qua hàng này và chuyển sang hàng tiếp theo
        continue;
    }

    try {
        // Ép kiểu dữ liệu và lấy giá trị thành tiền từ bảng
        double thanhTien = Double.parseDouble(thanhTienObject.toString());

        // Tạo một đối tượng PhieuNhap từ thông tin được chọn
        PhieuNhap phieuNhap = new PhieuNhap();
        phieuNhap.setTongTien((int) (float) thanhTien);
        phieuNhap.setMaNCC(maNhaCungCap); // Đặt mã nhà cung cấp
        phieuNhap.setMaNV(maNhanVien); // Đặt mã nhân viên
        phieuNhap.setNgayLap(new Date());

        // Thêm đối tượng PhieuNhap vào cơ sở dữ liệu
        boolean addPhieuNhapSuccess = DAO.PhieuNhapDAO.addPhieuNhap(phieuNhap);

        if (!addPhieuNhapSuccess) {
            // Xử lý khi thêm phiếu nhập thất bại (nếu cần)
            JOptionPane.showMessageDialog(this, "Thêm phiếu nhập thất bại. Vui lòng thử lại sau.");
        }
    } catch (NumberFormatException ex) {
        // Xử lý nếu không thể chuyển đổi thành tiền sang số
        JOptionPane.showMessageDialog(this, "Lỗi khi chuyển đổi thành tiền. Vui lòng kiểm tra dữ liệu nhập.");
    }
        }
 }
  
    }//GEN-LAST:event_btnXacNhanActionPerformed

    private void btnNhapHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapHangActionPerformed
 
    ActionListener[] listeners = getBtnNhapHang().getActionListeners();
    for (ActionListener listener : listeners) {
        getBtnNhapHang().removeActionListener(listener);
    }

    // Add a new action listener to the button
    getBtnNhapHang().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get the table model
            DefaultTableModel defaultTableModel = (DefaultTableModel) HangChoTable.getModel();

            // Lấy giá trị từ các JTextField
            String MaSp = getTxtMaSp().getText();
            String TenSp = getTxtTenSp().getText();
            int SoLuong = Integer.parseInt(getTxtSoLuong().getText());
            float DonGia = Float.parseFloat(getTxtDonGia().getText());
            float ThanhTien = SoLuong * DonGia;

            // Thêm hàng vào bảng
            defaultTableModel.addRow(new Object[]{MaSp, TenSp, SoLuong, DonGia, ThanhTien});
        }
    });
    }//GEN-LAST:event_btnNhapHangActionPerformed

    private void jcbNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbNhanVienActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // Get the search keyword from txtTimKiem
    String keyword = txtTimKiem.getText().trim();
    
    // If the keyword is empty, return
    if (keyword.isEmpty()) {
        return;
    }
    
    // Iterate through the rows of the SanPhamTable to find matching MaSP or TenSP
    for (int i = 0; i < SanPhamTable.getRowCount(); i++) {
        String maSP = SanPhamTable.getValueAt(i, 0).toString();
        String tenSP = SanPhamTable.getValueAt(i, 1).toString();
        
        // Check if the MaSP or TenSP matches the keyword
        if (maSP.contains(keyword) || tenSP.contains(keyword)) {
            // Select the row in the SanPhamTable
            SanPhamTable.setRowSelectionInterval(i, i);
            
            // Scroll to the selected row
            SanPhamTable.scrollRectToVisible(SanPhamTable.getCellRect(i, 0, true));
            
            // Exit the loop since we found a match
            return;
        }
    }
    
    // If no match is found, show a message
    JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnTimKiemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable HangChoTable;
    private javax.swing.JTable SanPhamTable;
    private javax.swing.JButton btnNhapHang;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jcbNhaCungCap;
    private javax.swing.JComboBox<String> jcbNhanVien;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtMaSp;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenSp;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
