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
public class Headphone extends Product{

    private String connection;
    private String compatible;
    private String frequency;
    private String soundproofingAbility;
    private String headphoneStyle;
    private String color;

    public Headphone() {
    }

    public Headphone(int ProID, String proName, int Prie, int brandID, String connection, String compatible, String frequency, String soundproofingAbility, String headphoneStyle, String color) {
        super(ProID, proName, Prie, brandID);
        this.connection = connection;
        this.compatible = compatible;
        this.frequency = frequency;
        this.soundproofingAbility = soundproofingAbility;
        this.headphoneStyle = headphoneStyle;
        this.color = color;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public String getCompatible() {
        return compatible;
    }

    public void setCompatible(String compatible) {
        this.compatible = compatible;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getSoundproofingAbility() {
        return soundproofingAbility;
    }

    public void setSoundproofingAbility(String soundproofingAbility) {
        this.soundproofingAbility = soundproofingAbility;
    }

    public String getHeadphoneStyle() {
        return headphoneStyle;
    }

    public void setHeadphoneStyle(String headphoneStyle) {
        this.headphoneStyle = headphoneStyle;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
}
