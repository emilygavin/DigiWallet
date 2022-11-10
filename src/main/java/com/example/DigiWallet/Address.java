package com.example.DigiWallet;

import lombok.Data;

@Data
public class Address {
    private String firstLine;
    private String secondLine;
    private String city;
    private String county;
    private String country;
    private String postCode;

    public Address(String firstLine, String secondLine, String city, String county, String country, String postCode) {
        this.firstLine = firstLine;
        this.secondLine = secondLine;
        this.city = city;
        this.county = county;
        this.country = country;
        this.postCode = postCode;
    }
}
