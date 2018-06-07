package com.lgx.user.dto;

public class LoginDTO {

    private String userName;
    private String userPassword;
    private boolean rememberCheckbox;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public boolean isRememberCheckbox() {
        return rememberCheckbox;
    }

    public void setRememberCheckbox(boolean rememberCheckbox) {
        this.rememberCheckbox = rememberCheckbox;
    }
}
