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
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        String sql = "SELECT P.ProID, "
                + "P.ProName,"
                + "P.OriginalPrice,"
                + "P.Discount,"
                + "P.CurrentPrice,"
                + "I.ImageID,"
                + "I.Url,"
                + "B.BrandName,"
                + "C.CateName,"
                + "S.SpecName,"
                + "PS.Detail"
                + " FROM dbo.Product P ,"
                + "dbo.Images I , "
                + "dbo.Brand B ,"
                + "dbo.Category C ,"
                + "dbo.Specification S,"
                + "dbo.ProSpec PS "
                + " WHERE P.BrandID = B.BrandID AND P.CateID = C.CateID AND I.ProID = P.ProID AND S.SpecID = PS.SpecID AND PS.ProID = P.ProID  ";

        try {
            con = DBUtils.getConnection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                if (listOfProduct.size() != 0) {
                    int pd = listOfProduct.get(listOfProduct.size() - 1).getProID(); //Check id of product is exist or not in arraylist
                    if (pd != 0) {
                        if (Integer.parseInt(rs.getString("ProID")) == pd) {
                            if (!listOfImages.get(listOfImages.size() - 1).getImageID().equals(rs.getString("ImageID"))) {
                                listOfImages.add(new Images(rs.getString("ImageID"), rs.getString("Url")));
                                listOfProduct.get(listOfProduct.size() - 1).setListImage(listOfImages);
                            }

                            if (!findKeyExistInArray(listOfSpecification, rs.getString("SpecName"))){
                                listOfSpecification.add(new Specification(rs.getString("SpecName"), rs.getString("Detail")));
                                listOfProduct.get(listOfProduct.size() - 1).setListSpecification(listOfSpecification);
                            }
                        } else {
                            Product product = new Product();
                            listOfSpecification = new ArrayList<>();
                            listOfImages = new ArrayList<>();

                            product.setProID(rs.getInt("ProID"));
                            product.setProName(rs.getString("ProName"));
                            product.setProOriginalPrice(rs.getInt("OriginalPrice"));
                            product.setDiscount(rs.getInt("Discount"));
                            product.setProCurrentPrice(rs.getInt("CurrentPrice"));
                            product.setBrandName(rs.getString("BrandName"));
                            product.setProType(rs.getString("CateName"));
                            listOfImages.add(new Images(rs.getString("ImageID"), rs.getString("Url")));
                            product.setListImage(listOfImages);
                            listOfSpecification.add(new Specification(rs.getString("SpecName"), rs.getString("Detail")));
                            product.setListSpecification(listOfSpecification);

                            listOfProduct.add(product);

                        }
                    }
                } else {
                    Product product = new Product();

                    product.setProID(rs.getInt("ProID"));
                    product.setProName(rs.getString("ProName"));
                    product.setProOriginalPrice(rs.getInt("OriginalPrice"));
                    product.setDiscount(rs.getInt("Discount"));
                    product.setProCurrentPrice(rs.getInt("CurrentPrice"));
                    product.setBrandName(rs.getString("BrandName"));
                    product.setProType(rs.getString("CateName"));
                    listOfImages.add(new Images(rs.getString("ImageID"), rs.getString("Url")));
                    product.setListImage(listOfImages);
                    listOfSpecification.add(new Specification(rs.getString("SpecName"), rs.getString("Detail")));
                    product.setListSpecification(listOfSpecification);

                    listOfProduct.add(product);
                }

            }
        } catch (Exception e) {
        }
        return listOfProduct;
    }
    
    public boolean findKeyExistInArray(ArrayList<Specification> specifications , String specName){
        for (Specification specification : specifications) {
            if(specification.getSpecName().equals(specName)){
                return true ;
            }
        }
        return false;
    }
}
