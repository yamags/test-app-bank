package com.bank.javatesttask.api.controller;

import com.bank.javatesttask.dto.AccountDto;
import com.bank.javatesttask.entity.Account;
import com.bank.javatesttask.request.AccountOperation;
import com.bank.javatesttask.response.ObjectResponse;
import com.bank.javatesttask.services.AccountService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/account")
public class AccountController {
    @NonNull
    private ModelMapper modelMapper;

    @NonNull
    private AccountService accountService;

    @GetMapping("/{account_number}/inquiry")
    public ObjectResponse<AccountDto> inquiry(@PathVariable(value = "account_number") String accountNumber) {
        return new ObjectResponse<AccountDto>(modelMapper.map(
                accountService.findByAccountNumber(accountNumber),
                AccountDto.class));
    }

    @PostMapping("/{account_number}/operation")
    public ObjectResponse<AccountDto> operation(@PathVariable(value = "account_number") String accountNumber,
                                                @Validated @RequestBody AccountOperation accountOperation) {
        Account account = accountService.findByAccountNumber(accountNumber);
        account = accountService.performOperation(account, accountOperation);

        return new ObjectResponse<AccountDto>(modelMapper.map(
                account,
                AccountDto.class));
    }
}
