package com.example.DigiWallet;

import lombok.*;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class StudentCard{
    private String type;
    private String name;
    private String dateOfBirth;
    private String college;
    private String studentID;
    private String courseTitle;
    private String expiryDate;
}
