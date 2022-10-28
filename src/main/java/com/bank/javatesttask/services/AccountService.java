package com.bank.javatesttask.services;

import com.bank.javatesttask.entity.Account;
import com.bank.javatesttask.request.AccountOperation;

public interface AccountService {
    Account findByAccountNumber(String accountNumber);

    Account performOperation(Account account, AccountOperation accountOperation);
}
