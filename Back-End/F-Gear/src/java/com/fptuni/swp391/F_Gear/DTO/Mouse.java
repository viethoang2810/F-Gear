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
    private String IPS;
    private String responseFrequency;
    private String shellMaterial;
    private String numberOfButtons;
    private String longevity;
    private String connection;
    private String color;

    public Mouse() {
    }

    public Mouse(String IPS, String responseFrequency, String shellMaterial, String numberOfButtons, String longevity, String connection, String color) {
        this.IPS = IPS;
        this.responseFrequency = responseFrequency;
        this.shellMaterial = shellMaterial;
        this.numberOfButtons = numberOfButtons;
        this.longevity = longevity;
        this.connection = connection;
        this.color = color;
    }

    public Mouse(int ProID, String proName, int Prie, int brandID, String IPS, String responseFrequency, String shellMaterial, String numberOfButtons, String longevity, String connection, String color) {
        super(ProID, proName, Prie, brandID);
        this.IPS = IPS;
        this.responseFrequency = responseFrequency;
        this.shellMaterial = shellMaterial;
        this.numberOfButtons = numberOfButtons;
        this.longevity = longevity;
        this.connection = connection;
        this.color = color;
    }

    public String getIPS() {
        return IPS;
    }

    public void setIPS(String IPS) {
        this.IPS = IPS;
    }

    public String getResponseFrequency() {
        return responseFrequency;
    }

    public void setResponseFrequency(String responseFrequency) {
        this.responseFrequency = responseFrequency;
    }

    public String getShellMaterial() {
        return shellMaterial;
    }

    public void setShellMaterial(String shellMaterial) {
        this.shellMaterial = shellMaterial;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    
}
