package com.example.DigiWallet;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

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
