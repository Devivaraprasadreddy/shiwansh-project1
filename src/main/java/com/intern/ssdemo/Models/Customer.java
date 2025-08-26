package com.intern.ssdemo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Name;
    private String Email;
    private String Mobile;
    private String Image;

    public String getName() {
        return Name;
    }

    public String getImage() {
        return Image;
    }

    public Customer setImage(String image) {
        Image = image;
        return this;
    }

    public String getMobile() {
        return Mobile;
    }

    public Customer setMobile(String mobile) {
        Mobile = mobile;
        return this;
    }

    public String getEmail() {
        return Email;
    }

    public Customer setEmail(String email) {
        Email = email;
        return this;
    }

    public Customer setName(String name) {
        Name = name;
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
