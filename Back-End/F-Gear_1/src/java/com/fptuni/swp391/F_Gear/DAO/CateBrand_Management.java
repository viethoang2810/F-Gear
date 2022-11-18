/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.swp391.F_Gear.DAO;

import com.fptuni.swp391.F_Gear.DTO.Brand;
import com.fptuni.swp391.F_Gear.DTO.CateBrand;
import com.fptuni.swp391.F_Gear.DTO.Category;
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
public class CateBrand_Management {

    public List<CateBrand> listCateBrand = new ArrayList<>();
    public List<Brand> listBrand = new ArrayList<>();
    public List<Category> listCategory = new ArrayList<>();
    
    public List<CateBrand> getAllCateBrand() {
        Connection con = DBUtils.getConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        String sql = "Select C.CateName,"
                + "B.BrandName,"
                + "CB.CateID,"
                + "CB.BrandID,"
                + "CB.TypeWarranty,"
                + "CB.IntendTime,"
                + "CB.Note "
                + " From dbo.Brand B,"
                + "dbo.Category C,"
                + "dbo.CateBrand CB "
                + " Where B.BrandID = CB.BrandID AND C.CateID = CB.CateID";
        try {
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                CateBrand cb = new CateBrand();  
                cb.setCateName(rs.getString("CateName"));
                cb.setBrandName(rs.getString("BrandName"));
                cb.setCateID(rs.getInt("CateID"));
                cb.setBrandID(rs.getInt("BrandID"));
                cb.setTypePolicy(rs.getString("TypeWarranty"));
                cb.setIntendTime(rs.getString("IntendTime"));
                cb.setNote(rs.getString("Note"));
                listCateBrand.add(cb);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCateBrand;
    }
    
    public boolean create(CateBrand cateBrand){
        boolean result = true;
        Connection con = DBUtils.getConnection();
        try {
            PreparedStatement stm = con.prepareStatement("insert into CateBrand(CateID, BrandID, TypeWarranty, IntendTime, Note) values(?,?,?,?,?)");
            stm.setInt(1, cateBrand.getCateID());
            stm.setInt(2, cateBrand.getBrandID());
            stm.setString(3, cateBrand.getTypePolicy());
            stm.setString(4, cateBrand.getIntendTime());
            stm.setString(5, cateBrand.getNote());
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
    
    public boolean searchCateBrand(int CateID, int BrandID) {
        try {
            Connection con = DBUtils.getConnection();
            String query = "Select CateID, BrandID, TypeWarranty, IntendTime, Note from CateBrand Where CateID=" + CateID + "And BrandID=" + BrandID;
            PreparedStatement stm = con.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                //rs.getString("userName");
                return false;
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return true;
    }
    
    public boolean updateCateBrand(CateBrand cateBrand) {
        boolean result = true;
        Connection con = DBUtils.getConnection();
        try {
            PreparedStatement stm = con.prepareStatement("update CateBrand set TypeWarranty=?, IntendTime=?, Note=? WHERE CateID=? And BrandID=?");
            stm.setString(1, cateBrand.getTypePolicy());
            stm.setString(2, cateBrand.getIntendTime());
            stm.setString(3, cateBrand.getNote());
            stm.setInt(4, cateBrand.getCateID());
            stm.setInt(5, cateBrand.getBrandID());
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
    
//    public boolean remove(int cateID, int brandID) {
//        boolean result = true;
//        Connection con = DBUtils.getConnection();
//        try {
//            String query = "delete from dbo.CateBrand where cateID=? And brandID=?";           
//            PreparedStatement stm = con.prepareStatement(query);
//            stm.setInt(1, cateID);
//            stm.setInt(2, brandID);            
//            int count = stm.executeUpdate();
//            if (count == 0) {
//                result = false;
//            }
//            con.close();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            result = false;
//        }
//        return result;
//    }
    
    public List<CateBrand> search(String name) {    
        String sql = "Select C.CateName,"
                + "B.BrandName,"
                + "CB.CateID,"
                + "CB.BrandID,"
                + "CB.TypeWarranty,"
                + "CB.IntendTime,"
                + "CB.Note "
                + " From dbo.Brand B,"
                + "dbo.Category C,"
                + "dbo.CateBrand CB "
                + " Where B.BrandID = CB.BrandID AND C.CateID = CB.CateID AND B.CateName like '%" + name + "%'";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                CateBrand cb = new CateBrand();  
                cb.setCateName(rs.getString("CateName"));
                cb.setBrandName(rs.getString("BrandName"));
                cb.setCateID(rs.getInt("CateID"));
                cb.setBrandID(rs.getInt("BrandID"));
                cb.setTypePolicy(rs.getString("TypeWarranty"));
                cb.setIntendTime(rs.getString("IntendTime"));
                cb.setNote(rs.getString("Note"));
                listCateBrand.add(cb);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listCateBrand;
    }
    
}
