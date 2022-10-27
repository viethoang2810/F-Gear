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
public class Orders {

    private int orderId;
    private String userName;
    private String productName;
    private String orderDate;
    private int proId;
    private float subtotal;
    private float tax;
    private float shipping;
    private int quantity;
    private float total;

    public Orders() {
    }

    public Orders(String productName, String proId, String subtotal, String tax, String shipping, String quantity, String total) {
        this.productName = productName;
        this.proId = Integer.parseInt(proId);
        this.subtotal = Float.parseFloat(subtotal);
        this.tax = Float.parseFloat(tax);
        this.shipping = Float.parseFloat(shipping);
        this.quantity = Integer.parseInt(quantity);
        this.total = Float.parseFloat(total);
    }

    public Orders(int orderId, String userName, String productName, String orderDate, int proId, float subtotal, float tax, float shipping, int quantity, float total) {
        this.orderId = orderId;
        this.userName = userName;
        this.productName = productName;
        this.orderDate = orderDate;
        this.proId = proId;
        this.subtotal = subtotal;
        this.tax = tax;
        this.shipping = shipping;
        this.quantity = quantity;
        this.total = total;
    }

//    public Orders(String product, String proId, String subtotal, String tax, String shipping, String quantity, String total) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public String getSubtotal() {
        return String.format("%.2f", subtotal);
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public String getTax() {
        return String.format("%.2f", tax);
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

    public String getShipping() {
        return String.format("%.2f", shipping);
    }

    public void setShipping(float shipping) {
        this.shipping = shipping;
    }

    public String getQuantity() {
        return String.format("%.2d", quantity);
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTotal() {
        return String.format("%.2f", total);
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Orders{" + "orderId=" + orderId + ", userName=" + userName + ", productName=" + productName + ", orderDate=" + orderDate + ", proId=" + proId + ", subtotal=" + subtotal + ", tax=" + tax + ", shipping=" + shipping + ", quantity=" + quantity + ", total=" + total + '}';
    }

}
