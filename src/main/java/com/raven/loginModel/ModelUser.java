package com.raven.loginModel;

public class ModelUser {
    int userID;
    String username;
    String email;
    String password;
    String verifyCode;

    public int getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public ModelUser(int userID, String username, String email, String password, String verifyCode, String dni) {
        this.userID = userID;
        this.username = username;
        this.email = email;
        this.password = password;
        this.verifyCode = verifyCode;
    }

    public ModelUser(int userID, String username, String email, String password) {
        this.userID = userID;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // Añadir constructor con dni
    public ModelUser(int userID, String username, String email, String password, String dni) {
        this.userID = userID;
        this.username = username;
        this.email = email;
        this.password = password;
    }
}