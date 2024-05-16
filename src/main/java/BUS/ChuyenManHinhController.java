package BUS;

import DTO.DanhMuc;
import GUI.BanHangGUI;
import GUI.KhachHangGUI;
import GUI.KhuyenMaiGUI;
import GUI.NhanVienGUI;
import GUI.NhapHangGUI;
import GUI.SanPhamGUI;
import GUI.ThongKeGUI;
import GUI.TrangChuGUI;
import GUI.ViewBanHangGUI;
import GUI.ViewChiTietPhieuNhapGUI;
import GUI.ViewHoaDonGUI;
import GUI.ViewPhieuNhapGUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
//import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

/**
 *
 * @author khanh
 */
public class ChuyenManHinhController {
    
    private JPanel root;
    private String kindSelected = "";

    private List<DanhMuc> listItem = null;
    public ChuyenManHinhController(JPanel root) {
        this.root = root;
    }
    
    public void setView(JPanel jpnItem, JLabel jlbItem){
        kindSelected = "TrangChu";
        jpnItem.setBackground(new Color(26, 255, 209));
        jlbItem.setBackground(new Color(26, 255, 209));
      
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new TrangChuGUI());
        root.validate();
        root.repaint();
        
    }       
    
    public void setViewBanHang(JPanel jpnItem, JLabel jlbItem){
        kindSelected = "BanHang";
        jpnItem.setBackground(new Color(26, 255, 209));
        jlbItem.setBackground(new Color(26, 255, 209));
      
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new ViewBanHangGUI());
        root.validate();
        root.repaint();
        
    }
      public void setPhieuNhap(JPanel jpnItem, JLabel jlbItem){
        kindSelected = "PhieuNhap";
        jpnItem.setBackground(new Color(26, 255, 209));
        jlbItem.setBackground(new Color(26, 255, 209));
      
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new ViewPhieuNhapGUI());
        root.validate();
        root.repaint();
      }
        
    
    public void setEvent(List<DanhMuc> listItem){
        this.listItem = listItem;
        for(DanhMuc item : listItem){
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }
    
    class LabelEvent implements MouseListener{
        
        private JPanel node;
        
        private String kind;       
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }        
       
        @Override
        public void mouseClicked(MouseEvent e) {
            switch(kind){
                case "TrangChu":
                    node = new TrangChuGUI();
                    break;
                case "BanHang":
                    node = new BanHangGUI();
                    break;
                case "SanPham":
                    node = new SanPhamGUI();
                    break;
                case "KhuyenMai":
                    node = new KhuyenMaiGUI();
                    break;
                case "NhanVien":
                    node = new NhanVienGUI();
                    break;
                case "KhachHang":
                    node = new KhachHangGUI();
                    break;
                case "NhapHang":
                    node = new NhapHangGUI();
                    break;
                case "ThongKe":
                    node = new ThongKeGUI();
                    break;
                case "TrangBanHang":
                    node = new ViewBanHangGUI();
                    break;
                case "HoaDon":
                    node = new ViewHoaDonGUI();
                    break;
                case "PhieuNhap":
                    node = new ViewPhieuNhapGUI();
                    break;
                case "ChiTietPhieuNhap":
                    node = new ViewChiTietPhieuNhapGUI();
                    break;
                default:
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(26, 255, 209));
            jlbItem.setBackground(new Color(26, 255, 209));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(26, 255, 209));
            jlbItem.setBackground(new Color(26, 255, 209));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(!kindSelected.equalsIgnoreCase(kind)){
                jpnItem.setBackground(new Color(255,255,255));
                jlbItem.setBackground(new Color(255,255,255));
            }
        }
        
    }
    
    private void setChangeBackground(String kind){
        for(DanhMuc item : listItem){
            if(item.getKind().equalsIgnoreCase(kind)) {
                item.getJpn().setBackground(new Color(26, 255, 209));
                item.getJlb().setBackground(new Color(26, 255, 209));
            }
            else {
                item.getJpn().setBackground(new Color(255,255,255));
                item.getJlb().setBackground(new Color(255,255,255));
            }
        }
    }
}
