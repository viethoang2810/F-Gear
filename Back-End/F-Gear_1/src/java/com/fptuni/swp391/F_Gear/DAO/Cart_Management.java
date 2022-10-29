/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.swp391.F_Gear.DAO;

import com.fptuni.swp391.F_Gear.DTO.Item;
import com.fptuni.swp391.F_Gear.DTO.Orders;
import com.fptuni.swp391.F_Gear.DTO.Product;
import com.fptuni.swp391.F_Gear.DTO.Users;
import com.fptuni.swp391.F_Gear.Utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dell
 */
public class Cart_Management {

    Connection con = DBUtils.getConnection();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    LocalDateTime now = LocalDateTime.now();

    public List<Orders> listOrder() {
        List<Orders> list = new ArrayList<>();
//        String query = "Select ProID, ProName, OriginalPrice, Discount, CurrentPrice from Product Where ProName like '%" + name + "%'";
        String query = "select OrderID, UserName, OrderDate from dbo.Orders";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement stm = con.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Orders o = new Orders();
                o.setOrderId(rs.getInt("OrderID"));
                o.setUserName(rs.getString("UserName"));
                o.setOrderDate(rs.getString("OrderDate"));
                list.add(o);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    //dunghq
//    public boolean createOrder(Users u, Product p, Orders o, int quantity, long price) {
//        boolean result = true;
//
//        try {
//            PreparedStatement stm = con.prepareStatement("insert into dbo.Orders(UserName, OrderDate) values (?, ?)");
//            stm.setString(1, u.getUserName());
//            stm.setString(2, dtf.format(now));
//            int count = stm.executeUpdate();
//            if (count == 0) {
//                result = false;
//            }
//
//            PreparedStatement stm1 = con.prepareStatement("insert into dbo.OrderDetail(OrderID, ProID, Quantity, Total) values (?, ?, ?, ?)");
//            stm1.setInt(1, o.getOrderId());
//            stm1.setInt(2, p.getProID());
//            stm1.setInt(3, quantity);
//            stm1.setLong(4, price);
//            int count1 = stm1.executeUpdate();
//            if (count1 == 0) {
//                result = false;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
    public boolean createOrder(Users u) {
        boolean result = true;

        try {
            PreparedStatement stm = con.prepareStatement("insert into dbo.Orders(UserName, OrderDate) values (?, ?)");
            stm.setString(1, u.getUserName());
            stm.setString(2, dtf.format(now));
            int count = stm.executeUpdate();
            if (count == 0) {
                result = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean createOrderDetail(Orders o, Product p, int quantity, long price) {
        boolean result = true;

        try {
            PreparedStatement stm1 = con.prepareStatement("insert into dbo.OrderDetail(OrderID, ProID, Quantity, Total) values (?, ?, ?, ?)");
            stm1.setInt(1, o.getOrderId());
            stm1.setInt(2, p.getProID());
            stm1.setInt(3, quantity);
            stm1.setLong(4, price);
            int count1 = stm1.executeUpdate();
            if (count1 == 0) {
                result = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public boolean findItemInCart(int proID ,List<Item> listItem){
        for (Item item : listItem) {
            if(item.getProduct().getProID() == proID){
                return true ;
            }
        }
        return false;
    }
}
