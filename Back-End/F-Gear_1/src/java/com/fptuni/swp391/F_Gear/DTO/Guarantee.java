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
public class Guarantee {
    
    private int guaranteeID;
    private String detailGua;

    public Guarantee() {
    }

    public Guarantee(int guaranteeID, String detailGua) {
        this.guaranteeID = guaranteeID;
        this.detailGua = detailGua;
    }

    public int getGuaranteeID() {
        return guaranteeID;
    }

    public void setGuaranteeID(int guaranteeID) {
        this.guaranteeID = guaranteeID;
    }

    public String getDetailGua() {
        return detailGua;
    }

    public void setDetailGua(String detailGua) {
        this.detailGua = detailGua;
    }
    
    
}
