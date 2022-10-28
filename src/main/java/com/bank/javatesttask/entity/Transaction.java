package com.bank.javatesttask.entity;

import com.bank.javatesttask.enums.AccountStatus;
import com.bank.javatesttask.enums.OperationType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "transactions")
@Getter
@Setter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(name = "currency_id", nullable = false)
    private Currency currency;

    @Column(precision=10, scale=2)
    private BigDecimal amount;

    @Column
    @Enumerated(EnumType.ORDINAL)
    private OperationType type;
}
