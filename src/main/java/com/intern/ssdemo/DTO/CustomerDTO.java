package com.intern.ssdemo.DTO;

public class CustomerDTO {
    private String Name;
    private String Email;
    private String Mobile;
    private String Image;

    public String getName() {
        return Name;
    }

    public CustomerDTO setName(String name) {
        Name = name;
        return this;
    }

    public String getEmail() {
        return Email;
    }

    public CustomerDTO setEmail(String email) {
        Email = email;
        return this;
    }

    public String getMobile() {
        return Mobile;
    }

    public CustomerDTO setMobile(String mobile) {
        Mobile = mobile;
        return this;
    }

    public String getImage() {
        return Image;
    }

    public CustomerDTO setImage(String image) {
        Image = image;
        return this;
    }
}
