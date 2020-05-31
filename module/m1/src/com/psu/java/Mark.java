package com.psu.java;

//This is the definition of the enumeration containing CAR MARKS. Enumeration element may
//contain different data e.g. String, Integer and another objects
public enum Mark {
    BMW("Germany"),
    LADA("Russia"),
    PORSCHE("Italy"),
    BENTLEY("Belgium");

    private String country;

    public String getCountry() {
        return country;
    }

    Mark(String country) {
        this.country = country;
    }
}
