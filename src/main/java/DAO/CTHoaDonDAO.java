package DAO;

import DTO.CTHoaDon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author khanh
 */
public class CTHoaDonDAO {
    public List<CTHoaDon> getAllHoaDon() throws SQLException {
        List<CTHoaDon> ctHoaDon = new ArrayList<CTHoaDon>();
        Connection conn = MyConnect.getConnection();
        String sql = "SELECT * FROM cthoadon";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                CTHoaDon hd = new CTHoaDon();
                
                hd.setMaHD(rs.getInt(1));
                hd.setMaSP(rs.getInt(2));
                hd.setSoLuong(rs.getInt(3));
                hd.setDonGia(rs.getFloat(4));
                hd.setThanhTien(rs.getFloat(5));
                
                ctHoaDon.add(hd);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return ctHoaDon;
    }
    
    public boolean addHoaDon(CTHoaDon cthd) {
        boolean result = false;
        try {
            String sql = "INSERT INTO `cthoadon`(`MaHD`, `MaSP`, `SoLuong`, `DonGia`, `ThanhTien`) "
                    + "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement prep = MyConnect.conn.prepareStatement(sql);
            prep.setInt(1, cthd.getMaHD());
            prep.setInt(2, cthd.getMaSP());
            prep.setInt(3, cthd.getSoLuong());
            prep.setFloat(4, cthd.getDonGia());
            prep.setFloat(5, cthd.getThanhTien());
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return result;
    }
}
