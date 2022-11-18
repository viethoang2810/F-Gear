/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.swp391.F_Gear.DTO;


import java.util.List;

/**
 *
 * @author nguye
 */
public class CateBrand {
    private int cateID;
    private int brandID;
    private String typePolicy;
    private String intendTime;
    private String note;
    private String cateName;
    private String brandName;

    public CateBrand() {
    }

    public CateBrand(int cateID, int brandID, String typePolicy, String intendTime, String note, String cateName, String brandName) {
        this.cateID = cateID;
        this.brandID = brandID;
        this.typePolicy = typePolicy;
        this.intendTime = intendTime;
        this.note = note;
        this.cateName = cateName;
        this.brandName = brandName;
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

    public String getTypePolicy() {
        return typePolicy;
    }

    public void setTypePolicy(String typePolicy) {
        this.typePolicy = typePolicy;
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

   
}
