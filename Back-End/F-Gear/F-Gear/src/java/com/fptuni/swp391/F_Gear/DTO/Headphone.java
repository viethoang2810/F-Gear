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

    private String Weight;
    private String connection;
    private String compatible;
    private String frequencyResponse;
    private String soundproofingAbility;
    private String color;

    public Headphone() {
    }

    public Headphone(String Weight, String connection, String compatible, String frequencyResponse, String soundproofingAbility, String color) {
        this.Weight = Weight;
        this.connection = connection;
        this.compatible = compatible;
        this.frequencyResponse = frequencyResponse;
        this.soundproofingAbility = soundproofingAbility;
        this.color = color;
    }

    public Headphone(int ProID, String proName, int Prie, int brandID, String Weight, String connection, String compatible, String frequencyResponse, String soundproofingAbility, String color) {
        super(ProID, proName, Prie, brandID);
        this.Weight = Weight;
        this.connection = connection;
        this.compatible = compatible;
        this.frequencyResponse = frequencyResponse;
        this.soundproofingAbility = soundproofingAbility;
        this.color = color;
    }

    public String getWeight() {
        return Weight;
    }

    public void setWeight(String Weight) {
        this.Weight = Weight;
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

    public String getFrequencyResponse() {
        return frequencyResponse;
    }

    public void setFrequencyResponse(String frequencyResponse) {
        this.frequencyResponse = frequencyResponse;
    }

    public String getSoundproofingAbility() {
        return soundproofingAbility;
    }

    public void setSoundproofingAbility(String soundproofingAbility) {
        this.soundproofingAbility = soundproofingAbility;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    
}
