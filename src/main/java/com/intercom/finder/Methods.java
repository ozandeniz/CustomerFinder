package com.intercom.finder;

public enum  Methods {
    HAVERSINE("haversine"),
    SPHERICAL_LAW_OF_COSINES("spherical");

    private String method;

    Methods(String method) {
        this.method = method;
    }

    public String method() {
        return method;
    }
}