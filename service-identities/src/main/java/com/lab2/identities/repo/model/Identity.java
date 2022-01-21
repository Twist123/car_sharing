package com.lab2.identities.repo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "identities")
@Entity
public final class Identity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String login;
    private String password;
    private String passwordHash;
    private Boolean moderator;
    private Integer status;

    public Identity(String login, String password, Boolean moderator, Integer status) {
        this.login = login;
        this.password = password;
        this.passwordHash = password;
        this.moderator = moderator;
        this.status = status;
    }
}
