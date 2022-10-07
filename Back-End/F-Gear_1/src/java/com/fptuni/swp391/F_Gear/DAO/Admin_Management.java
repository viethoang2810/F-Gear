/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.swp391.F_Gear.DAO;

import com.fptuni.swp391.F_Gear.DTO.Brand;
import com.fptuni.swp391.F_Gear.DTO.Product;
import com.fptuni.swp391.F_Gear.Utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguye
 */
public class Admin_Management {

    //update product - vanndh
    public boolean updateProduct(Product product) {
        boolean result = true;
        Connection con = DBUtils.getConnection();
        try {
            PreparedStatement stm = con.prepareStatement("update Product set ProName=?, OriginalPrice=?, Discount=?, CurrentPrice=? WHERE ProID=?");
            stm.setString(1, product.getProName());
            stm.setString(2, product.getProOriginalPrice());
            stm.setInt(3, product.getDiscount());
            stm.setString(4, product.getProCurrentPrice());
            stm.setInt(5, product.getProID());
            int count = stm.executeUpdate();
            if (count == 0) {
                result = false;
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            result = false;
        }
        return result;
    }

    //remove Product -vanndh
    public boolean remove(int id) {
        boolean result = true;
        Connection con = DBUtils.getConnection();
        try {
            String query = "delete from dbo.ProSpec where ProID = ?";
            String query1 = "delete from dbo.Images where ProID = ?";
            String query2 = "delete from dbo.Product where ProID = ?";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setInt(1, id);
            PreparedStatement stm1 = con.prepareStatement(query1);
            stm1.setInt(1, id);
            PreparedStatement stm2 = con.prepareStatement(query2);
            stm2.setInt(1, id);
            int count = stm.executeUpdate();
            int count1 = stm1.executeUpdate();
            int count2 = stm2.executeUpdate();
            if (count == 0 && count1 == 0 && count2 == 0) {
                result = false;
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            result = false;
        }
        return result;
    }

    //function search Product -vanndh
    public List<Product> searchProduct(String name) {
        List<Product> list = new ArrayList<>();
        String query = "Select ProID, ProName, OriginalPrice, Discount, CurrentPrice from Product Where ProName like '%" + name + "%'";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement stm = con.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProID(rs.getInt("proID"));
                product.setProName(rs.getString("proName"));
                product.setProOriginalPrice(rs.getString("originalPrice"));
                product.setDiscount(rs.getInt("discount"));
                product.setProCurrentPrice(rs.getString("currentPrice"));
                list.add(product);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

}
