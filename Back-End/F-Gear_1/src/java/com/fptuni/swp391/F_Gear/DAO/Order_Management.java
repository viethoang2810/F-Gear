/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.swp391.F_Gear.DAO;

import com.fptuni.swp391.F_Gear.DTO.Cart;
import com.fptuni.swp391.F_Gear.DTO.Item;
import com.fptuni.swp391.F_Gear.DTO.Users;
import com.fptuni.swp391.F_Gear.Utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author nguye
 */
public class Order_Management {
    
    public void addOrder(Users u, Cart cart) {
        LocalDate currentDate = java.time.LocalDate.now();
        String date = currentDate.toString();
        String query = "insert into dbo.Orders(UserName, OrderDate, TotalMoney) values (?, ?, ?)";
        try {
            //add order vanndh
            Connection con = DBUtils.getConnection();
            PreparedStatement stm = con.prepareStatement(query);
            stm.setString(1, u.getUserName());
            stm.setString(2, date);
            stm.setDouble(3, cart.getTotalMoney());
            stm.executeUpdate();
            String query1 = "select top 1 OrderID from dbo.Orders order by OrderID desc";
            PreparedStatement stm1 = con.prepareStatement(query1);
            ResultSet rs = stm1.executeQuery();
            //add order vao order details  vanndh
            while (rs.next()) {
                int orderID = rs.getInt(1);
                for (Item i : cart.getItems()) {
                    String query2 = "insert into OrderDetail(OrderID, ProID, Quantity, Price) values (?, ?, ?, ?)";
                    PreparedStatement stm2 = con.prepareStatement(query2);
                    stm2.setInt(1, orderID);
                    stm2.setInt(2, i.getProduct().getProID());
                    stm2.setInt(3, i.getQuantity());
                    stm2.setDouble(4, i.getPrice());
                    stm2.executeUpdate();
                }

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
