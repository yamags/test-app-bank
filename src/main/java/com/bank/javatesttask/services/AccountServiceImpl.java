package com.bank.javatesttask.services;

import com.bank.javatesttask.api.exception.NotFoundException;
import com.bank.javatesttask.api.exception.OperationException;
import com.bank.javatesttask.entity.Account;
import com.bank.javatesttask.enums.AccountStatus;
import com.bank.javatesttask.enums.OperationType;
import com.bank.javatesttask.repository.AccountRepository;
import com.bank.javatesttask.request.AccountOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    @NotNull
    private final AccountRepository accountRepository;

    @NotNull
    private final TransactionService transactionService;

    @Override
    public Account findByAccountNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new NotFoundException("Account not found: " + accountNumber));
    }

    @Transactional
    @Override
    public Account performOperation(Account account, AccountOperation accountOperation) {
        if (account.getStatus() == AccountStatus.CLOSED) {
            throw new OperationException("Account is closed");
        }
        if (!Objects.equals(account.getCurrency().getId(), accountOperation.getCurrencyId())) {
            throw new OperationException("Currency of account and operation should be equal");
        }
        if (accountOperation.getOperationType() == OperationType.DEBIT) {
            if (account.getBalance().compareTo(accountOperation.getAmount()) < 0) {
                throw new OperationException("Not enough money");
            }
            account.setBalance(account.getBalance().subtract(accountOperation.getAmount()));
        } else if (accountOperation.getOperationType() == OperationType.CREDIT) {
            account.setBalance(account.getBalance().add(accountOperation.getAmount()));
        } else {
            throw new OperationException("Unknown operation type");
        }
        transactionService.create(account, account.getCurrency(), accountOperation.getAmount(), accountOperation.getOperationType());
        accountRepository.save(account);
        return account;
    }
}
