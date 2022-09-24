/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.swp391.F_Gear.DTO;

/**
 *
 * @author duyng
 */
public abstract class Product {
    private int ProID;
    private String proName;
    private int Prie;
    private int brandID;

    public Product() {
    }

    public Product(int ProID, String proName, int Prie, int brandID) {
        this.ProID = ProID;
        this.proName = proName;
        this.Prie = Prie;
        this.brandID = brandID;
    }

    public int getProID() {
        return ProID;
    }

    public void setProID(int ProID) {
        this.ProID = ProID;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public int getPrie() {
        return Prie;
    }

    public void setPrie(int Prie) {
        this.Prie = Prie;
    }

    public int getBrandID() {
        return brandID;
    }

    public void setBrandID(int brandID) {
        this.brandID = brandID;
    }
    
    
}
