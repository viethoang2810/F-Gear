/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.swp391.F_Gear.DAO;

import com.fptuni.swp391.F_Gear.DTO.Brand;
import com.fptuni.swp391.F_Gear.Utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguye
 */
public class Brand_Management {
    
    public List<Brand> selectAll(){
        List<Brand> list = null;        
        Connection con = DBUtils.getConnection();
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select BrandID, BrandName from dbo.Brand Order By BrandID DESC");
            list = new ArrayList<>();
            while(rs.next()){
                Brand brand = new Brand();
                brand.setBrandID(rs.getInt("BrandID"));
                brand.setBrandName(rs.getString("BrandName"));
                //System.out.println(rs.getString("name"));
                list.add(brand);
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
    public boolean updateBrand(Brand brand) {
        boolean result = true;
        Connection con = DBUtils.getConnection();
        try {
            PreparedStatement stm = con.prepareStatement("update Brand set BrandName=? WHERE BrandID=?");
            stm.setString(1, brand.getBrandName());
            stm.setInt(2, brand.getBrandID());
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
    
    public boolean create(Brand brand){
        boolean result = true;
        Connection con = DBUtils.getConnection();
        try {
            PreparedStatement stm = con.prepareStatement("insert into Brand(BrandName) values(?)");
            stm.setString(1, brand.getBrandName());
            int count = stm.executeUpdate();
            if(count == 0){
                result = false;
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            result = false;
        }
        return result;
    }
    
    public List<Brand> searchBrand(String name) {
        List<Brand> list = new ArrayList<>();
        String query = "Select BrandID, BrandName from Brand Where BrandName like '%" + name + "%'";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement stm = con.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Brand brand = new Brand();
                brand.setBrandID(rs.getInt("BrandID"));
                brand.setBrandName(rs.getString("BrandName"));
                list.add(brand);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
