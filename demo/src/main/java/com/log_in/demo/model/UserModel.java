package com.log_in.demo.model;

public class UserModel {

    public String userid;
    public String username;
    public String password;
    public float account;


    public String getUserId() {
        return userid;
    }

    public String getUserName() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public float getAccount() {
        return account;
    }

    public void setUserId(String userid){
        this.userid=userid;
    }

    public void setUserName(String username){
        this.username=username;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public void setAccount(float account){
        this.account=account;
    }


}