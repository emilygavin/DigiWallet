package com.example.DigiWallet;

import lombok.*;
import javax.persistence.Column;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class User {
    private String id;
    private String name;
    private String gender;
    @Column(unique = true)
    private String email;
    private String password;
    private String uri;
    private Cards cards;

    public User(String name, String gender, String email, String password, Cards cards) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.cards = cards;
    }

    public User(String id, String name, String gender, String email, String password, String uri, Cards cards) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.uri = uri;
        this.cards = cards;
    }
}


