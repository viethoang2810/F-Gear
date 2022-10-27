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
public class Users {

    private String userName;
    private String password;
    private String fullName;
    private String phoneNumber;
    private String roleName;
    private String avatar ;
    private String gender;
    private String gmail;

    public Users() {
    }

    public Users(String userName, String password, String fullName, String phoneNumber, String roleName, String avatar, String gender, String gmail) {
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.roleName = roleName;
        this.avatar = avatar;
        this.gender = gender;
        this.gmail = gmail;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String RoleName) {
        this.roleName = RoleName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Users{" + "userName=" + userName + ", password=" + password + ", fullName=" + fullName + ", phoneNumber=" + phoneNumber + ", roleName=" + roleName + ", avatar=" + avatar + ", gender=" + gender + ", gmail=" + gmail + '}';
    }
    
    
    
    
   

}
