package com.example.surajvishwakarma.okkhttp;

/**
 * Created by surajvishwakarma on 13/10/17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserDetails {
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("userID")
    @Expose
    private String userID;
    @SerializedName("username")
    @Expose
    private String username;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
