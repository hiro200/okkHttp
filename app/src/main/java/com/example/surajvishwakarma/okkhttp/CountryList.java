package com.example.surajvishwakarma.okkhttp;

/**
 * Created by surajvishwakarma on 13/10/17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CountryList {
    @SerializedName("countryID")
    @Expose
    private String countryID;
    @SerializedName("countryName")
    @Expose
    private String countryName;
    @SerializedName("code2")
    @Expose
    private String code2;
    @SerializedName("active")
    @Expose
    private Boolean active;

    public String getCountryID() {
        return countryID;
    }

    public void setCountryID(String countryID) {
        this.countryID = countryID;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return countryName;
    }
}
