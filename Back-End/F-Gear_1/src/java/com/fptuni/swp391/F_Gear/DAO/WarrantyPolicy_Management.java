/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.swp391.F_Gear.DAO;

import com.fptuni.swp391.F_Gear.DTO.WarrantyPolicy;
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
public class WarrantyPolicy_Management {

    public List<WarrantyPolicy> selectAll() {
        List<WarrantyPolicy> list = null;
        Connection con = DBUtils.getConnection();
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select PolicyID, CateName, BrandName, TypeWarranty, IntendTime, Note from WarrantyPolicy Order By PolicyID DESC");
            list = new ArrayList<>();
            while (rs.next()) {
                WarrantyPolicy wp = new WarrantyPolicy();
                wp.setWaID(rs.getInt("PolicyID"));
                wp.setCateName(rs.getString("CateName"));
                wp.setBrandName(rs.getString("BrandName"));
                wp.setTypeWarranty(rs.getString("TypeWarranty"));
                wp.setIntendTime(rs.getString("IntendTime"));
                wp.setNote(rs.getString("Note"));
                //System.out.println(rs.getString("name"));
                list.add(wp);
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<WarrantyPolicy> searchPolicy(String name) {
        List<WarrantyPolicy> list = new ArrayList<>();
        String query = "Select PolicyID, CateName, BrandName, TypeWarranty, IntendTime, Note from WarrantyPolicy Where BrandName like '%" + name + "%'";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement stm = con.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                WarrantyPolicy wp = new WarrantyPolicy();
                wp.setWaID(rs.getInt("PolicyID"));
                wp.setCateName(rs.getString("CateName"));
                wp.setBrandName(rs.getString("BrandName"));
                wp.setTypeWarranty(rs.getString("TypeWarranty"));
                wp.setIntendTime(rs.getString("IntendTime"));
                wp.setNote(rs.getString("Note"));
                //System.out.println(rs.getString("name"));
                list.add(wp);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean create(WarrantyPolicy policy) {
        boolean result = true;
        Connection con = DBUtils.getConnection();
        try {
            PreparedStatement stm = con.prepareStatement("insert into WarrantyPolicy(CateName, BrandName, TypeWarranty, IntendTime, Note) values (?,?,?,?,?)");
            stm.setString(1, policy.getCateName());
            stm.setString(2, policy.getBrandName());
            stm.setString(3, policy.getTypeWarranty());
            stm.setString(4, policy.getIntendTime());
            stm.setString(5, policy.getNote());
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

    public boolean remove(int id) {
        boolean result = true;
        Connection con = DBUtils.getConnection();
        try {
            String query = "delete from dbo.WarrantyPolicy where PolicyID = ?";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setInt(1, id);
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
    
    public boolean update(WarrantyPolicy policy) {
        boolean result = true;
        Connection con = DBUtils.getConnection();
        try {
            PreparedStatement stm = con.prepareStatement("update WarrantyPolicy set CateName=?, BrandName=?, TypeWarranty=?, IntendTime=?, Note=? where PolicyID=?");
            stm.setString(1, policy.getCateName());
            stm.setString(2, policy.getBrandName());
            stm.setString(3, policy.getTypeWarranty());
            stm.setString(4, policy.getIntendTime());
            stm.setString(5, policy.getNote());
            stm.setInt(6, policy.getWaID());
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
