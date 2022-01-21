package com.lab2.maintenance.repo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "maintenance ")
@Entity
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer volume;
    private Integer weight;
    private String pointFrom;
    private String pointTo;
    private Integer status;

    public Maintenance(Integer volume, Integer weight, String pointFrom, String pointTo, Integer status) {
        this.volume = volume;
        this.weight = weight;
        this.pointFrom = pointFrom;
        this.pointTo = pointTo;
        this.status = status;
    }
}
