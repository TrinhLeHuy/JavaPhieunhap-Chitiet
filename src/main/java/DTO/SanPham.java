package DTO;
import BUS.SanPhamBUS;

/**
 *
 * @author khanh
 */
public class SanPham {
    private int maSanPham;
    private String tenSanPham;
    private int maLoai;
    private int soLuong;
    private String sonViTinh;
    private String hinhAnh;
    private float donGia;

    public SanPham() {
    }

    public SanPham(int maSanPham, String tenSanPham, int maLoai, int soLuong, String sonViTinh, String hinhAnh, float donGia) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.maLoai = maLoai;
        this.soLuong = soLuong;
        this.sonViTinh = sonViTinh;
        this.hinhAnh = hinhAnh;
        this.donGia = donGia;
    }

    public int getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getSonViTinh() {
        return sonViTinh;
    }

    public void setSonViTinh(String sonViTinh) {
        this.sonViTinh = sonViTinh;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }
    @Override
    public String toString() {
        return "SanPham{" +
                "maSanPham=" + maSanPham +
                ", tenSanPham='" + tenSanPham + '\'' +
                ", maLoai=" + maLoai +
                ", soLuong=" + soLuong +
                ", sonViTinh='" + sonViTinh + '\'' +
                ", hinhAnh='" + hinhAnh + '\'' +
                ", donGia=" + donGia +
                '}';
    }
}
    
    
