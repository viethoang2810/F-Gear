/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.swp391.F_Gear.DTO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguye
 */
public class Cart {
    
    private List<Item> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public Cart(List<Item> items) {
        this.items = items;
    }
    
    //lay items by Id
    private Item getItemByID(int ID){
        for(Item i : items ){
            if(i.getProduct().getProID() == ID)
                return i;           
        }
        return null;
    }
    
    public int getQuantityByID(int ID){
        return  getItemByID(ID).getQuantity();
    }
    
    public void addItem(Item t){
        if(getItemByID(t.getProduct().getProID()) != null){
            Item i = getItemByID(t.getProduct().getProID());
            i.setQuantity(i.getQuantity() + t.getQuantity());
        }else{
            items.add(t);
        }
    }
    
    public void removeItem(int ID){
        if(getItemByID(ID) != null){
            items.remove(getItemByID(ID));
        }
    }
    
    public double getTotalMoney(){
        double t = 0;
        for (Item  i : items)
            t += i.getQuantity() * i.getPrice();
        return t;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    
}
