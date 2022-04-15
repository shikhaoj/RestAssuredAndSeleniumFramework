package com.rest.apis.zopping;

/**
 * @author shikha
 */

public class UserNamePasswordAuthentication {
    private String username;
    private String password;
    private boolean remember;

    public UserNamePasswordAuthentication(String username, String password, boolean remember) {
        this.username = username;
        this.password = password;
        this.remember = remember;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRemember() {
        return remember;
    }

    public void setRemember(boolean remember) {
        this.remember = remember;
    }
}
