package DTO;

import BUS.GiamGiaBUS;
import DAO.GiamGiaDAO;
import java.util.Date;

/**
 *
 * @author khanh
 */
public class GiamGia {


    private int maGiam;
    private String tenGiamGia;
    private int phanTramGiam;
    private float dieuKien;
    private Date ngayDB;
    private Date ngayKT;

    public GiamGia() {
    }

    public GiamGia(int maGiam, String tenGiamGia, int phanTramGiam, float dieuKien, Date ngayDB, Date ngayKT) {
        this.maGiam = maGiam;
        this.tenGiamGia = tenGiamGia;
        this.phanTramGiam = phanTramGiam;
        this.dieuKien = dieuKien;
        this.ngayDB = ngayDB;
        this.ngayKT = ngayKT;
    }

    public int getMaGiam() {
        return maGiam;
    }

    public void setMaGiam(int maGiam) {
        this.maGiam = maGiam;
    }

    public String getTenGiamGia() {
        return tenGiamGia;
    }

    public void setTenGiamGia(String tenGiamGia) {
        this.tenGiamGia = tenGiamGia;
    }

    public int getPhanTramGiam() {
        return phanTramGiam;
    }

    public void setPhanTramGiam(int phanTramGiam) {
        this.phanTramGiam = phanTramGiam;
    }

    public float getDieuKien() {
        return dieuKien;
    }

    public void setDieuKien(float dieuKien) {
        this.dieuKien = dieuKien;
    }

    public Date getNgayDB() {
        return ngayDB;
    }

    public void setNgayDB(Date ngayDB) {
        this.ngayDB = ngayDB;
    }

    public Date getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(Date ngayKT) {
        this.ngayKT = ngayKT;
    }
    
    
    public boolean validate() {
    // Check if TenGiamGia is not null or empty
    if (tenGiamGia == null || tenGiamGia.isEmpty()) {
        throw new IllegalArgumentException("TenGiamGia cannot be null or empty");
    }

    // Check if PhanTramGiam is within the valid range (0-100)
    if (phanTramGiam < 0 || phanTramGiam > 100) {
        throw new IllegalArgumentException("PhanTramGiam must be between 0 and 100");
    }

    // Check if DieuKien is not negative
    if (dieuKien < 0) {
        throw new IllegalArgumentException("DieuKien cannot be negative");
    }

    // Check if NgayDB is not null and before NgayKT
    if (ngayDB == null || ngayKT == null || ngayDB.after(ngayKT)) {
        throw new IllegalArgumentException("NgayDB must be before NgayKT");
    }

    // If all validations pass, return true
    return true;
}

    
}
