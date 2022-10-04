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
    
    //list show product - vanndh
    public List<Product> listProduct() {
        List<Product> list = new ArrayList<>();
        String query = "Select ProID, ProName, OriginalPrice, Discount, CurrentPrice, BrandID, CateID, Status from Product";
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
                product.setBrandID(rs.getInt("brandID"));
                product.setBrandID(rs.getInt("CateID"));
                product.setStatus(rs.getInt("status"));
                list.add(product);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    //function search Product -vanndh
    public List<Product> searchProduct(String name) {
        List<Product> list = new ArrayList<>();
        String query = "Select ProID, ProName, OriginalPrice, Discount, CurrentPrice, BrandID, CateID, Status from Product Where ProName like '%"+name+"%'";
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
                product.setBrandID(rs.getInt("brandID"));
                product.setCateID(rs.getInt("CateID"));
                product.setStatus(rs.getInt("status"));
                list.add(product);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    //fint product by Id - vanndh
    public Product findProductByID(int proID) { 
        Product product = null;
        Connection con = DBUtils.getConnection();
        String query = "Select ProID, ProName, OriginalPrice, Discount, CurrentPrice, Status from Product where ProID = ?";
        try {
            PreparedStatement stm = con.prepareStatement(query);
            stm.setInt(1, proID);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                product = new Product();
                product.setProID(rs.getInt("proID"));
                product.setProName(rs.getString("proName"));
                product.setProOriginalPrice(rs.getString("originalPrice"));
                product.setDiscount(rs.getInt("discount"));
                product.setProCurrentPrice(rs.getString("currentPrice"));
                product.setStatus(rs.getInt("status"));
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return product;
    }
    
    //update product - vanndh
    public boolean updateProduct(Product product) {
        boolean result = true;
        Connection con = DBUtils.getConnection();
        try {
            PreparedStatement stm = con.prepareStatement("update Product set ProName=?, OriginalPrice=?, Discount=?, CurrentPrice=?, Status=? WHERE ProID=?");
            stm.setString(1, product.getProName());
            stm.setString(2, product.getProOriginalPrice());
            stm.setInt(3, product.getDiscount());
            stm.setString(4, product.getProCurrentPrice());
            stm.setInt(5, product.getStatus());
            stm.setInt(6, product.getProID());
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
    

}
