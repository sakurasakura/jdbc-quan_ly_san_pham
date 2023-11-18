/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysanpham.model;

import java.math.BigDecimal;

/**
 *
 * @author Admin
 */
public class SanPham {
    private int id;
    private String tenSanPham;
    private BigDecimal donGia;

    public SanPham(int id, String tenSanPham, BigDecimal donGia) {
        this.id = id;
        this.tenSanPham = tenSanPham;
        this.donGia = donGia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    @Override
    public String toString() {
        return "SanPham{" + "id=" + id + ", tenSanPham=" + tenSanPham + ", donGia=" + donGia + '}';
    }
    
}
