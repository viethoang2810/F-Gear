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
public class OrderDetail {
  
    private int orderID;
    private int proIDID;
    private int quantity;
    private int price;

    public OrderDetail() {
    }

    public OrderDetail(int orderID, int proIDID, int quantity, int price) {
        this.orderID = orderID;
        this.proIDID = proIDID;
        this.quantity = quantity;
        this.price = price;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getProIDID() {
        return proIDID;
    }

    public void setProIDID(int proIDID) {
        this.proIDID = proIDID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
