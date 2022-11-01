/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.swp391.F_Gear.DTO;

/**
 *
 * @author nguye
 */
public class WarrantyPolicy {
    private int waID;
    private String cateName;
    private String brandName;
    private String typeWarranty;
    private String intendTime;
    private String note;

    public WarrantyPolicy() {
    }

    public WarrantyPolicy(int waID, String cateName, String brandName, String typeWarranty, String intendTime, String note) {
        this.waID = waID;
        this.cateName = cateName;
        this.brandName = brandName;
        this.typeWarranty = typeWarranty;
        this.intendTime = intendTime;
        this.note = note;
    }

    public int getWaID() {
        return waID;
    }

    public void setWaID(int waID) {
        this.waID = waID;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getTypeWarranty() {
        return typeWarranty;
    }

    public void setTypeWarranty(String typeWarranty) {
        this.typeWarranty = typeWarranty;
    }

    public String getIntendTime() {
        return intendTime;
    }

    public void setIntendTime(String intendTime) {
        this.intendTime = intendTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
 
    
}
