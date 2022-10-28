package com.bank.javatesttask.dto;

import com.bank.javatesttask.entity.Account;
import com.bank.javatesttask.enums.AccountStatus;
import com.bank.javatesttask.enums.OperationType;
import lombok.Data;

import java.math.BigDecimal;


@Data
public class TransactionDto {
    private Long id;
    private AccountDto account;
    private CurrencyDto currency;
    private BigDecimal amount;
    private OperationType type;
}
