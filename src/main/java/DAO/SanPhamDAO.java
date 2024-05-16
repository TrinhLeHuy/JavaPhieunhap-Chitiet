package DAO;

import static DAO.MyConnect.conn;
import DTO.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SanPhamDAO {

    private static SanPhamDAO instance;

    // Private constructor to prevent instantiation from outside
    private SanPhamDAO() {
    }

    // Method to get the singleton instance of SanPhamDAO
    public static SanPhamDAO getInstance() {
        if (instance == null) {
            instance = new SanPhamDAO();
        }
        return instance;
    }

   public List<SanPham> getAllSanPham() throws SQLException {
    List<SanPham> sanPhams = new ArrayList<>();
    Connection conn = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;

    try {
        conn = MyConnect.getConnection();
        String sql = "SELECT * FROM sanpham";
        preparedStatement = conn.prepareStatement(sql);
        rs = preparedStatement.executeQuery();

        while (rs.next()) {
            SanPham sanPham = new SanPham();

            sanPham.setMaSanPham(rs.getInt("MaSP"));
            sanPham.setTenSanPham(rs.getString("TenSP"));
            sanPham.setMaLoai(rs.getInt("MaLoai"));
            sanPham.setSoLuong(rs.getInt("SoLuong"));
            sanPham.setSonViTinh(rs.getString("DonViTinh"));
            sanPham.setHinhAnh(rs.getString("HinhAnh"));
            sanPham.setDonGia(rs.getFloat("DonGia"));

            sanPhams.add(sanPham);
        }
    } finally {
        // Đóng tài nguyên
        try {
            if (rs != null) rs.close();
            if (preparedStatement != null) preparedStatement.close();
            if (conn != null) conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    return sanPhams;
}

    public static boolean addSanPham(SanPham sanPham) {
        boolean result = false;
        Connection conn = null;
        PreparedStatement prep = null;

        try {
            conn = MyConnect.getConnection();
            String sql = "INSERT INTO sanpham(TenSP, MaSP, MaLoai, SoLuong, DonViTinh, HinhAnh, DonGia) VALUES (?, ?, ?, ?, ?, ?, ?)";
            prep = conn.prepareStatement(sql);
            prep.setString(1, sanPham.getTenSanPham());
            prep.setInt(2, sanPham.getMaSanPham());
            prep.setInt(3, sanPham.getMaLoai());
            prep.setInt(4, sanPham.getSoLuong());
            prep.setString(5,sanPham.getHinhAnh());
            prep.setFloat(6, sanPham.getDonGia());

            int rowsAffected = prep.executeUpdate();

            if (rowsAffected > 0) {
                result = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Đóng tài nguyên
            try {
                if (prep != null) prep.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return result;
    }

    public static void updateSanPham(SanPham sanPham) {
        Connection conn = null;
        PreparedStatement prep = null;

        try {
            conn = MyConnect.getConnection();
            String sql = "UPDATE sanpham SET TenSP= ?, MaLoai = ?, SoLuong = ?, HinhAnh = ?, DonGia = ? WHERE MaSP= ?";
            prep = conn.prepareStatement(sql);
            prep.setString(1, sanPham.getTenSanPham());
            prep.setInt(2, sanPham.getMaLoai());
            prep.setInt(3, sanPham.getSoLuong());
            prep.setString(4, sanPham.getHinhAnh());
            prep.setFloat(5, sanPham.getDonGia());
            prep.setInt(6, sanPham.getMaSanPham()); // Assuming MaSanPham is the primary key

            prep.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Close resources
            try {
                if (prep != null) prep.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    public static void updateSoLuongSanPham(int maSP, int soLuongMoi) {
    Connection conn = null;
    PreparedStatement prep = null;

    try {
        conn = MyConnect.getConnection();
        String sql = "UPDATE sanpham SET SoLuong = ? WHERE MaSP = ?";
        prep = conn.prepareStatement(sql);
        prep.setInt(1, soLuongMoi);
        prep.setInt(2, maSP);

        prep.executeUpdate();
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        // Đóng tài nguyên
        try {
            if (prep != null) prep.close();
            if (conn != null) conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
public static SanPham getSanPhamById(int maSP) {
        SanPham sanPham = null;
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;

        try {
            conn = MyConnect.getConnection();
            String sql = "SELECT * FROM sanpham WHERE MaSP = ?";
            prep = conn.prepareStatement(sql);
            prep.setInt(1, maSP);
            rs = prep.executeQuery();

            if (rs.next()) {
                sanPham = new SanPham();
                sanPham.setMaSanPham(rs.getInt("MaSP"));
                sanPham.setTenSanPham(rs.getString("TenSP"));
                sanPham.setMaLoai(rs.getInt("MaLoai"));
                sanPham.setSoLuong(rs.getInt("SoLuong"));
                sanPham.setSonViTinh(rs.getString("DonViTinh"));
                sanPham.setHinhAnh(rs.getString("HinhAnh"));
                sanPham.setDonGia(rs.getFloat("DonGia"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (prep != null) prep.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return sanPham;
    }

public String getProductNameByMaSP(String maSP) throws SQLException {
        String productName = null;
        String query = "SELECT TenSP FROM sanpham WHERE MaSP = ?";

        try (Connection conn = MyConnect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, maSP);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    productName = rs.getString("TenSP");
                }
            }
        }
        return productName;
    }


}
