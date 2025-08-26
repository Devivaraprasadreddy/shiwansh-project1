package com.intern.ssdemo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int countryId;
    private int stateId;
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStateId() {
        return stateId;
    }

    public District setStateId(int stateId) {
        this.stateId = stateId;
        return this;
    }

    public int getCountryId() {
        return countryId;
    }

    public District setCountryId(int countryId) {
        this.countryId = countryId;
        return this;
    }

    public District setName(String name) {
        this.name = name;
        return this;
    }
}
