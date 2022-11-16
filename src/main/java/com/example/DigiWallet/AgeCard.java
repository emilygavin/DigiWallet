package com.example.DigiWallet;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Data
@Embeddable
public class AgeCard extends Cards{
    private String name;
    private String dateOfBirth;
    private Gender gender;
    @Embedded
    private Address address;
    private String cardNumber;

    public AgeCard(String name, String dateOfBirth, Gender gender, Address address, String cardNumber) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.cardNumber = cardNumber;
    }
}
