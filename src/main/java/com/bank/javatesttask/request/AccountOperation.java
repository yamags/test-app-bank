package com.bank.javatesttask.request;

import com.bank.javatesttask.enums.OperationType;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class AccountOperation {
    @NotNull(message = "Amount is required")
    private BigDecimal amount;

    @NotNull(message = "Currency Id is required")
    private Long currencyId;

    @NotNull(message = "Operation Type is required")
    private OperationType operationType;
}
