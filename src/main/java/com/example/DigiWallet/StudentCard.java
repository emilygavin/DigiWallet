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

    public StudentCard(String name, String dateOfBirth, String college, String studentID, String courseTitle, String expiryDate) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        College = college;
        this.studentID = studentID;
        this.courseTitle = courseTitle;
        this.expiryDate = expiryDate;
    }
}
