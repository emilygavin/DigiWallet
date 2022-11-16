package com.example.DigiWallet;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class DriversLicense extends Cards{
    private String name;
    private String dateOfBirth;
    private Gender Gender;
    private String countryOfResidence;
    private String issueDate;
    private String expiryDate;
    private String driverNumber;
    private Address address;
    private String typeOfLicense;
}
