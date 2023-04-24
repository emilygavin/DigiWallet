package com.example.DigiWallet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String firstLine;
    private String secondLine;
    private String city;
    private String county;
}
