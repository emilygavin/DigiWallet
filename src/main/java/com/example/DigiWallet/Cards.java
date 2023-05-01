package com.example.DigiWallet;

import lombok.*;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Cards{
    private DriversLicense driversLicense;
    private AgeCard ageCard;
    private PassportCard passportCard;
    private StudentCard studentCard;
}
