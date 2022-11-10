package com.example.DigiWallet;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class User {
    @Id
    private String id;
    private String email;
    private String password;
    private Cards cards;

    public User(String email, String password, Cards cards) {
        this.email = email;
        this.password = password;
        this.cards = cards;
    }

    public User() {

    }
}
