/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysanpham.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class SanPhamDAO {
    public List<SanPham> getAllRows() throws SQLException{
        List<SanPham> result= new ArrayList<>();
        Connection c = JDBCConnectionSingleton.connect();
        PreparedStatement preparedStatement = c.prepareStatement("select * from san_pham");
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            int id = resultSet.getInt("ID");
            String ten = resultSet.getString("Ten san pham");
            BigDecimal donGia = resultSet.getBigDecimal("Don gia");
            result.add(new SanPham(id, ten, donGia));
        }
        for (SanPham sanPham : result) {
            System.out.println(sanPham.toString());
        }
        preparedStatement.close();
        return result;
    }
    public void themSanPham(SanPham sp) throws SQLException{
        Connection c = JDBCConnectionSingleton.connect();
        PreparedStatement preparedStatement = c.prepareStatement("insert into san_pham values (NULL,?,?)");
        preparedStatement.setString(1, sp.getTenSanPham());
        preparedStatement.setBigDecimal(2, sp.getDonGia());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
}
