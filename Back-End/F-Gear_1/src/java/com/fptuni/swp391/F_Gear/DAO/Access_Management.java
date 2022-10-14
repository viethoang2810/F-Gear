/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.swp391.F_Gear.DAO;

import com.fptuni.swp391.F_Gear.DTO.Chart;
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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        String sql = "select  UserName, Password, FullName, PhoneNumber, Avatar, Gender, R.RoleName from dbo.Users U , dbo.Roles R where UserName=? and password=? and U.RoleID = R.RoleID";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, userName);
        stm.setString(2, password);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            user = new Users();
            user.setUserName(rs.getString("UserName"));
            user.setPassword(rs.getString("Password"));
            user.setFullName(rs.getString("FullName"));
            user.setPhoneNumber(rs.getString("PhoneNumber"));
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
        stm.setString(3, u.getPhoneNumber());
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

    //select monthly sales -DungHQ
    public List<Chart> selectAllTotalEachMonth() {
        List<Chart> list = new ArrayList<>();
        String query = "select MONTH(o.OrderDate) as [month], sum(od.Total) as [total each month]\n"
                + "from Orders o inner join OrderDetail od on o.OrderID = od.OrderID group by MONTH(o.OrderDate)";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement stm = con.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Chart c = new Chart();
                c.setMonth(rs.getInt("month"));
                c.setTotal(rs.getInt("total each month"));

                list.add(c);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Access_Management.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    //select total product each month -DungHQ
    public List<Chart> selectAllQuantityEachMonth() {
        List<Chart> list = new ArrayList<>();
        String query = "select MONTH(o.OrderDate) as [month], sum(od.Quantity) as [quantity each month]\n"
                + "from Orders o inner join OrderDetail od on o.OrderID = od.OrderID group by MONTH(o.OrderDate)";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement stm = con.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Chart c = new Chart();
                c.setMonth(rs.getInt("month"));
                c.setQuantity(rs.getInt("quantity each month"));

                list.add(c);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Access_Management.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

//    Top product of all-time bestsellers -DungHQ
    public List<Chart> selectTop12SellingProductAllTime() {
        List<Chart> list = new ArrayList<>();
        String query = "select  p.ProName, sum(od.Quantity) as [total quantity] \n"
                + "from OrderDetail od , dbo.Product p, Orders o \n"
                + "where od.ProID = p.ProID and od.OrderID = o.OrderID  \n"
                + "group by p.ProName order by [total quantity] desc";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement stm = con.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Chart c = new Chart();
                c.setProName(rs.getString("ProName"));
                c.setQuantity(rs.getInt("total quantity"));
                list.add(c);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Access_Management.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    //    Top selling products month 1 -DUngHQ
    public List<Chart> selectTopSellingProductMonth1() {
        List<Chart> list = new ArrayList<>();
        String query = "select  p.ProName, sum(od.Quantity) as [total quantity], sum(od.Total) as [total sale]\n"
                + "from OrderDetail od , dbo.Product p, Orders o \n"
                + "where od.ProID = p.ProID and od.OrderID = o.OrderID \n"
                + "and month(o.OrderDate) = '1' group by p.ProName order by [total quantity] desc";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement stm = con.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Chart c = new Chart();
                c.setProName(rs.getString("ProName"));
                c.setQuantity(rs.getInt("total quantity"));
                c.setTotal(rs.getLong("total sale"));
                list.add(c);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Access_Management.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    //    Top selling products month 2 -DUngHQ
    public List<Chart> selectTopSellingProductMonth2() {
        List<Chart> list = new ArrayList<>();
        String query = "select  p.ProName, sum(od.Quantity) as [total quantity], sum(od.Total) as [total sale]\n"
                + "from OrderDetail od , dbo.Product p, Orders o \n"
                + "where od.ProID = p.ProID and od.OrderID = o.OrderID \n"
                + "and month(o.OrderDate) = '2' group by p.ProName order by [total quantity] desc";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement stm = con.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Chart c = new Chart();
                c.setProName(rs.getString("ProName"));
                c.setQuantity(rs.getInt("total quantity"));
                c.setTotal(rs.getLong("total sale"));
                list.add(c);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Access_Management.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    //    Top selling products month 3 -DUngHQ
    public List<Chart> selectTopSellingProductMonth3() {
        List<Chart> list = new ArrayList<>();
        String query = "select  p.ProName, sum(od.Quantity) as [total quantity], sum(od.Total) as [total sale]\n"
                + "from OrderDetail od , dbo.Product p, Orders o \n"
                + "where od.ProID = p.ProID and od.OrderID = o.OrderID \n"
                + "and month(o.OrderDate) = '3' group by p.ProName order by [total quantity] desc";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement stm = con.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Chart c = new Chart();
                c.setProName(rs.getString("ProName"));
                c.setQuantity(rs.getInt("total quantity"));
                c.setTotal(rs.getLong("total sale"));
                list.add(c);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Access_Management.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    //    Top selling products month 4 -DUngHQ
    public List<Chart> selectTopSellingProductMonth4() {
        List<Chart> list = new ArrayList<>();
        String query = "select  p.ProName, sum(od.Quantity) as [total quantity], sum(od.Total) as [total sale]\n"
                + "from OrderDetail od , dbo.Product p, Orders o \n"
                + "where od.ProID = p.ProID and od.OrderID = o.OrderID \n"
                + "and month(o.OrderDate) = '4' group by p.ProName order by [total quantity] desc";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement stm = con.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Chart c = new Chart();
                c.setProName(rs.getString("ProName"));
                c.setQuantity(rs.getInt("total quantity"));
                c.setTotal(rs.getLong("total sale"));
                list.add(c);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Access_Management.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    //    Top selling products month 5 -DUngHQ
    public List<Chart> selectTopSellingProductMonth5() {
        List<Chart> list = new ArrayList<>();
        String query = "select  p.ProName, sum(od.Quantity) as [total quantity], sum(od.Total) as [total sale]\n"
                + "from OrderDetail od , dbo.Product p, Orders o \n"
                + "where od.ProID = p.ProID and od.OrderID = o.OrderID \n"
                + "and month(o.OrderDate) = '5' group by p.ProName order by [total quantity] desc";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement stm = con.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Chart c = new Chart();
                c.setProName(rs.getString("ProName"));
                c.setQuantity(rs.getInt("total quantity"));
                c.setTotal(rs.getLong("total sale"));
                list.add(c);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Access_Management.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    //    Top selling products month 6 -DUngHQ
    public List<Chart> selectTopSellingProductMonth6() {
        List<Chart> list = new ArrayList<>();
        String query = "select  p.ProName, sum(od.Quantity) as [total quantity], sum(od.Total) as [total sale]\n"
                + "from OrderDetail od , dbo.Product p, Orders o \n"
                + "where od.ProID = p.ProID and od.OrderID = o.OrderID \n"
                + "and month(o.OrderDate) = '6' group by p.ProName order by [total quantity] desc";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement stm = con.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Chart c = new Chart();
                c.setProName(rs.getString("ProName"));
                c.setQuantity(rs.getInt("total quantity"));
                c.setTotal(rs.getLong("total sale"));
                list.add(c);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Access_Management.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    //    Top selling products month 7 -DUngHQ

    public List<Chart> selectTopSellingProductMonth7() {
        List<Chart> list = new ArrayList<>();
        String query = "select  p.ProName, sum(od.Quantity) as [total quantity], sum(od.Total) as [total sale]\n"
                + "from OrderDetail od , dbo.Product p, Orders o \n"
                + "where od.ProID = p.ProID and od.OrderID = o.OrderID \n"
                + "and month(o.OrderDate) = '7' group by p.ProName order by [total quantity] desc";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement stm = con.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Chart c = new Chart();
                c.setProName(rs.getString("ProName"));
                c.setQuantity(rs.getInt("total quantity"));
                c.setTotal(rs.getLong("total sale"));
                list.add(c);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Access_Management.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    //    Top selling products month 8 -DUngHQ
    public List<Chart> selectTopSellingProductMonth8() {
        List<Chart> list = new ArrayList<>();
        String query = "select  p.ProName, sum(od.Quantity) as [total quantity], sum(od.Total) as [total sale]\n"
                + "from OrderDetail od , dbo.Product p, Orders o \n"
                + "where od.ProID = p.ProID and od.OrderID = o.OrderID \n"
                + "and month(o.OrderDate) = '8' group by p.ProName order by [total quantity] desc";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement stm = con.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Chart c = new Chart();
                c.setProName(rs.getString("ProName"));
                c.setQuantity(rs.getInt("total quantity"));
                c.setTotal(rs.getLong("total sale"));
                list.add(c);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Access_Management.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    //    Top selling products month 9 -DUngHQ
    public List<Chart> selectTopSellingProductMonth9() {
        List<Chart> list = new ArrayList<>();
        String query = "select  p.ProName, sum(od.Quantity) as [total quantity], sum(od.Total) as [total sale]\n"
                + "from OrderDetail od , dbo.Product p, Orders o \n"
                + "where od.ProID = p.ProID and od.OrderID = o.OrderID \n"
                + "and month(o.OrderDate) = '9' group by p.ProName order by [total quantity] desc";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement stm = con.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Chart c = new Chart();
                c.setProName(rs.getString("ProName"));
                c.setQuantity(rs.getInt("total quantity"));
                c.setTotal(rs.getLong("total sale"));
                list.add(c);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Access_Management.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    //    Top selling products month 10 -DUngHQ
    public List<Chart> selectTopSellingProductMonth10() {
        List<Chart> list = new ArrayList<>();
        String query = "select  p.ProName, sum(od.Quantity) as [total quantity], sum(od.Total) as [total sale]\n"
                + "from OrderDetail od , dbo.Product p, Orders o \n"
                + "where od.ProID = p.ProID and od.OrderID = o.OrderID \n"
                + "and month(o.OrderDate) = '10' group by p.ProName order by [total quantity] desc";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement stm = con.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Chart c = new Chart();
                c.setProName(rs.getString("ProName"));
                c.setQuantity(rs.getInt("total quantity"));
                c.setTotal(rs.getLong("total sale"));
                list.add(c);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Access_Management.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    //    Top selling products month 11 -DUngHQ
    public List<Chart> selectTopSellingProductMonth11() {
        List<Chart> list = new ArrayList<>();
        String query = "select  p.ProName, sum(od.Quantity) as [total quantity], sum(od.Total) as [total sale]\n"
                + "from OrderDetail od , dbo.Product p, Orders o \n"
                + "where od.ProID = p.ProID and od.OrderID = o.OrderID \n"
                + "and month(o.OrderDate) = '11' group by p.ProName order by [total quantity] desc";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement stm = con.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Chart c = new Chart();
                c.setProName(rs.getString("ProName"));
                c.setQuantity(rs.getInt("total quantity"));
                c.setTotal(rs.getLong("total sale"));
                list.add(c);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Access_Management.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    //    Top selling products month 12 -DUngHQ

    public List<Chart> selectTopSellingProductMonth12() {
        List<Chart> list = new ArrayList<>();
        String query = "select  p.ProName, sum(od.Quantity) as [total quantity], sum(od.Total) as [total sale]\n"
                + "from OrderDetail od , dbo.Product p, Orders o \n"
                + "where od.ProID = p.ProID and od.OrderID = o.OrderID \n"
                + "and month(o.OrderDate) = '12' group by p.ProName order by [total quantity] desc";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement stm = con.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Chart c = new Chart();
                c.setProName(rs.getString("ProName"));
                c.setQuantity(rs.getInt("total quantity"));
                c.setTotal(rs.getLong("total sale"));
                list.add(c);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Access_Management.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    //select total product each month by laptop gaming types -DungHQ
    public List<Chart> selectLaptopGamingQuantityEachMonth() {
        List<Chart> list = new ArrayList<>();
        String query = "select MONTH(o.OrderDate) as [month], sum(od.Quantity) as [total quantity]\n"
                + "from dbo.Product p, dbo.OrderDetail od, dbo.Category c, Orders o\n"
                + "where c.CateID = p.CateID and p.ProID = od.ProID and o.OrderID = od.OrderID\n"
                + "and c.CateID = 1 group by MONTH(o.OrderDate) order by month(o.OrderDate)";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement stm = con.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Chart c = new Chart();
                c.setMonth(rs.getInt("month"));
                c.setQuantity(rs.getInt("total quantity"));
                list.add(c);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Access_Management.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    //select total product each month by office laptop types -DungHQ
    public List<Chart> selectOfficeLaptopQuantityEachMonth() {
        List<Chart> list = new ArrayList<>();
        String query = "select MONTH(o.OrderDate) as [month], sum(od.Quantity) as [total quantity]\n"
                + "from dbo.Product p, dbo.OrderDetail od, dbo.Category c, Orders o\n"
                + "where c.CateID = p.CateID and p.ProID = od.ProID and o.OrderID = od.OrderID\n"
                + "and c.CateID = 2 group by MONTH(o.OrderDate) order by month(o.OrderDate)";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement stm = con.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Chart c = new Chart();
                c.setMonth(rs.getInt("month"));
                c.setQuantity(rs.getInt("total quantity"));
                list.add(c);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Access_Management.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    //select total product each month by mouses types -DungHQ

    public List<Chart> selectMousesQuantityEachMonth() {
        List<Chart> list = new ArrayList<>();
        String query = "select MONTH(o.OrderDate) as [month], sum(od.Quantity) as [total quantity]\n"
                + "from dbo.Product p, dbo.OrderDetail od, dbo.Category c, Orders o\n"
                + "where c.CateID = p.CateID and p.ProID = od.ProID and o.OrderID = od.OrderID\n"
                + "and c.CateID = 3 group by MONTH(o.OrderDate) order by month(o.OrderDate)";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement stm = con.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Chart c = new Chart();
                c.setMonth(rs.getInt("month"));
                c.setQuantity(rs.getInt("total quantity"));
                list.add(c);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Access_Management.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    //select total product each month by headphones types -DungHQ

    public List<Chart> selectHeadPhonesQuantityEachMonth() {
        List<Chart> list = new ArrayList<>();
        String query = "select MONTH(o.OrderDate) as [month], sum(od.Quantity) as [total quantity]\n"
                + "from dbo.Product p, dbo.OrderDetail od, dbo.Category c, Orders o\n"
                + "where c.CateID = p.CateID and p.ProID = od.ProID and o.OrderID = od.OrderID\n"
                + "and c.CateID = 4 group by MONTH(o.OrderDate) order by month(o.OrderDate)";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement stm = con.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Chart c = new Chart();
                c.setMonth(rs.getInt("month"));
                c.setQuantity(rs.getInt("total quantity"));
                list.add(c);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Access_Management.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public Users findByUsernameAndGmail(String userName, String gmail) throws SQLException {
        Users user = null;
        Connection con = DBUtils.getConnection();
        String sql = "select UserName, Password, Gmail from dbo.Users where UserName=? and Gmail=?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, userName);
        stm.setString(2, gmail);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            user = new Users();
            user.setUserName(rs.getString("UserName"));
            user.setPassword(rs.getString("Password"));
            user.setGmail(rs.getString("Gmail"));
        }
        con.close();
        return user;
    }

}
