package com.intern.ssdemo.DTO;

public class StateDTO {
    private String name;
    private  int countryId;

    public String getName() {
        return name;
    }

    public StateDTO setName(String name) {
        this.name = name;
        return this;
    }

    public int getCountryId() {
        return countryId;
    }

    public StateDTO setCountryId(int countryId) {
        this.countryId = countryId;
        return this;
    }
}
