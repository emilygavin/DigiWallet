package com.example.DigiWallet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Cards{
    @Embedded
    private DriversLicense driversLicense;
    @Embedded
    private AgeCard ageCard;
    @Embedded
    private PassportCard passportCard;
    @Embedded
    private StudentCard studentCard;
}
