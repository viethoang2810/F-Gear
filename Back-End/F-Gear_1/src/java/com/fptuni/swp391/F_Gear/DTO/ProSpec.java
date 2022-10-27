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
public class ProSpec {
    private int SpecID;
    private String Detail;
    private ArrayList<ProSpec> listSpec;

    public ProSpec() {
    }

    public ProSpec(int SpecID, String Detail) {
        this.SpecID = SpecID;
        this.Detail = Detail;
    }

    public int getSpecID() {
        return SpecID;
    }

    public void setSpecID(int SpecID) {
        this.SpecID = SpecID;
    }

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String Detail) {
        this.Detail = Detail;
    }

    @Override
    public String toString() {
        return "ProSpec{" + "SpecID=" + SpecID + ", Detail=" + Detail;
    }

    
}
