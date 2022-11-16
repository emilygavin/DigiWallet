package com.example.DigiWallet;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class StudentCard extends Cards{
    private String name;
    private String dateOfBirth;
    private String college;
    private String studentID;
    private String courseTitle;
    private String expiryDate;
}
