/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.swp391.F_Gear.DAO;

import com.fptuni.swp391.F_Gear.DTO.Account;
import com.fptuni.swp391.F_Gear.Utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class AccountManagement {
    public DecimalFormat formatter = new DecimalFormat("###,###,###");

    public ArrayList<Account> getAccountsInformations() {
        ArrayList<Account> listOfAccounts = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        String sql = "   SELECT U.UserName , U.FullName ,U.PhoneNumber,U.Gender,COUNT(O.UserName) AS TotalOrder , SUM(OD.Total) AS TotalMoney"
                + "  FROM dbo.Users U, dbo.Orders O ,dbo.OrderDetail OD"
                + "  WHERE   U.UserName = O.UserName  "
                + "  GROUP BY U.UserName , U.FullName ,U.PhoneNumber,U.Gender";
        try {
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setUsername(rs.getString("UserName"));
                account.setFullname(rs.getString("FullName"));
                account.setPhoneNumber(rs.getInt("PhoneNumber"));
                account.setGender(rs.getString("Gender"));
                account.setTotalOrder(rs.getInt("TotalOrder"));
                account.setTotalPrice( formatter.format(rs.getInt("TotalMoney")));
               
                listOfAccounts.add(account);
            }
        } catch (Exception e) {
        }
        return listOfAccounts;
    }
     public ArrayList<Account> getAccountSorting(String keySort) {
        ArrayList<Account> listOfAccountsAfterSort = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        String sql = "SELECT U.UserName , U.FullName ,U.PhoneNumber,U.Gender,COUNT(O.UserName) AS TotalOrder , SUM(OD.Total) AS TotalMoney"
                + "  FROM dbo.Users U, dbo.Orders O ,dbo.OrderDetail OD"
                + "  WHERE   U.UserName = O.UserName  "
                + "  GROUP BY U.UserName , U.FullName ,U.PhoneNumber,U.Gender ORDER BY  TotalOrder "+keySort;
        try {
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setUsername(rs.getString("UserName"));
                account.setFullname(rs.getString("FullName"));
                account.setPhoneNumber(rs.getInt("PhoneNumber"));
                account.setGender(rs.getString("Gender"));
                account.setTotalOrder(rs.getInt("TotalOrder"));
                account.setTotalPrice( formatter.format(rs.getInt("TotalMoney")));
               
                listOfAccountsAfterSort.add(account);
            }
        } catch (Exception e) {
        }
        return listOfAccountsAfterSort;
    }
}
