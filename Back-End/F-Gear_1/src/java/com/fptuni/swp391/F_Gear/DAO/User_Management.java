/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.swp391.F_Gear.DAO;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

/**
 *
 * @author Admin
 */
public class User_Management {
    public String getLastModifiedTimeOfAvatar(String path){
        
        try {
            Path file = Paths.get(path);
            BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);
        } catch (Exception e) {
        }
        return null ;
    }
}
