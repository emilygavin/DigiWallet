package com.example.DigiWallet;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class DriversLicense {
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
