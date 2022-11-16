package com.example.DigiWallet;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.Embedded;

import java.util.List;

@Data
@Document
public class User {
    @Id
    private String id;
    private String email;
    private String password;
    @Embedded
    private List<Cards> cards;

    public User(String email, String password, List<Cards> cards) {
        this.email = email;
        this.password = password;
        this.cards = cards;
    }

    public User() {

    }
}
