package BUS;

import DAO.SanPhamDAO;
import DTO.SanPham;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SanPhamBUS {
    private static SanPhamBUS instance;

    public static SanPhamBUS getInstance() {
        if (instance == null) {
            instance = new SanPhamBUS();
        }
        return instance;
    }

    private SanPhamBUS() {}

    public void addSanPham(SanPham sanPham) throws SQLException {
        validate(sanPham);
        SanPhamDAO.getInstance().addSanPham(sanPham);
    }

    public void updateSanPham(SanPham sanPham) throws SQLException {
        SanPhamDAO.getInstance().updateSanPham(sanPham);
    }

    private void validate(SanPham sanPham) {
        // Implement validation logic here
    }

    public void populateSanPhamTable(JTable sanPhamTable) {
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        sanPhamTable.setModel(defaultTableModel);
        defaultTableModel.addColumn("Mã");
        defaultTableModel.addColumn("Tên");
        defaultTableModel.addColumn("Tồn Kho");

        try {
            List<SanPham> sanPhams = SanPhamDAO.getInstance().getAllSanPham();
            System.out.println("Số lượng sản phẩm được lấy từ cơ sở dữ liệu: " + sanPhams.size());

            for (SanPham sanPham : sanPhams) {
                defaultTableModel.addRow(new Object[]{sanPham.getMaSanPham(), sanPham.getTenSanPham(), sanPham.getSoLuong()});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle SQLException
        }
    }

    public String getProductNameByMaSP(String maSP) {
        try {
            return SanPhamDAO.getInstance().getProductNameByMaSP(maSP);
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error fetching product name";
        }
    }
}
