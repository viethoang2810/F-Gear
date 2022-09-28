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
public class Mouse extends Product{
    private String DPI;
    private String numberOfButtons;
    private String longevity;
    private String connection;
    private String shellMaterial;
    private String Ccmpatible;
    private String color;

    public Mouse() {
    }

    public Mouse(int ProID, String proName, int Prie, int brandID, String DPI, String numberOfButtons, String longevity, String connection, String shellMaterial, String Ccmpatible, String color) {
        super(ProID, proName, Prie, brandID);
        this.DPI = DPI;
        this.numberOfButtons = numberOfButtons;
        this.longevity = longevity;
        this.connection = connection;
        this.shellMaterial = shellMaterial;
        this.Ccmpatible = Ccmpatible;
        this.color = color;
    }

    public String getDPI() {
        return DPI;
    }

    public void setDPI(String DPI) {
        this.DPI = DPI;
    }

    public String getNumberOfButtons() {
        return numberOfButtons;
    }

    public void setNumberOfButtons(String numberOfButtons) {
        this.numberOfButtons = numberOfButtons;
    }

    public String getLongevity() {
        return longevity;
    }

    public void setLongevity(String longevity) {
        this.longevity = longevity;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public String getShellMaterial() {
        return shellMaterial;
    }

    public void setShellMaterial(String shellMaterial) {
        this.shellMaterial = shellMaterial;
    }

    public String getCcmpatible() {
        return Ccmpatible;
    }

    public void setCcmpatible(String Ccmpatible) {
        this.Ccmpatible = Ccmpatible;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    

    
}
