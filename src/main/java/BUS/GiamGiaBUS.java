package BUS;

import DAO.GiamGiaDAO;
import DTO.GiamGia;
import java.sql.SQLException;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author khanh
 */
public class GiamGiaBUS {
    public static GiamGiaBUS giamGiaBus;
    public static GiamGiaBUS getInstance() {
        if (giamGiaBus == null)  {
            giamGiaBus = new GiamGiaBUS();
        }
        return giamGiaBus;
    }

    public GiamGiaBUS() {
    
    }
    
    // Method to add a new discount
    public void addGiamGia(GiamGia giamGia) throws SQLException {
        validate(giamGia);
        GiamGiaDAO.getInstance().addGiamGia(giamGia);
    }

    // Method to update an existing discount
    public void updateGiamGia(GiamGia giamGia) throws SQLException {
        
        GiamGiaDAO.getInstance().updateGiamGia(giamGia);
    }

   

    // Method to get all discounts
    public List<GiamGia> getAllGiamGia() throws SQLException {
        // Create a connection to the database using a DAO instance
        return GiamGiaDAO.getInstance().getAllGiamGia();
    }
    
    public boolean validate(GiamGia giamGia) {
        // Check if TenGiamGia is not null or empty
        if (giamGia.getTenGiamGia() == null || giamGia.getTenGiamGia().isEmpty()) {
            throw new IllegalArgumentException("TenGiamGia cannot be null or empty");
        }

        // Check if PhanTramGiam is within the valid range (0-100)
        if (giamGia.getPhanTramGiam() < 0 || giamGia.getPhanTramGiam() > 100) {
            throw new IllegalArgumentException("PhanTramGiam must be between 0 and 100");
        }

        // Check if DieuKien is not negative
        if (giamGia.getDieuKien() < 0) {
            throw new IllegalArgumentException("DieuKien cannot be negative");
        }

        // Check if NgayDB is not null and before NgayKT
        if (giamGia.getNgayDB() == null || giamGia.getNgayKT() == null || giamGia.getNgayDB().after(giamGia.getNgayDB())) {
            throw new IllegalArgumentException("NgayDB must be before NgayKT");
        }

        // If all validations pass, return true
        return true;
    }

    
}
