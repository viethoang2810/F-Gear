/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.swp391.F_Gear.DTO;

import java.util.ArrayList;

/**
 *
 * @author duyng
 */
public class Product implements Comparable<Product> {

    private int proID;
    private String proName;
    private String proOriginalPrice;
    private int discount;
    private String proCurrentPrice;
    private String brandName;
    private ArrayList<Images> listImage;
    private ArrayList<Specification> listSpecification;
    private String proType;
    private int status;
    private int cateID;
    private int brandID;
    private String guaDetail;
    private int guaID;
    
    public Product() {
    }

//    cái constructor này để lấy top 8 sản phẩm show ở Homepage nha -DungHQ
    public Product(String brandName, int proID, String proName, String proOriginalPrice, ArrayList<Images> listImage) {
        this.brandName = brandName;
        this.proID = proID;
        this.proName = proName;
        this.proOriginalPrice = proOriginalPrice;
        this.listImage = listImage;
    }

    public Product(int proID, String proName, String proOriginalPrice, int discount, String proCurrentPrice, String brandName, ArrayList<Images> listImage, ArrayList<Specification> listSpecification, String proType) {
        this.proID = proID;
        this.proName = proName;
        this.proOriginalPrice = proOriginalPrice;
        this.discount = discount;
        this.proCurrentPrice = proCurrentPrice;
        this.brandName = brandName;
        this.listImage = listImage;
        this.listSpecification = listSpecification;
        this.proType = proType;
    }

    //constructor list product -vanndh
    public Product(int proID, String proName, String proOriginalPrice, int discount, String proCurrentPrice, int status, int cateID, int brandID) {
        this.proID = proID;
        this.proName = proName;
        this.proOriginalPrice = proOriginalPrice;
        this.discount = discount;
        this.proCurrentPrice = proCurrentPrice;
        this.status = status;
        this.cateID = cateID;
        this.brandID = brandID;
    }
    
    public Product(int proID, String proName, String proOriginalPrice, int discount, String proCurrentPrice, String brandName, ArrayList<Images> listImage, ArrayList<Specification> listSpecification, String proType, int status, int cateID, int brandID, String guaDetail) {
        this.proID = proID;
        this.proName = proName;
        this.proOriginalPrice = proOriginalPrice;
        this.discount = discount;
        this.proCurrentPrice = proCurrentPrice;
        this.brandName = brandName;
        this.listImage = listImage;
        this.listSpecification = listSpecification;
        this.proType = proType;
        this.status = status;
        this.cateID = cateID;
        this.brandID = brandID;
        this.guaDetail = guaDetail;
    }

    public Product(int proID, String proName, String proOriginalPrice, int discount, String proCurrentPrice, String brandName, ArrayList<Images> listImage, ArrayList<Specification> listSpecification, String proType, int status, int cateID, int brandID, String guaDetail, int guaID) {
        this.proID = proID;
        this.proName = proName;
        this.proOriginalPrice = proOriginalPrice;
        this.discount = discount;
        this.proCurrentPrice = proCurrentPrice;
        this.brandName = brandName;
        this.listImage = listImage;
        this.listSpecification = listSpecification;
        this.proType = proType;
        this.status = status;
        this.cateID = cateID;
        this.brandID = brandID;
        this.guaDetail = guaDetail;
        this.guaID = guaID;
    }

    
    
    public int getProID() {
        return proID;
    }

    public void setProID(int proID) {
        this.proID = proID;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProOriginalPrice() {
        return proOriginalPrice;
    }

    public void setProOriginalPrice(String proOriginalPrice) {
        this.proOriginalPrice = proOriginalPrice;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getProCurrentPrice() {
        return proCurrentPrice;
    }

    public void setProCurrentPrice(String proCurrentPrice) {
        this.proCurrentPrice = proCurrentPrice;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public ArrayList<Images> getListImage() {
        return listImage;
    }

    public void setListImage(ArrayList<Images> listImage) {
        this.listImage = listImage;
    }

    public ArrayList<Specification> getListSpecification() {
        return listSpecification;
    }

    public void setListSpecification(ArrayList<Specification> listSpecification) {
        this.listSpecification = listSpecification;
    }

    public String getProType() {
        return proType;
    }

    public void setProType(String proType) {
        this.proType = proType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCateID() {
        return cateID;
    }

    public void setCateID(int cateID) {
        this.cateID = cateID;
    }

    public int getBrandID() {
        return brandID;
    }

    public void setBrandID(int brandID) {
        this.brandID = brandID;
    }
    
    public String getGuaDetail() {
        return guaDetail;
    }

    public void setGuaDetail(String guaDetail) {
        this.guaDetail = guaDetail;
    }   

    public int getGuaID() {
        return guaID;
    }

    public void setGuaID(int guaID) {
        this.guaID = guaID;
    }
    
    

    @Override
    public int compareTo(Product o) {
        return this.brandName.compareTo(o.brandName);
    }

    @Override
    public String toString() {
        return "Product{" + "proID=" + proID + ", proName=" + proName + ", proOriginalPrice=" + proOriginalPrice + ", discount=" + discount + ", proCurrentPrice=" + proCurrentPrice + ", brandName=" + brandName + ", listImage=" + listImage + ", listSpecification=" + listSpecification + ", proType=" + proType + ", status=" + status + ", cateID=" + cateID + ", brandID=" + brandID + '}';
    }
    
}
