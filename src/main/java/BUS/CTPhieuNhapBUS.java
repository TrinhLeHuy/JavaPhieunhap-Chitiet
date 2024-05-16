package BUS;

import DAO.CTPhieuNhapDAO;
import DTO.CTPhieuNhap;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CTPhieuNhapBUS {
    private static CTPhieuNhapBUS instance;

    public static CTPhieuNhapBUS getInstance() {
        if (instance == null) {
            instance = new CTPhieuNhapBUS();
        }
        return instance;
    }

    private CTPhieuNhapBUS() {
    
    }
    
    public void addSanPham(CTPhieuNhap ctphieunhap) throws SQLException {
        validate(ctphieunhap);
        CTPhieuNhapDAO.getInstance().addCTPhieuNhap(ctphieunhap);
    }

    public void updateSanPham(CTPhieuNhap ctphieunhap) throws SQLException {
        CTPhieuNhapDAO.getInstance().updateCTPhieuNhap(ctphieunhap);
    }

    private void validate(CTPhieuNhap ctphieunhap) {
        // Implement validation logic here
    }

    public void populateCTPhieuNhapTable(JTable CTPhieuNhapTable) {
    DefaultTableModel defaultTableModel = new DefaultTableModel();
     CTPhieuNhapTable.setModel(defaultTableModel);
    defaultTableModel.addColumn("Mã SP");
    defaultTableModel.addColumn("Số Lượng");
    defaultTableModel.addColumn("Đơn Giá");
    defaultTableModel.addColumn("Thành Tiền");
    
    
    List<CTPhieuNhap> ctphieunhap = CTPhieuNhapDAO.getInstance().getAllChiTietPhieuNhap();// Handle SQLException
    System.out.println("Số lượng sản phẩm được lấy từ cơ sở dữ liệu: " + ctphieunhap.size());
    for (CTPhieuNhap ctphieunhaps : ctphieunhap) {
        defaultTableModel.addRow(new Object[]{ctphieunhaps.getMaSP(), ctphieunhaps.getSoLuong(), ctphieunhaps.getDonGia(), ctphieunhaps.getThanhTien()});
    }
}

}
