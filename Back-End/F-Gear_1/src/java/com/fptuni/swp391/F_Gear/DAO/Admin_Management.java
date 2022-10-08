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
    public boolean updateProduct(int proID, String name, int originalPrice, int discount) {
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement stm = null;
            String sql = "UPDATE dbo.Product SET OriginalPrice = ? , Discount = ? , CurrentPrice = ? WHERE ProID = ?";
            int insertCheck = 0;
            stm = conn.prepareStatement(sql);
            stm.setInt(0, originalPrice);
            stm.setInt(1, discount);
            stm.setInt(2, calculateDiscount(discount , originalPrice));
            stm.setInt(3, proID);
            insertCheck = stm.executeUpdate();
            if (insertCheck > 0) {
                return true;
            }
        } catch (Exception e) {
            return false;

        }
        return false;
    }
    
    public int calculateDiscount(int discount, int originalPrice) {
        return originalPrice - (originalPrice * discount/100)  ;
    }
}
