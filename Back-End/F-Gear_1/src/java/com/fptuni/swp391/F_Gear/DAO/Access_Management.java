/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.swp391.F_Gear.DAO;

import com.fptuni.swp391.F_Gear.DTO.Users;
import com.fptuni.swp391.F_Gear.Utils.Constants;
import com.fptuni.swp391.F_Gear.Utils.DBUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
//import org.apache.tomcat.util.net.Constants;


/**
 *
 * @author Admin
 */
public class Access_Management {

    public static Users check(String userName, String password) throws SQLException, ClassNotFoundException {
        Users user = null;
        Connection con = DBUtils.getConnection();
        String sql = "select  UserName, Password, FullName, PhoneNumber, Avatar, Gender, R.RoleName from dbo.Users U , dbo.Roles R where UserName=? and password=? ";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, userName);
        stm.setString(2, password);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            user = new Users();
            user.setUserName(rs.getString("UserName"));
            user.setPassword(rs.getString("Password"));
            user.setFullName(rs.getString("FullName"));
            user.setPhoneNumber(rs.getInt("PhoneNumber"));
            user.setAvatar(rs.getString("Avatar"));
            user.setGender(rs.getString("Gender"));
            user.setRoleName(rs.getString("RoleName"));
        }
        con.close();
        return user;
    }

    //check của register
    public boolean checkUserName(String userName) throws SQLException, ClassNotFoundException {
        Connection con = DBUtils.getConnection();
        String sql = "select UserName from Users where UserName=?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, userName);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            rs.getString("userName");
            return false;
        }
        con.close();
        return true;
    }

    public boolean signUp(Users u) throws SQLException {
        boolean result = true;
        Connection con = DBUtils.getConnection();
        PreparedStatement stm = con.prepareStatement("insert into Users (UserName, Password, PhoneNumber) values(?,?,?)");
        stm.setString(1, u.getUserName());
        stm.setString(2, u.getPassword());
        stm.setInt(3, u.getPhoneNumber());
        int count = stm.executeUpdate();
        if (count == 0) {
            result = false;
        }
        con.close();
        return result;
    }

    //hàm này dùng để mã hoá mật khẩu
    public String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            return convertByteToHex1(messageDigest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public String convertByteToHex1(byte[] data) {
        BigInteger number = new BigInteger(1, data);
        String hashtext = number.toString(16);
        // Now we need to zero pad it if you actually want the full 32 chars.
        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
        return hashtext;
    }

    public static String getToken(String code) throws ClientProtocolException, IOException {
        // call api to get token
        String response = Request.Post(Constants.GOOGLE_LINK_GET_TOKEN)
                .bodyForm(Form.form().add("client_id", Constants.GOOGLE_CLIENT_ID)
                        .add("client_secret", Constants.GOOGLE_CLIENT_SECRET)
                        .add("redirect_uri", Constants.GOOGLE_REDIRECT_URI).add("code", code)
                        .add("grant_type", Constants.GOOGLE_GRANT_TYPE).build())
                .execute().returnContent().asString();

        JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
        String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
        return accessToken;
    }

    public static String getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
        String link = Constants.GOOGLE_LINK_GET_USER_INFO + accessToken;
        String response = Request.Get(link).execute().returnContent().asString();
        return response;
    }

    public boolean signUpWithGoogle(Users u) throws SQLException {
        boolean result = true;
        Connection con = DBUtils.getConnection();
        PreparedStatement stm = con.prepareStatement("insert into Users (UserName, Avatar, FullName) values(?,?,?)");
        stm.setString(1, u.getUserName());
        stm.setString(2, u.getAvatar());
        stm.setString(3, u.getFullName());
        int count = stm.executeUpdate();
        if (count == 0) {
            result = false;
        }
        con.close();
        return result;
    }
    
}
