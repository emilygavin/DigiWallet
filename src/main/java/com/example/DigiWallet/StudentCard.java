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
public class StudentCard{
    private String name;
    private String dateOfBirth;
    private String college;
    private String studentID;
    private String courseTitle;
    private String expiryDate;
}
