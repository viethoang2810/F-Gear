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
public class Product {

    private int proID;
    private String proName;
    private int proOriginalPrice;
    private int discount;
    private int proCurrentPrice;
    private String brandName;
    private ArrayList<Images> listImage;
    private ArrayList<Specification> listSpecification;
    private String proType;

    public Product() {
    }

//    cai constructor n�y de lay top 8 san pham show o Homepage nha -DungHQ
    public Product(String brandName, int proID, String proName, double proOriginalPrice, ArrayList<Images> listImage) {
        this.brandName = brandName;
        this.proID = proID;
        this.proName = proName;
        this.proOriginalPrice = proOriginalPrice;
        this.listImage = listImage;
    }

    public Product(int proID, String proName, int proOriginalPrice, int discount, int proCurrentPrice, String brandName, ArrayList<Images> listImage, ArrayList<Specification> listSpecification, String proType) {
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

    public int getProOriginalPrice() {
        return proOriginalPrice;
    }

    public void setProOriginalPrice(int proOriginalPrice) {
        this.proOriginalPrice = proOriginalPrice;
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

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getProCurrentPrice() {
        return proCurrentPrice;
    }

    public void setProCurrentPrice(int proCurrentPrice) {
        this.proCurrentPrice = proCurrentPrice;
    }
    
}
