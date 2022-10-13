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
import java.text.DecimalFormat;
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
    public DecimalFormat formatter = new DecimalFormat("###,###,###");

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

                            if (!findKeyExistInArray(listOfSpecification, rs.getString("SpecName"))) {
                                listOfSpecification.add(new Specification(rs.getString("SpecName"), rs.getString("Detail")));
                                listOfProduct.get(listOfProduct.size() - 1).setListSpecification(listOfSpecification);
                            }
                        } else {
                            Product product = new Product();
                            listOfSpecification = new ArrayList<>();
                            listOfImages = new ArrayList<>();

                            product.setProID(rs.getInt("ProID"));
                            product.setProName(rs.getString("ProName"));

                            product.setProOriginalPrice(formatter.format(rs.getInt("OriginalPrice")));
                            product.setProCurrentPrice(formatter.format(calculateDiscount(rs.getInt("Discount"), rs.getInt("OriginalPrice"))));
                            product.setDiscount(rs.getInt("Discount"));
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
                    product.setProOriginalPrice(formatter.format(rs.getInt("OriginalPrice")));

                    product.setDiscount(rs.getInt("Discount"));
                    product.setProCurrentPrice(formatter.format(calculateDiscount(rs.getInt("Discount"), rs.getInt("OriginalPrice"))));
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

    public boolean findKeyExistInArray(ArrayList<Specification> specifications, String specName) {
        for (Specification specification : specifications) {
            if (specification.getSpecName().equals(specName)) {
                return true;
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
                p.setProOriginalPrice(formatter.format(rs.getInt("OriginalPrice")));

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

    public Product getProductById(ArrayList<Product> listProduct, int id) {
        for (Product product : listProduct) {
            if (product.getProID() == id) {
                return product;
            }
        }
        return null;
    }

    public ArrayList<Product> getAllOfProductAfterSort(String typeSort) {
        Connection con = DBUtils.getConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        String orderBy = "";
        switch (typeSort) {
            case "price_ASC":
                orderBy = "ORDER BY P.OriginalPrice ASC";
                break;
            case "price_DESC":
                orderBy = "ORDER BY P.OriginalPrice DESC";
                break;
            case "Letter_A-Z":
                orderBy = "ORDER BY P.ProName ASC";
                break;
            case "Letter_Z-A":
                orderBy = "ORDER BY P.ProName DESC";
                break;

        }
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
                + " WHERE P.BrandID = B.BrandID AND P.CateID = C.CateID AND I.ProID = P.ProID AND S.SpecID = PS.SpecID AND PS.ProID = P.ProID  "
                + orderBy;
        try {
            con = DBUtils.getConnection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                if (listOfProduct.size() != 0) {
                    int pd = listOfProduct.get(listOfProduct.size() - 1).getProID(); //Check id of product is exist or not in arraylist
                    if (pd != 0) {
                        if (Integer.parseInt(rs.getString("ProID")) == pd) {
                            if (!listOfImages.get(listOfImages.size() - 1).getImageID().equals(rs.getString("ImageID"))
                                    && !listOfImages.get(listOfImages.size() - 1).getUrl().equals(rs.getString("Url"))) {
                                listOfImages.add(new Images(rs.getString("ImageID"), rs.getString("Url")));
                                listOfProduct.get(listOfProduct.size() - 1).setListImage(listOfImages);
                            }

                            if (!findKeyExistInArray(listOfSpecification, rs.getString("SpecName"))) {
                                listOfSpecification.add(new Specification(rs.getString("SpecName"), rs.getString("Detail")));
                                listOfProduct.get(listOfProduct.size() - 1).setListSpecification(listOfSpecification);
                            }
                        } else {
                            Product product = new Product();
                            listOfSpecification = new ArrayList<>();
                            listOfImages = new ArrayList<>();

                            product.setProID(rs.getInt("ProID"));
                            product.setProName(rs.getString("ProName"));
                            product.setProOriginalPrice(formatter.format(rs.getInt("OriginalPrice")));

                            product.setDiscount(rs.getInt("Discount"));
                            product.setProCurrentPrice(formatter.format(calculateDiscount(rs.getInt("Discount"), rs.getInt("OriginalPrice"))));

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
                    product.setProOriginalPrice(formatter.format(rs.getInt("OriginalPrice")));

                    product.setDiscount(rs.getInt("Discount"));
                    product.setProCurrentPrice(formatter.format(calculateDiscount( rs.getInt("Discount"),  rs.getInt("OriginalPrice"))));

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

    //Calculate price after discount
    public double calculateDiscount(double discount, double originalPrice) {
        return originalPrice - (originalPrice * discount/100)  ;
    }
    
    //Đây là phần code dành cho filter
    public List<Product> selectProduct(String query) {
        List<Product> list = new ArrayList<>();
        try {
            Connection con = DBUtils.getConnection();
            PreparedStatement stm = con.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setBrandName(rs.getString("BrandName"));
                p.setProID(Integer.parseInt(rs.getString("ProID")));
                p.setProName(rs.getString("ProName"));
                p.setProOriginalPrice(formatter.format(rs.getInt("OriginalPrice")));
                listOfImages.add(new Images(rs.getString("ImageID"), rs.getString("Url")));
                p.setListImage(listOfImages);
                list.add(p);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Product_Management.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    //filter theo brand
    public List<Product> filterByBrands(String typeBrand, String cate) {
        String query = "SELECT b.BrandName, p.ProID, p.ProName, p.OriginalPrice, i.ImageID, i.Url\n"
                + "FROM Category c, Brand b, Product p, Images i\n"
                + "WHERE c.CateID = p.CateID AND b.BrandID = p.BrandID AND i.ProID = p.ProID AND i.ImageTypeID = 1 AND b.BrandName LIKE '%" + typeBrand + "%' AND c.CateID = " + cate;
        return selectProduct(query);
    }

    public List<Product> filterMachineSeries(String series, String cate) {
        String query = "SELECT b.BrandName, p.ProID, p.ProName, p.OriginalPrice, i.ImageID, i.Url\n"
                + "FROM Category c, Brand b, Product p, Images i\n"
                + "WHERE c.CateID = p.CateID AND b.BrandID = p.BrandID AND i.ProID = p.ProID AND i.ImageTypeID = 1\n"
                + "AND p.ProName LIKE N'%" + series + "%' AND c.CateID = " + cate;
        return selectProduct(query);
    }

    //filter blutooth, wired
    public List<Product> filterType(String type, String cate) {
        String query = "";
        switch (cate) {
            case "2":
                query = "SELECT b.BrandName, p.ProID, p.ProName, p.OriginalPrice, i.ImageID, i.Url, ps.Detail\n" +
                    "FROM Category c, Brand b, Product p, Images i, dbo.ProSpec ps\n" +
                    "WHERE c.CateID = p.CateID AND b.BrandID = p.BrandID AND i.ProID = p.ProID AND i.ImageTypeID = 1\n" +
                    "AND ps.Detail LIKE 'Intel Core i7%' AND c.CateID = 2";
                break;
            case "3":
                query = "SELECT b.BrandName, p.ProID, p.ProName, p.OriginalPrice, i.ImageID, i.Url from Product p , ProSpec ps, Images i, Brand b\n"
                        + "where b.BrandID = p.BrandID AND p.ProID = ps.ProID AND p.ProID = i.ProID AND i.ProID = p.ProID \n"
                        + "AND p.ProName LIKE N'Chuột%' AND i.ImageTypeID = 1 AND ps.Detail LIKE '" + type + "%'";
                break;
            case "4":
                query = "SELECT b.BrandName, p.ProID, p.ProName, p.OriginalPrice, i.ImageID, i.Url from Product p , ProSpec ps, Images i, Brand b\n"
                        + "where b.BrandID = p.BrandID AND p.ProID = ps.ProID AND p.ProID = i.ProID AND i.ProID = p.ProID \n"
                        + "AND p.ProName LIKE N'Tai nghe%' AND i.ImageTypeID = 1 AND ps.Detail LIKE '" + type + "%'";
                break;
        }
        return selectProduct(query);
    }
    
    //dành riêng de073 filter core i
    public List<Product> filterTypeCore(String type, String cate) {
        Connection con = DBUtils.getConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        String sql = "SELECT P.ProID, P.ProName, P.OriginalPrice, P.Discount, P.CurrentPrice, I.ImageID, I.Url, B.BrandName, C.CateName, S.SpecName, PS.Detail\n" +
                    "FROM dbo.Product P, dbo.Images I , dbo.Brand B , dbo.Category C , dbo.Specification S, dbo.ProSpec PS\n" +
                    "WHERE P.BrandID = B.BrandID AND P.CateID = C.CateID AND I.ProID = P.ProID AND S.SpecID = PS.SpecID AND \n" +
                    "PS.ProID = P.ProID AND S.SpecID = PS.SpecID AND PS.ProID = P.ProID AND c.CateID =" + cate + "AND ps.Detail LIKE N'%" + type + "%'";
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

                            if (!findKeyExistInArray(listOfSpecification, rs.getString("SpecName"))) {
                                listOfSpecification.add(new Specification(rs.getString("SpecName"), rs.getString("Detail")));
                                listOfProduct.get(listOfProduct.size() - 1).setListSpecification(listOfSpecification);
                            }
                        } else {
                            Product product = new Product();
                            listOfSpecification = new ArrayList<>();
                            listOfImages = new ArrayList<>();

                            product.setProID(rs.getInt("ProID"));
                            product.setProName(rs.getString("ProName"));

                            product.setProOriginalPrice(formatter.format(rs.getInt("OriginalPrice")));
                            product.setProCurrentPrice(formatter.format(calculateDiscount(rs.getInt("Discount"), rs.getInt("OriginalPrice"))));
                            product.setDiscount(rs.getInt("Discount"));
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
                    product.setProOriginalPrice(formatter.format(rs.getInt("OriginalPrice")));

                    product.setDiscount(rs.getInt("Discount"));
                    product.setProCurrentPrice(formatter.format(calculateDiscount(rs.getInt("Discount"), rs.getInt("OriginalPrice"))));
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

    //filter theo giá
    public List<Product> filterByPrice(String price, String cate) {
        String query = "";
        switch (price) {
            case "1":
                query = "SELECT b.BrandName, p.ProID, p.ProName, p.OriginalPrice, i.ImageID, i.Url\n"
                        + "FROM Category c, Brand b, Product p, Images i\n"
                        + "WHERE c.CateID = p.CateID AND b.BrandID = p.BrandID AND i.ProID = p.ProID AND i.ImageTypeID = 1\n"
                        + "AND P.OriginalPrice <= 20000000 AND c.CateID = 1 ORDER BY P.OriginalPrice ASC";
                break;
            case "2":
                query = "SELECT b.BrandName, p.ProID, p.ProName, p.OriginalPrice, i.ImageID, i.Url\n"
                        + "FROM Category c, Brand b, Product p, Images i\n"
                        + "WHERE c.CateID = p.CateID AND b.BrandID = p.BrandID AND i.ProID = p.ProID AND i.ImageTypeID = 1\n"
                        + "AND P.OriginalPrice BETWEEN 20000000 AND 25000000 AND c.CateID = 1 ORDER BY P.OriginalPrice ASC";
                break;
            case "3":
                query = "SELECT b.BrandName, p.ProID, p.ProName, p.OriginalPrice, i.ImageID, i.Url\n"
                        + "FROM Category c, Brand b, Product p, Images i\n"
                        + "WHERE c.CateID = p.CateID AND b.BrandID = p.BrandID AND i.ProID = p.ProID AND i.ImageTypeID = 1\n"
                        + "AND P.OriginalPrice BETWEEN 25000000 AND 30000000 AND c.CateID = 1 ORDER BY P.OriginalPrice ASC";
                break;
            case "4":
                query = "SELECT b.BrandName, p.ProID, p.ProName, p.OriginalPrice, i.ImageID, i.Url\n"
                        + "FROM Category c, Brand b, Product p, Images i\n"
                        + "WHERE c.CateID = p.CateID AND b.BrandID = p.BrandID AND i.ProID = p.ProID AND i.ImageTypeID = 1\n"
                        + "AND P.OriginalPrice >= 30000000 AND c.CateID = 1 ORDER BY P.OriginalPrice ASC";
                break;
            case "5":
                query = "SELECT b.BrandName, p.ProID, p.ProName, p.OriginalPrice, i.ImageID, i.Url\n"
                        + "FROM Category c, Brand b, Product p, Images i\n"
                        + "WHERE c.CateID = p.CateID AND b.BrandID = p.BrandID AND i.ProID = p.ProID AND i.ImageTypeID = 1\n"
                        + "AND P.OriginalPrice <= 15000000 AND c.CateID = 2 ORDER BY P.OriginalPrice ASC";
                break;
            case "6":
                query = "SELECT b.BrandName, p.ProID, p.ProName, p.OriginalPrice, i.ImageID, i.Url\n"
                        + "FROM Category c, Brand b, Product p, Images i\n"
                        + "WHERE c.CateID = p.CateID AND b.BrandID = p.BrandID AND i.ProID = p.ProID AND i.ImageTypeID = 1\n"
                        + "AND P.OriginalPrice BETWEEN 15000000 AND 25000000 AND c.CateID = 2 ORDER BY P.OriginalPrice ASC";
                break;
            case "7":
                query = "SELECT b.BrandName, p.ProID, p.ProName, p.OriginalPrice, i.ImageID, i.Url\n"
                        + "FROM Category c, Brand b, Product p, Images i\n"
                        + "WHERE c.CateID = p.CateID AND b.BrandID = p.BrandID AND i.ProID = p.ProID AND i.ImageTypeID = 1\n"
                        + "AND P.OriginalPrice >= 20000000 AND c.CateID = 2 ORDER BY P.OriginalPrice ASC";
                break;
            case "8":
                query = "SELECT b.BrandName, p.ProID, p.ProName, p.OriginalPrice, i.ImageID, i.Url\n"
                        + "FROM Category c, Brand b, Product p, Images i\n"
                        + "WHERE c.CateID = p.CateID AND b.BrandID = p.BrandID AND i.ProID = p.ProID AND i.ImageTypeID = 1\n"
                        + "AND P.OriginalPrice <= 500000 AND c.CateID = " + cate + "ORDER BY P.OriginalPrice ASC";
                break;
            case "9":
                query = "SELECT b.BrandName, p.ProID, p.ProName, p.OriginalPrice, i.ImageID, i.Url\n"
                        + "FROM Category c, Brand b, Product p, Images i\n"
                        + "WHERE c.CateID = p.CateID AND b.BrandID = p.BrandID AND i.ProID = p.ProID AND i.ImageTypeID = 1\n"
                        + "AND P.OriginalPrice BETWEEN 500000 AND 1000000 AND c.CateID = " + cate + "ORDER BY P.OriginalPrice ASC";
                break;
            case "10":
                query = "SELECT b.BrandName, p.ProID, p.ProName, p.OriginalPrice, i.ImageID, i.Url\n"
                        + "FROM Category c, Brand b, Product p, Images i\n"
                        + "WHERE c.CateID = p.CateID AND b.BrandID = p.BrandID AND i.ProID = p.ProID AND i.ImageTypeID = 1\n"
                        + "AND P.OriginalPrice BETWEEN 1000000 AND 2000000 AND c.CateID = " + cate + "ORDER BY P.OriginalPrice ASC";
                break;
            case "11":
                query = "SELECT b.BrandName, p.ProID, p.ProName, p.OriginalPrice, i.ImageID, i.Url\n"
                        + "FROM Category c, Brand b, Product p, Images i\n"
                        + "WHERE c.CateID = p.CateID AND b.BrandID = p.BrandID AND i.ProID = p.ProID AND i.ImageTypeID = 1\n"
                        + "AND P.OriginalPrice BETWEEN 2000000 AND 3000000 AND c.CateID = " + cate + "ORDER BY P.OriginalPrice ASC";
                break;
            case "12":
                query = "SELECT b.BrandName, p.ProID, p.ProName, p.OriginalPrice, i.ImageID, i.Url\n"
                        + "FROM Category c, Brand b, Product p, Images i\n"
                        + "WHERE c.CateID = p.CateID AND b.BrandID = p.BrandID AND i.ProID = p.ProID AND i.ImageTypeID = 1\n"
                        + "AND P.OriginalPrice >= 3000000 AND c.CateID = " + cate + "ORDER BY P.OriginalPrice ASC";
                break;
        }
        return selectProduct(query);
    }
}
