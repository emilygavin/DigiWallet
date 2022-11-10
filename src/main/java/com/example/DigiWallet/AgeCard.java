package com.example.DigiWallet;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class AgeCard {
    private String name;
    private String dateOfBirth;
    private Gender Gender;
    private Address address;
    private String cardNumber;

    public AgeCard(String name, String dateOfBirth, com.example.DigiWallet.Gender gender, Address address, String cardNumber) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        Gender = gender;
        this.address = address;
        this.cardNumber = cardNumber;
    }
}
