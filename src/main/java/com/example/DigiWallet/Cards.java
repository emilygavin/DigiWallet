package com.example.DigiWallet;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Cards extends User{
    private DriversLicense driversLicense;
    private AgeCard ageCard;
    private PassportCard passportCard;
    private StudentCard studentCard;

    public Cards(String email, String password, Cards card) {
        super(email, password, card);
    }

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
