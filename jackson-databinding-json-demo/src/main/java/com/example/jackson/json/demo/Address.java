package com.example.jackson.json.demo;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Address {
    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;
    public Address(){}

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
