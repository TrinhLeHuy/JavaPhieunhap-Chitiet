package DTO;

/**
 *
 * @author khanh
 */
public class KhachHang {
    private int maKhachHang;
    private String ho;
    private String ten;
    private String gioiTinh;
    private float tongChiTieu;
    private int tinhTrang;

    public KhachHang() {
    }

    public KhachHang(int maKhachHang, String ho, String ten, String gioiTinh, float tongChiTieu, int tinhTrang) {
        this.maKhachHang = maKhachHang;
        this.ho = ho;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.tongChiTieu = tongChiTieu;
        this.tinhTrang = tinhTrang;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public float getTongChiTieu() {
        return tongChiTieu;
    }

    public void setTongChiTieu(float tongChiTieu) {
        this.tongChiTieu = tongChiTieu;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    
    
}
