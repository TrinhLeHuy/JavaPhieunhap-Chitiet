package BUS;

import DAO.PhieuNhapDAO;
import DTO.PhieuNhap;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PhieuNhapBUS {
    private static PhieuNhapBUS instance;

    public static PhieuNhapBUS getInstance() {
        if (instance == null) {
            instance = new PhieuNhapBUS();
        }
        return instance;
    }

    private PhieuNhapBUS() {
    
    }
    
    public void addSanPham(PhieuNhap phieunhap) throws SQLException {
        validate(phieunhap);
        PhieuNhapDAO.getInstance().addPhieuNhap(phieunhap);
    }

    public void updateSanPham(PhieuNhap phieunhap) throws SQLException {
        PhieuNhapDAO.getInstance().updatePhieuNhap(phieunhap);
    }

    private void validate(PhieuNhap phieunhap) {
        // Implement validation logic here
    }

    public void populatePhieuNhapTable(JTable PhieuNhapTable) {
    DefaultTableModel defaultTableModel = new DefaultTableModel();
     PhieuNhapTable.setModel(defaultTableModel);
    defaultTableModel.addColumn("Mã PN");
    defaultTableModel.addColumn("Ngày lập");
    defaultTableModel.addColumn("Tổng tiền");
    
    List<PhieuNhap> phieunhap = PhieuNhapDAO.getInstance().getAllPhieuNhap(); // Handle SQLException
    System.out.println("Số lượng sản phẩm được lấy từ cơ sở dữ liệu: " + phieunhap.size());
    for (PhieuNhap phieunhaps : phieunhap) {
        defaultTableModel.addRow(new Object[]{phieunhaps.getMaPN(), phieunhaps.getNgayLap(), phieunhaps.getTongTien()});
    }
}
    public void populateSearchPhieuNhapTable(JTable PhieuNhapTable) {
    DefaultTableModel defaultTableModel = new DefaultTableModel();
     PhieuNhapTable.setModel(defaultTableModel);
    defaultTableModel.addColumn("Mã PN");
    defaultTableModel.addColumn("Ngày lập");
    defaultTableModel.addColumn("Tổng tiền");
    
    List<PhieuNhap> phieunhap = PhieuNhapDAO.getInstance().getAllPhieuNhap(); // Handle SQLException
    System.out.println("Số lượng sản phẩm được lấy từ cơ sở dữ liệu: " + phieunhap.size());
    for (PhieuNhap phieunhaps : phieunhap) {
        defaultTableModel.addRow(new Object[]{phieunhaps.getMaPN(), phieunhaps.getNgayLap(), phieunhaps.getTongTien()});
    }
}
     public String getMaNCCByMaPN(String maPN) {
        try {
            return PhieuNhapDAO.getInstance().getMaNCCByMaPN(maPN);
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error fetching MaNCC";
        }
    }
      public String getMaNVByMaPN(String maPN) {
    try {
        return PhieuNhapDAO.getInstance().getMaNVByMaPN(maPN);
    } catch (SQLException e) {
        e.printStackTrace();
        return "Error fetching MaNV";
    }
}
public void SearchTable(JTable SearchTable) {
    DefaultTableModel defaultTableModel = new DefaultTableModel();
     SearchTable.setModel(defaultTableModel);
    defaultTableModel.addColumn("Mã PN");
    defaultTableModel.addColumn("Ngày lập");
    defaultTableModel.addColumn("Tổng tiền");
    
}

}
