/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysanpham.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import quanlysanpham.model.SanPham;
import quanlysanpham.model.SanPhamDAO;
import quanlysanpham.model.SanPhamTableModel;
import quanlysanpham.view.QuanLySanPhamView;

/**
 *
 * @author Admin
 */
public class QuanLySanPhamController {

    private SanPhamDAO model;
    private SanPhamTableModel tableModel;
    private QuanLySanPhamView view;

    public QuanLySanPhamController(SanPhamTableModel tableModel, QuanLySanPhamView view) throws SQLException {
        model= new SanPhamDAO();
        this.tableModel = tableModel;
        view.addAddButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    model.themSanPham(new SanPham(view.getValueAtIDTextFeild(), view.getValueAtNameTextFeild(), view.getValueAtCostTextFeild()));
                   // tableModel.setSanPhamList(model.getAllRows());
                    view.updateListSanPham(model.getAllRows());
                } catch (SQLException ex) {
                    Logger.getLogger(QuanLySanPhamController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        view.addTableSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int row = view.getSelectedRow();
                    int col = view.getSelectedCol();

                    view.setValueAtIDTextFeild(view.getValueAtCell(row, 0));
                    view.setValueAtNameTextFeild(view.getValueAtCell(row, 1));
                    view.setValueAtCostTextFeild(view.getValueAtCell(row, 2));
                }
            }

        });
        view.updateListSanPham(tableModel.getSanPhamList());
        this.view = view;
    }

}
