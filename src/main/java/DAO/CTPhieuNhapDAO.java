package DAO;

import DAO.MyConnect;
import DAO.MyConnect;
import DTO.CTPhieuNhap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CTPhieuNhapDAO {
    private static CTPhieuNhapDAO instance;
    private Connection conn;

    public CTPhieuNhapDAO(Connection connection) {
        this.conn = connection;
    }
      public CTPhieuNhapDAO() {
        this.conn = MyConnect.getConnection();
    }
     public static CTPhieuNhapDAO getInstance() {
        if (instance == null) {
            instance = new CTPhieuNhapDAO();
        }
        return instance;
    }

    public List<CTPhieuNhap> getAllChiTietPhieuNhap() {
        List<CTPhieuNhap> danhSachCTPhieuNhap = new ArrayList<>();
        String sql = "SELECT * FROM ctphieunhap";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                CTPhieuNhap ct = new CTPhieuNhap();
                ct.setMaPN(rs.getInt("MaPN"));
                ct.setMaSP(rs.getInt("MaSP"));
                ct.setSoLuong(rs.getInt("SoLuong"));
                ct.setDonGia( rs.getInt("DonGia"));
                ct.setThanhTien( rs.getInt("ThanhTien"));
                danhSachCTPhieuNhap.add(ct);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachCTPhieuNhap;
    }

  public static boolean addCTPhieuNhap(CTPhieuNhap ctpn) {
    boolean result = false;
    Connection connection = null;
    PreparedStatement prep = null;
    
    try {
        // Thực hiện kết nối đến cơ sở dữ liệu
        connection = MyConnect.getConnection();
        
        // Tạo câu lệnh SQL cho việc chèn dữ liệu vào bảng `ctphieunhap`
        String sql = "INSERT INTO `ctphieunhap`(`MaPN`, `MaSP`, `SoLuong`, `DonGia`, `ThanhTien`) VALUES (?,?,?,?,?)";
        
        // Chuẩn bị câu lệnh PreparedStatement
        prep = connection.prepareStatement(sql);
        
        // Đặt các giá trị cho các tham số trong câu lệnh SQL
        prep.setInt(1, ctpn.getMaPN());
        prep.setInt(2, ctpn.getMaSP());
        prep.setInt(3, ctpn.getSoLuong());
        prep.setFloat(4, ctpn.getDonGia());
        prep.setFloat(5, ctpn.getThanhTien());
        
        // Thực thi câu lệnh SQL và kiểm tra số hàng bị ảnh hưởng
        int rowsAffected = prep.executeUpdate();
        
        // Nếu có ít nhất một hàng được thêm vào, đặt kết quả thành true
        if (rowsAffected > 0) {
            result = true;
        }
    } catch (SQLException ex) {
        // Xử lý ngoại lệ nếu có lỗi xảy ra
        ex.printStackTrace(); // In stack trace để ghi log cho việc theo dõi
    } finally {
        // Đóng PreparedStatement và Connection
        try {
            if (prep != null) {
                prep.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // In stack trace để ghi log cho việc theo dõi
        }
    }
    
    return result;
}
 public static void updateCTPhieuNhap(CTPhieuNhap ctpn) {
    Connection conn = null;
    PreparedStatement prep = null;

    try {
        conn = MyConnect.getConnection();
        String sql = "UPDATE ctphieunhap SET SoLuong = ?, DonGia = ?, ThanhTien = ? WHERE MaPN = ? AND MaSP = ?";
        prep = conn.prepareStatement(sql);
        prep.setInt(1, ctpn.getSoLuong());
        prep.setFloat(2, ctpn.getDonGia());
        prep.setFloat(3, ctpn.getThanhTien());
        prep.setInt(4, ctpn.getMaPN());
        prep.setInt(5, ctpn.getMaSP());

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


}
