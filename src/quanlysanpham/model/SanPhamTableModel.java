/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysanpham.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.w3c.dom.views.AbstractView;

/**
 *
 * @author Admin
 */
public class SanPhamTableModel extends AbstractTableModel{
    List<SanPham> sanPhamList;
    static final String[] colNames={"ID", "Ten san pham", "Don gia"};

    public SanPhamTableModel() {
        sanPhamList= new ArrayList<>();
    }

    
    public List<SanPham> getSanPhamList() {
        return sanPhamList;
    }

    public void setSanPhamList(List<SanPham> sanPhamList) {
        this.sanPhamList = sanPhamList;
        fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return sanPhamList.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SanPham sp = sanPhamList.get(rowIndex);
        switch (columnIndex) {
            case 0 -> {
                return sp.getId();
            }
            case 1 -> {
                return sp.getTenSanPham();
            }
            case 2 -> {
                return sp.getDonGia();
            }
            default -> throw new AssertionError();
        }
    }
    
}
