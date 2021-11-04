package com.dag.bankingsystem.model.request.transaction;


import com.dag.bankingsystem.validation.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateTransactionRequest {

    @NotNull
    @Min(1)
    private Integer sourceAccountId;

    @NotNull
    @Min(1)
    private Integer targetAccountId;

    @AccountType
    private String currency;

    @Min(1)
    private Integer amount;

}
