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
}
