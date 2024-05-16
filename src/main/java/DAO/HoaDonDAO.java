package DAO;

import DTO.HoaDon;
import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author khanh
 */
public class HoaDonDAO {
    public List<HoaDon> getAllHoaDon() {
        List<HoaDon> hoaDon = new ArrayList<HoaDon>();
        Connection conn = MyConnect.getConnection();
        String sql = "SELECT * FROM hoadon";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                HoaDon hd = new HoaDon();
                
                hd.setMaHD(rs.getInt(1));
                hd.setMaKH(rs.getInt(2));
                hd.setMaNV(rs.getInt(3));
                hd.setNgayLap(rs.getDate(4));
                hd.setTongTienHang(rs.getFloat(5));
                hd.setGiamGia(rs.getInt(6));
                hd.setThanhTien(rs.getFloat(7));
                hd.setGhiChu(rs.getString(8));
                
                hoaDon.add(hd);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return hoaDon;
    }
    
    public boolean addHoaDon(HoaDon hd) {
        boolean result = false;
        try {
            String sql1 = "UPDATE KhachHang SET TongChiTieu=TongChiTieu+" + hd.getThanhTien() + " WHERE MaKH=" + hd.getMaKH();
            Statement st = MyConnect.conn.createStatement();
            st.executeUpdate(sql1);
            String sql = "INSERT INTO `hoadon`(`MaKH`, `MaNV`, `NgayLap`, `TongTienHang`, `GiamGia`, `ThanhTien`, `GhiChu`) "
                    + "VALUES (?,?,?,?,?,?,?)";
            PreparedStatement prep = MyConnect.conn.prepareStatement(sql);
            prep.setInt(1, hd.getMaKH());
            prep.setInt(2, hd.getMaNV());
            prep.setTimestamp(3, new java.sql.Timestamp(new java.util.Date().getTime()));
            prep.setFloat(4, hd.getTongTienHang());
            prep.setInt(5, hd.getGiamGia());
            prep.setFloat(6, hd.getThanhTien());
            prep.setString(7, hd.getGhiChu());
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return result;
    }
}
