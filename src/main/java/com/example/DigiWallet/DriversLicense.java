package com.example.DigiWallet;

import lombok.*;

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
    private String Gender;
    private String countryOfResidence;
    private String issueDate;
    private String expiryDate;
    private String driverNumber;
    private Address address;
    private String typeOfLicense;
}
