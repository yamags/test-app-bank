package com.bank.javatesttask.api.controller;

import com.bank.javatesttask.dto.AccountDto;
import com.bank.javatesttask.dto.TransactionDto;
import com.bank.javatesttask.entity.Account;
import com.bank.javatesttask.enums.OperationType;
import com.bank.javatesttask.request.AccountOperation;
import com.bank.javatesttask.response.ListResponse;
import com.bank.javatesttask.response.ObjectResponse;
import com.bank.javatesttask.services.AccountService;
import com.bank.javatesttask.services.TransactionService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
    @NonNull
    private ModelMapper modelMapper;

    @NonNull
    private AccountService accountService;

    @NonNull
    private TransactionService transactionService;

    @GetMapping
    public ListResponse<TransactionDto> findAllUserTransactions(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam Optional<OperationType> type) {
        return new ListResponse<TransactionDto>(transactionService
                .findAllUserTransactions(type, page, size)
                .map(transaction -> modelMapper.map(transaction, TransactionDto.class)));
    }
}
