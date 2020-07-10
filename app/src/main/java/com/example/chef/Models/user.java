package com.example.chef.Models;

public class user {

    public String userId;
    public String userNickName;
    public String userName;
    public String userSurname;
    public String userPassword;

    public user() {
    }

    public user(String userId, String userNickName, String userName, String userSurname, String userPassword) {
        this.userId = userId;
        this.userNickName = userNickName;
        this.userName = userName;
        this.userSurname = userSurname;
        this.userPassword = userPassword;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}

