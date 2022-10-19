/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.swp391.F_Gear.DAO;

import com.fptuni.swp391.F_Gear.Utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class User_Management {

    public boolean updateUserAvatar(String imagePath, String username) {
        Connection conn = DBUtils.getConnection();
        PreparedStatement stm = null;
        int checkUpdate = 0;

        String query = " UPDATE dbo.Users SET Avatar='"+imagePath+"' WHERE UserName = '"+username+"'";

        try {
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(query);
            checkUpdate = stm.executeUpdate();

            if (checkUpdate != 0) {
                return true;
            }

        } catch (Exception e) {
            System.out.println("Can't update avatar");
        }
        return false;
    }
    
    //This method uses to update user infor such as full name , phone number and gender
    public boolean updateUserInfor(String fullName , String phoneNumber , String gender,String username){
        Connection conn = DBUtils.getConnection();
        PreparedStatement stm = null;
        int checkUpdate = 0;
        String sql = "UPDATE dbo.Users SET FullName = '"+fullName+"', PhoneNumber = "+phoneNumber+" , Gender = '"+gender+"' WHERE UserName = '"+username+"'" ;
        
        try {
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(sql);
            
            
            checkUpdate = stm.executeUpdate();
            
            if(checkUpdate > 0){
                return true ;
            }
        } catch (Exception e) {
        }
        return false;
    }
    
    public static boolean updateUserPassword(String password, String username) {
        Connection conn = DBUtils.getConnection();
        PreparedStatement stm = null;
        int checkUpdate = 0;

        String query = " UPDATE dbo.Users SET Password='"+password+"' WHERE UserName = '"+username+"'";

        try {
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(query);
            checkUpdate = stm.executeUpdate();

            if (checkUpdate != 0) {
                return true;
            }

        } catch (Exception e) {
            System.out.println("Can't update password");
        }
        return false;
    }
    
}
