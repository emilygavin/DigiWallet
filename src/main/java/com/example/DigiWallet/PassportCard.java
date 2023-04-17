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
public class PassportCard{
    private String type;
    private String country;
    private String name;
    private String nationality;
    private String passportNumber;
    private String dateOfBirth;
    private Gender Gender;
    private String issueDate;
    private String expiryDate;
}
