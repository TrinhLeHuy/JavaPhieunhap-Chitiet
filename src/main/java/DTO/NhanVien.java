package DTO;

/**
 *
 * @author khanh
 */
public class NhanVien {
    private int maNhanVien;
    private String ten;
    private String ho;
    private String gioiTinh;
    private String chucVu;

    public NhanVien() {
    }

    public NhanVien(int maNhanVien, String ten, String ho, String gioiTinh, String chucVu) {
        this.maNhanVien = maNhanVien;
        this.ten = ten;
        this.ho = ho;
        this.gioiTinh = gioiTinh;
        this.chucVu = chucVu;
    }

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }
    
    
}
