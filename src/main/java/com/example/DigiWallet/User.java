package com.example.DigiWallet;

import lombok.*;
import javax.persistence.Column;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
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
}


