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
}
