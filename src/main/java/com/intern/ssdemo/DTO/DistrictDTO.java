package com.intern.ssdemo.DTO;

public class DistrictDTO {
    private String name;
    private int countryId;
    private int stateId;

    public String getName() {
        return name;
    }

    public DistrictDTO setName(String name) {
        this.name = name;
        return this;
    }

    public int getCountryId() {
        return countryId;
    }

    public DistrictDTO setCountryId(int countryId) {
        this.countryId = countryId;
        return this;
    }

    public int getStateId() {
        return stateId;
    }

    public DistrictDTO setStateId(int stateId) {
        this.stateId = stateId;
        return this;
    }
}
