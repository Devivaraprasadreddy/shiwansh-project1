package com.intern.ssdemo.DTO;

public class StudentDTO {
    private String name;
    private String email;
    private String mobile;
    private int countryId;
    private int stateId;
    private int districtId;
    private int genderId;

    // Getter and Setter for name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for email
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and Setter for mobile
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    // Getter and Setter for countryId
    public int getCountryId() {
        return countryId;
    }
    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    // Getter and Setter for stateId
    public int getStateId() {
        return stateId;
    }
    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    // Getter and Setter for districtId
    public int getDistrictId() {
        return districtId;
    }
    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    // Getter and Setter for genderId
    public int getGenderId() {
        return genderId;
    }
    public void setGenderId(int genderId) {
        this.genderId = genderId;
    }
}
