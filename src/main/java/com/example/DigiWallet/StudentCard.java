package com.example.DigiWallet;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class StudentCard {
    private String name;
    private String dateOfBirth;
    private String College;
    private String studentID;
    private String courseTitle;
    private String expiryDate;
}
