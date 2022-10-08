/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.swp391.F_Gear.DTO;

/**
 *
 * @author dell
 */
public class Chart {

    private String proName;
    private int date;
    private int month;
    private int year;
    private long total;
    private int quantity;

    public Chart() {
    }

    public Chart(int month, long total) {
        this.month = month;
        this.total = total;
    }

    public Chart(int month, int quantity) {
        this.month = month;
        this.quantity = quantity;
    }

    public Chart(String proName, int quantity) {
        this.proName = proName;
        this.quantity = quantity;
    }

    public Chart(String proName, int date, int month, int year, long total, int quantity) {
        this.proName = proName;
        this.date = date;
        this.month = month;
        this.year = year;
        this.total = total;
        this.quantity = quantity;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    @Override
    public String toString() {
        return "Chart{" + "proName=" + proName + ", date=" + date + ", month=" + month + ", year=" + year + ", total=" + total + ", quantity=" + quantity + '}';
    }

}
