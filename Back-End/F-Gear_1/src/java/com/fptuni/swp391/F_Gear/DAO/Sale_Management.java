/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.swp391.F_Gear.DAO;

import com.fptuni.swp391.F_Gear.DTO.Product;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Sale_Management {

    public Product_Management pm = new Product_Management();
    public ArrayList<Product> listOfPro = pm.getAllOfProduct();
    public HashMap<String, ArrayList<Product>> listOfProIsSaling = new HashMap<>();
    public ArrayList<Product> proSaling = new ArrayList<>();

    public HashMap<String, ArrayList<Product>> getAllProIsSaling() {
        for (Product product : listOfPro) {
            if (product.getDiscount() != 0) {
                if (!proSaling.isEmpty()) {
                    if (product.getBrandName().equals(proSaling.get(proSaling.size() - 1).getBrandName())) {
                        proSaling.add(product);
                    } else {
                        listOfProIsSaling.put(proSaling.get(proSaling.size() - 1).getBrandName(), proSaling);
                        proSaling = new ArrayList<>();
                        proSaling.add(product);
                    }
                }else{
                    proSaling.add(product);
                }
            }
        }
        return listOfProIsSaling;
    }

}
