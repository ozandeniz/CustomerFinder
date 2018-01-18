package com.intercom.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.intercom.distance.Coordinate;

public class CustomerInfo {

    private int userId;
    private String name;
    private double latitude;
    private double longitude;

    @JsonProperty("user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Customer Id: " + userId + ", Customer Name: " + name;
    }
}
