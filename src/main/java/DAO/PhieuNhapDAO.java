package DAO;

import DTO.PhieuNhap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhieuNhapDAO {
    private static PhieuNhapDAO instance;

    private Connection conn;

    private PhieuNhapDAO() {
        this.conn = MyConnect.getConnection();
    }

    public static PhieuNhapDAO getInstance() {
        if (instance == null) {
            instance = new PhieuNhapDAO();
        }
        return instance;
    }

    public List<PhieuNhap> getAllPhieuNhap() {
        List<PhieuNhap> phieuNhapList = new ArrayList<>();
        String sql = "SELECT * FROM phieunhap";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                PhieuNhap pn = new PhieuNhap();
                pn.setMaPN(rs.getInt("MaPN"));
                pn.setMaNCC(rs.getInt("MaNCC"));
                pn.setMaNV(rs.getInt("MaNV"));
                pn.setNgayLap(rs.getDate("NgayLap"));
                pn.setTongTien( rs.getFloat("TongTien"));
                phieuNhapList.add(pn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phieuNhapList;
    }

    public static boolean addPhieuNhap(PhieuNhap pn) {
        boolean result = false;
        Connection connection = null;
        PreparedStatement prep = null;

        try {
            connection = MyConnect.getConnection();
            String sql = "INSERT INTO phieunhap (MaNCC, MaNV, NgayLap, TongTien) VALUES (?, ?, ?, ?)";
            prep = connection.prepareStatement(sql);
            prep.setInt(1, pn.getMaNCC());
            prep.setInt(2, pn.getMaNV());
            prep.setDate(3, new java.sql.Date(pn.getNgayLap().getTime()));
            prep.setFloat(4, pn.getTongTien());

            int rowsAffected = prep.executeUpdate();
            if (rowsAffected > 0) {
                result = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (prep != null) {
                    prep.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return result;
    }

    public static void updatePhieuNhap(PhieuNhap phieunhap) {
        Connection conn = null;
        PreparedStatement prep = null;

        try {
            conn = MyConnect.getConnection();
            String sql = "UPDATE phieunhap SET MaNCC = ?, MaNV = ?, NgayLap = ?, TongTien = ? WHERE MaPN = ?";
            prep = conn.prepareStatement(sql);
            prep.setInt(1, phieunhap.getMaNCC());
            prep.setInt(2, phieunhap.getMaNV());
            prep.setDate(3, new java.sql.Date(phieunhap.getNgayLap().getTime()));
            prep.setFloat(4, phieunhap.getTongTien());
            prep.setInt(5, phieunhap.getMaPN());

            prep.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (prep != null) prep.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
public String getMaNVByMaPN(String maPN) throws SQLException {
    String maNV = null;
    String query = "SELECT MaNV FROM phieunhap WHERE MaPN = ?";

    try (Connection conn = MyConnect.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setString(1, maPN);
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                maNV = rs.getString("MaNV");
            }
        }
    }
    return maNV;
}

public String getMaNCCByMaPN(String maPN) throws SQLException {
    String maNCC = null;
    String query = "SELECT MaNCC FROM phieunhap WHERE MaPN = ?";

    try (Connection conn = MyConnect.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setString(1, maPN);
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                maNCC = rs.getString("MaNCC");
            }
        }
    }
    return maNCC;
}






}
