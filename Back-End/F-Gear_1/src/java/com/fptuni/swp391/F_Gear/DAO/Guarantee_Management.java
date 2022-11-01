/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.swp391.F_Gear.DAO;

import com.fptuni.swp391.F_Gear.DTO.Guarantee;
import com.fptuni.swp391.F_Gear.DTO.Product;
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
public class Guarantee_Management {
    
    public List<Guarantee> selectAll(){
        List<Guarantee> list = null;        
        Connection con = DBUtils.getConnection();
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select GuaranteeID, Detail from Guarantee Order By GuaranteeID DESC");
            list = new ArrayList<>();
            while(rs.next()){
                Guarantee guarantee = new Guarantee();
                guarantee.setGuaranteeID(rs.getInt("GuaranteeID"));
                guarantee.setDetailGua(rs.getString("Detail"));
                //System.out.println(rs.getString("name"));
                list.add(guarantee);
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
    public boolean updateGuarantee(Guarantee guarantee) {
        boolean result = true;
        Connection con = DBUtils.getConnection();
        try {
            PreparedStatement stm = con.prepareStatement("update Guarantee set Detail=? WHERE GuaranteeID=?");
            stm.setString(1, guarantee.getDetailGua());
            stm.setInt(2, guarantee.getGuaranteeID());
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


    
    public boolean create(Guarantee guarantee){
        boolean result = true;
        Connection con = DBUtils.getConnection();
        try {
            PreparedStatement stm = con.prepareStatement("insert into Guarantee(Detail) values(?)");
            stm.setString(1, guarantee.getDetailGua());
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
    
    public List<Guarantee> searchGuarantee(String name) {
        List<Guarantee> list = new ArrayList<>();
        String query = "Select GuaranteeID, Detail from Guarantee Where Detail like '%" + name + "%'";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement stm = con.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Guarantee guarantee = new Guarantee();
                guarantee.setGuaranteeID(rs.getInt("GuaranteeID"));
                guarantee.setDetailGua(rs.getString("Detail"));
                list.add(guarantee);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
