/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.swp391.F_Gear.DAO;

import com.fptuni.swp391.F_Gear.DTO.Images;
import com.fptuni.swp391.F_Gear.DTO.Product;
import com.fptuni.swp391.F_Gear.DTO.Specification;
import com.fptuni.swp391.F_Gear.Utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Product_Management {

    public ArrayList<Product> listOfProduct = new ArrayList<>();
    public ArrayList<Specification> listOfSpecification = new ArrayList<>();
    public ArrayList<Images> listOfImages = new ArrayList<>();

    public ArrayList<Product> getAllOfProduct() {
        Connection con = DBUtils.getConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;

        String sql = "SELECT P.ProID, \n"
                + "	   P.ProName,\n"
                + "	   P.OriginalPrice,\n"
                + "	   P.CurrentPrice,\n"
                + "	   I.ImageID,\n"
                + "	   I.Url,\n"
                + "	   B.BrandName,\n"
                + "	   C.CateName,\n"
                + "	   S.SpecName,\n"
                + "	   PS.Detail\n"
                + "FROM dbo.Product P ,\n"
                + "	 dbo.Images I , \n"
                + "	 dbo.Brand B ,\n"
                + "	 dbo.Category C ,\n"
                + "	 dbo.Specification S,\n"
                + "	 dbo.ProSpec PS\n"
                + "WHERE P.ProID =I.ImageID AND \n"
                + "	  P.BrandID = B.BrandID AND \n"
                + "	  P.CateID = C.CateID AND\n"
                + "	  PS.ProID = P.ProID AND\n"
                + "	  S.SpecID = PS.SpecID AND \n"
                + "	  P.ProID = I.ProID";
        try {
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                int pd = listOfProduct.get(listOfProduct.size() - 1).getProID();
                if (Integer.parseInt(rs.getString("ProID")) == pd) {
                    listOfImages.add(new Images(rs.getString("ImageID"), rs.getString("Url")));
                    listOfProduct.get(listOfProduct.size() - 1).setListImage(listOfImages);

                    listOfSpecification.add(new Specification(rs.getString("SpecName"), rs.getString("Detail")));
                    listOfProduct.get(listOfProduct.size() - 1).setListSpecification(listOfSpecification);
                } else {
                    Product product = new Product();
                    listOfSpecification = new ArrayList<>();
                    listOfImages = new ArrayList<>();

                    product.setProID(Integer.parseInt(rs.getString("ProID")));
                    product.setProName(rs.getString("ProName"));
                    product.setProOriginalPrice((int) Double.parseDouble(rs.getString("OriginalPrice")));
                    product.setDiscount((int) Double.parseDouble(rs.getString("Discount")));
                    product.setProCurrentPrice((int) Double.parseDouble(rs.getString("CurrentPrice")));
                    product.setBrandName(rs.getString("BrandName"));
                    product.setProType(rs.getString("CateName"));
                    listOfImages.add(new Images(rs.getString("ImageID"), rs.getString("Url")));
                    product.setListImage(listOfImages);
                    listOfSpecification.add(new Specification(rs.getString("SpecName"), rs.getString("Detail")));
                    product.setListSpecification(listOfSpecification);
                }
            }
        } catch (Exception e) {
        }
        return listOfProduct;
    }
}
