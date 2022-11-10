package com.example.DigiWallet;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class User {
    @Id
    private String id;
    private String email;
    private String password;
    private List<Cards> cards;

    public User(String email, String password, List<Cards> cards) {
        this.email = email;
        this.password = password;
        this.cards = cards;
    }

    public User() {

    }
}
