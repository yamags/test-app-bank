package com.bank.javatesttask.services;

import com.bank.javatesttask.api.exception.NotFoundException;
import com.bank.javatesttask.api.exception.OperationException;
import com.bank.javatesttask.entity.Account;
import com.bank.javatesttask.entity.Currency;
import com.bank.javatesttask.entity.Transaction;
import com.bank.javatesttask.enums.AccountStatus;
import com.bank.javatesttask.enums.OperationType;
import com.bank.javatesttask.repository.AccountRepository;
import com.bank.javatesttask.repository.TransactionRepository;
import com.bank.javatesttask.request.AccountOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    @NotNull
    private final TransactionRepository transactionRepository;

    @Override
    public Transaction create(Account account, Currency currency, BigDecimal amount, OperationType type) {
        Transaction transaction = new Transaction();

        transaction.setAccount(account);
        transaction.setAmount(amount);
        transaction.setCurrency(currency);
        transaction.setType(type);

        transactionRepository.save(transaction);
        return transaction;
    }

    @Override
    public Page<Transaction> findAllUserTransactions(Optional<OperationType> type, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        if (type.isPresent()) {
            return transactionRepository.findAllByType(type.get(), pageable);
        } else {
            return transactionRepository.findAll(pageable);
        }
    }
}
