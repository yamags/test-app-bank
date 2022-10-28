package com.bank.javatesttask.dto;

import com.bank.javatesttask.enums.AccountStatus;
import lombok.Data;

import java.math.BigDecimal;


@Data
public class AccountDto {
    private Long id;
    private String accountNumber;
    private CurrencyDto currency;
    private BigDecimal balance;
    private AccountStatus status;
}
