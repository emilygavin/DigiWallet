package com.example.DigiWallet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Cards{
    private DriversLicense driversLicense;
    private AgeCard ageCard;
    private PassportCard passportCard;
    private StudentCard studentCard;

    public Cards(DriversLicense driversLicense) {
        this.driversLicense = driversLicense;
    }

    public Cards(AgeCard ageCard) {
        this.ageCard = ageCard;
    }

    public Cards(PassportCard passportCard) {
        this.passportCard = passportCard;
    }

    public Cards(StudentCard studentCard) {
        this.studentCard = studentCard;
    }
}
