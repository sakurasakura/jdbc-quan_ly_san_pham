/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quanlysanpham;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import quanlysanpham.controller.QuanLySanPhamController;
import quanlysanpham.model.SanPhamDAO;
import quanlysanpham.model.SanPhamTableModel;
import quanlysanpham.view.QuanLySanPhamView;

/**
 *
 * @author Admin
 */
public class QuanLySanPham {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        QuanLySanPhamView view = new QuanLySanPhamView();
        try {
            SanPhamDAO dao = new SanPhamDAO();
            SanPhamTableModel model = new SanPhamTableModel();
            model.setSanPhamList(dao.getAllRows());
            QuanLySanPhamController controller= new QuanLySanPhamController(model, view);
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
