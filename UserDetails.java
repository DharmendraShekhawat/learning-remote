package com.dharmendra.userManagementSystem;

import org.springframework.stereotype.Component;

public class UserDetails {

   private Integer userId;
   private String Name;
    private String userName;
    private String address;
    private Integer phoneNumber;
    public UserDetails(Integer UserId, String Name, String UserName, String Address) {
        this.userId = UserId;
        this.Name = Name;
        this.userName = UserName;
        this.address = Address;
    }
    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }
}
