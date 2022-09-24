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
public class Laptop extends Product {

    private String CPU;
    private String RAM;
    private String storageDrive;
    private String graphicsCard;
    private String monitor;
    private String webcam;
    private String battery;
    private String weight;
    private String color;

    public Laptop() {
    }

    public Laptop(String CPU, String RAM, String storageDrive, String graphicsCard, String monitor, String webcam, String battery, String weight, String color) {
        this.CPU = CPU;
        this.RAM = RAM;
        this.storageDrive = storageDrive;
        this.graphicsCard = graphicsCard;
        this.monitor = monitor;
        this.webcam = webcam;
        this.battery = battery;
        this.weight = weight;
        this.color = color;
    }

    public Laptop(int ProID, String proName, int Prie, int brandID, String CPU, String RAM, String storageDrive, String graphicsCard, String Monitor, String webcam, String battery, String weight, String color) {
        super(ProID, proName, Prie, brandID);
        this.CPU = CPU;
        this.RAM = RAM;
        this.storageDrive = storageDrive;
        this.graphicsCard = graphicsCard;
        this.monitor = monitor;
        this.webcam = webcam;
        this.battery = battery;
        this.weight = weight;
        this.color = color;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getRAM() {
        return RAM;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public String getStorageDrive() {
        return storageDrive;
    }

    public void setStorageDrive(String storageDrive) {
        this.storageDrive = storageDrive;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    public String getWebcam() {
        return webcam;
    }

    public void setWebcam(String webcam) {
        this.webcam = webcam;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
}
