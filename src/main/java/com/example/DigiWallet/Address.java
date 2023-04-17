package com.example.DigiWallet;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Address {
    private String firstLine;
    private String secondLine;
    private String city;
    private String county;

    public Address(String firstLine, String secondLine, String city, String county) {
        this.firstLine = firstLine;
        this.secondLine = secondLine;
        this.city = city;
        this.county = county;
    }

    public Address() {

    }
}
