package com.example.DigiWallet;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class PassportCard {
    private String country;
    private String name;
    private String nationality;
    private String dateOfBirth;
    private Gender Gender;
    private String issueDate;
    private String expiryDate;
}
