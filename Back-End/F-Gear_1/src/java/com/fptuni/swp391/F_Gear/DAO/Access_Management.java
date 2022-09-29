/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.swp391.F_Gear.DAO;

import com.fptuni.swp391.F_Gear.DTO.Users;
import com.fptuni.swp391.F_Gear.Utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class Access_Management {

    //check của login
    public static Users check(String userName, int password) throws SQLException, ClassNotFoundException {
        Users user = null;
        Connection con = DBUtils.getConnection();
        String sql = "select UserName, Password from Users where UserName=? and password=?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, userName);
        stm.setInt(2, password);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            user = new Users();
            user.setUserName(rs.getString("userName"));
            user.setPassword(rs.getInt("password"));
        }
        con.close();
        return user;
    }
    
    //check của register
    public static Users check(String userName) throws SQLException, ClassNotFoundException {
        Users user = null;
        Connection con = DBUtils.getConnection();
        String sql = "select UserName from Users where UserName=?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, userName);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            user = new Users();
            user.setUserName(rs.getString("userName"));
        }
        con.close();
        return user;
    }
    
    public static boolean signUp(Users u) throws SQLException {
        boolean result = true;
        Connection con = DBUtils.getConnection();
        PreparedStatement stm = con.prepareStatement("insert into Users (UserName, Password, PhoneNumber) values(?,?,?)");
        stm.setString(1, u.getUserName());
        stm.setInt(2, u.getPassword());
        stm.setInt(3, u.getPhoneNumber());
        int count = stm.executeUpdate();
        if (count == 0) {
            result = false;
        }
        con.close();
        return result;
    }
}
