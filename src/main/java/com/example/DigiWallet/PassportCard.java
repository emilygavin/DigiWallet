package com.example.DigiWallet;

import lombok.*;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class PassportCard{
    private String type;
    private String country;
    private String name;
    private String nationality;
    private String passportNumber;
    private String dateOfBirth;
    private String Gender;
    private String issueDate;
    private String expiryDate;
}
