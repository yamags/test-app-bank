package com.bank.javatesttask.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "currencies")
@Getter
@Setter
public class Currency {
    @Id
    @Column(unique = true)
    private Long id;

    @Column(unique = true)
    private String code;
}
