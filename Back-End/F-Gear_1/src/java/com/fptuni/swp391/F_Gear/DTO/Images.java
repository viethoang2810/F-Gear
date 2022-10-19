/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.swp391.F_Gear.DTO;

import java.util.ArrayList;

/**
 *
 * @author duyng
 */
public class Images {
    private String imageID ;
    private String url ;
   private ArrayList<Images> listImage;

    public Images() {
    }

    public Images(String url) {
        this.url = url;
    }

    public Images(String imageID, String url) {
        this.imageID = imageID;
        this.url = url;
    }

    public String getImageID() {
        return imageID;
    }

    public void setImageID(String imageID) {
        this.imageID = imageID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    
    
}
