package com.bank.javatesttask.services;

import com.bank.javatesttask.entity.Account;
import com.bank.javatesttask.entity.Currency;
import com.bank.javatesttask.entity.Transaction;
import com.bank.javatesttask.enums.OperationType;
import com.bank.javatesttask.request.AccountOperation;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.Optional;

public interface TransactionService {
    public Transaction create(Account account, Currency currency, BigDecimal amount, OperationType type);

    public Page<Transaction> findAllUserTransactions(Optional<OperationType> type, Integer page, Integer size);
}
