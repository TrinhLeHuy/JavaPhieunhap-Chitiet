package DAO;

import BUS.GiamGiaBUS;
import DTO.GiamGia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GiamGiaDAO {
    public static GiamGiaDAO giamGiaDAO;
    public static GiamGiaDAO getInstance() {
        if (giamGiaDAO == null)  {
            giamGiaDAO = new GiamGiaDAO();
        }
        return giamGiaDAO;
    }
    public List<GiamGia> getAllGiamGia() {
        List<GiamGia> giamGia = new ArrayList<GiamGia>();
        Connection conn = MyConnect.getConnection();

        String sql = "SELECT * FROM giamgia";

        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            
            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                GiamGia gg = new GiamGia();
                gg.setMaGiam(rs.getInt(1));
                gg.setTenGiamGia(rs.getString(2));
                gg.setPhanTramGiam(rs.getInt(3));
                gg.setDieuKien(rs.getFloat(4));
                gg.setNgayDB(rs.getDate(5));
                gg.setNgayKT(rs.getDate(6));
                giamGia.add(gg);
            }
        } catch (SQLException ex) {
            System.err.println("Error retrieving giamGia data:");
            ex.printStackTrace();
//            throw ex; // Re-throw the exception for further handling
        }
        return giamGia;
    }
    
    public void addGiamGia(GiamGia giamGia){
        Connection conn = MyConnect.getConnection();
        String sql = "INSERT INTO `giamgia`(`TenGiamGia`, `PhanTramGiam`, `DieuKien`, `NgayBD`, `NgayKT`) "
                + "VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, giamGia.getTenGiamGia());
            pre.setInt(2, giamGia.getPhanTramGiam());
            pre.setFloat(3, giamGia.getDieuKien());
            pre.setDate(4, new java.sql.Date(giamGia.getNgayDB().getTime()));
            pre.setDate(5, new java.sql.Date(giamGia.getNgayKT().getTime()));

            pre.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void updateGiamGia(GiamGia giamGia){
        Connection conn = MyConnect.getConnection();
        String sql = "UPDATE giamgia SET TenGiamGia = ?,PhanTramGiam= ?, DieuKien = ?, NgayBD = ?,NgayKT = ? WHERE MaGiam = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, giamGia.getTenGiamGia());
            pre.setInt(2, giamGia.getPhanTramGiam());
            pre.setFloat(3, giamGia.getDieuKien());
            pre.setDate(4, new java.sql.Date(giamGia.getNgayDB().getTime()));
            pre.setDate(5, new java.sql.Date(giamGia.getNgayKT().getTime()));
            
            pre.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
