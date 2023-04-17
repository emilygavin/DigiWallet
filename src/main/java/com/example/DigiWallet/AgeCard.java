package com.example.DigiWallet;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class AgeCard {
    private String type;
    private String name;
    private String dateOfBirth;
    private Gender gender;
    private String cardNumber;
}
