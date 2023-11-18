/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysanpham.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import quanlysanpham.model.SanPham;
import quanlysanpham.model.SanPhamTableModel;

/**
 *
 * @author Admin
 */
public class QuanLySanPhamView extends JFrame {

    SanPhamTableModel tableModel;
    JTable jTable_showInfo;
    JButton jButton_them;
    JTextField jTextField_id;
    JTextField jTextField_tenSanPham;
    JTextField jTextField_donGia;

    public QuanLySanPhamView() throws HeadlessException {
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init(new SanPhamTableModel());
        setLayout(new BorderLayout());
        add(new JLabel("Quan ly san pham"), BorderLayout.NORTH);
        JScrollPane jScrollPane = new JScrollPane(jTable_showInfo);
        jTable_showInfo.setPreferredScrollableViewportSize(new Dimension(500, 200));
        add(jScrollPane, BorderLayout.CENTER);
        //control panel
        JPanel inputPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(inputPanel, BoxLayout.Y_AXIS);
        inputPanel.setLayout(boxLayout);
        inputPanel.add(new JLabel("Trinh quan ly"));
        JPanel inputFeild = new JPanel(new GridLayout(3, 2));
        inputFeild.add(new JLabel("Ma san pham:"));
        inputFeild.add(jTextField_id);
        inputFeild.add(new JLabel("Ten san pham:"));
        inputFeild.add(jTextField_tenSanPham);
        inputFeild.add(new JLabel("Dơn gia san pham:"));
        inputFeild.add(jTextField_donGia);
        inputPanel.add(inputFeild);
        inputPanel.add(jButton_them);
        add(inputPanel, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }

    private void init(SanPhamTableModel model) {
        tableModel = model;
        jTable_showInfo = new JTable(model);
        jTable_showInfo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        jButton_them = new JButton("Them");
        jTextField_id = new JTextField();
        jTextField_tenSanPham = new JTextField();
        jTextField_donGia = new JTextField();
    }

    public void updateListSanPham(List<SanPham> list) {
        this.tableModel.setSanPhamList(list);
    }

    public void addAddButtonListener(ActionListener listener) {
        jButton_them.addActionListener(listener);
    }

    public void addTableSelectionMode() {
        jTable_showInfo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void addTableSelectionListener(ListSelectionListener listener) {
        jTable_showInfo.getSelectionModel().addListSelectionListener(listener);
        jTable_showInfo.getColumnModel().getSelectionModel().addListSelectionListener(listener);
    }

    public int getValueAtIDTextFeild() {
        return Integer.parseInt(jTextField_id.getText());
    }

    public String getValueAtNameTextFeild() {
        return String.valueOf(jTextField_tenSanPham.getText());
    }

    public BigDecimal getValueAtCostTextFeild() {
        return BigDecimal.valueOf(Double.parseDouble(jTextField_donGia.getText()));
    }

    public void setValueAtIDTextFeild(String id) {
        jTextField_id.setText(String.valueOf(id));
    }

    public void setValueAtNameTextFeild(String name) {
        jTextField_tenSanPham.setText(String.valueOf(name));
    }

    public void setValueAtCostTextFeild(String cost) {
        jTextField_donGia.setText(String.valueOf(cost));
    }

    public int getSelectedRow() {
        return jTable_showInfo.getSelectedRow();
    }

    public int getSelectedCol() {
        return jTable_showInfo.getSelectedColumn();
    }
    public String getValueAtCell(int row, int col){
        return String.valueOf(jTable_showInfo.getValueAt(row, col));
    }
}
