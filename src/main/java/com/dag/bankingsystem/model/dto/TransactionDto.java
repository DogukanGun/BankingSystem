package com.dag.bankingsystem.model.dto;


import com.dag.bankingsystem.model.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {
    private Integer id;

    private Integer sourceAccountId;

    private String sourceAccountIban;

    private Integer targetAccountId;

    private String targetAccountIban;

    private String currency;

    private Integer amount;

    private boolean isCanceled;


}
