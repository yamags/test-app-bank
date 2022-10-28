package com.bank.javatesttask.entity;

import com.bank.javatesttask.enums.AccountStatus;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String accountNumber;

    @ManyToOne
    @JoinColumn(name = "currency_id", nullable = false)
    private Currency currency;

    @Column(precision=10, scale=2)
    private BigDecimal balance;

    @Column
    @Enumerated(EnumType.ORDINAL)
    private AccountStatus status;
}
