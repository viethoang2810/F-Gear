/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.swp391.F_Gear.DAO;

import com.fptuni.swp391.F_Gear.DTO.Category;
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
public class Category_Management {
    
    public List<Category> selectAll(){
        List<Category> list = null;        
        Connection con = DBUtils.getConnection();
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select CateID, CateName from Category Order By CateID DESC");
            list = new ArrayList<>();
            while(rs.next()){
                Category category = new Category();
                category.setCateID(rs.getInt("CateID"));
                category.setCateName(rs.getString("CateName"));
                //System.out.println(rs.getString("name"));
                list.add(category);
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
    public boolean updateCategory(Category category) {
        boolean result = true;
        Connection con = DBUtils.getConnection();
        try {
            PreparedStatement stm = con.prepareStatement("update Category set CateName=? WHERE CateID=?");
            stm.setString(1, category.getCateName());
            stm.setInt(2, category.getCateID());
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


    
    public boolean create(Category category){
        boolean result = true;
        Connection con = DBUtils.getConnection();
        try {
            PreparedStatement stm = con.prepareStatement("insert into Category(CateName) values(?)");
            stm.setString(1, category.getCateName());
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
    
    public List<Category> searchCategory(String name) {
        List<Category> list = new ArrayList<>();
        String query = "Select CateID, CateName from Category Where CateName like '%" + name + "%'";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement stm = con.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setCateID(rs.getInt("CateID"));
                category.setCateName(rs.getString("CateName"));
                list.add(category);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
