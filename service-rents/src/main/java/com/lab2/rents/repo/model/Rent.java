package com.lab2.rents.repo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "rent")
@Entity
public final class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userId;
    private String info;
    private Integer status;

    public Rent(Long userId, String info, Integer status) {
        this.userId = userId;
        this.info = info;
        this.status = status;
    }
}
