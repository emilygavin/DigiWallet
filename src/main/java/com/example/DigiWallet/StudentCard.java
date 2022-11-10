package com.example.DigiWallet;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class StudentCard extends Cards{
    private String name;
    private String dateOfBirth;
    private String college;
    private String studentID;
    private String courseTitle;
    private String expiryDate;

    public StudentCard(String name, String dateOfBirth, String college, String studentID, String courseTitle, String expiryDate) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.college = college;
        this.studentID = studentID;
        this.courseTitle = courseTitle;
        this.expiryDate = expiryDate;
    }
}
