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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public List<Product> selectTop8InHomepage() {
        List<Product> list = new ArrayList<>();
        String query = "SELECT top 8 b.BrandName, p.ProID, p.ProName, p.OriginalPrice, i.ImageID, i.Url  \n"
                + "FROM Category c, Brand b, Product p, Images i \n"
                + "  WHERE c.CateID = p.CateID AND b.BrandID = p.BrandID AND i.ProID = p.ProID AND i.ImageTypeID = 1 AND c.CateName LIKE '%Laptop%'";
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement stm = con.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
//                int pd = listOfProduct.get(listOfProduct.size() - 1).getProID();
                Product p = new Product();
//                Images i = new Images();
//                listOfImages = new ArrayList<>();
                p.setBrandName(rs.getString("BrandName"));
                p.setProID(Integer.parseInt(rs.getString("ProID")));
                p.setProName(rs.getString("ProName"));
                p.setProOriginalPrice(Integer.parseInt(rs.getString("OriginalPrice")));
//                i.setImageID(rs.getString("ImageID"));
//                i.setUrl(rs.getString("Url"));
                listOfImages.add(new Images(rs.getString("ImageID"), rs.getString("Url")));
//                listOfImages.add(i);
                p.setListImage(listOfImages);
                list.add(p);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Product_Management.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public Product getProductById(ArrayList<Product> listProduct , int id){
        for (Product product : listProduct) {
            if(product.getProID() == id){
                return product ;
            }
        }
        return null;
    }
}
