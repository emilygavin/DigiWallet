package com.example.DigiWallet;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Embeddable;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class DriversLicense{
    private String type;
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
