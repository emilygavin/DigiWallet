package com.example.DigiWallet;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.UniqueConstraint;

import java.util.List;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String id;
    private String name;
    private Gender gender;
    @Column(unique = true)
    private String email;
    private String password;
    private Cards cards;

    public User(String name, Gender gender, String email, String password, Cards cards) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.cards = cards;
    }
}


