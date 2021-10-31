package com.dag.bankingsystem.model.dto;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {


    private Integer id;

    private Integer customerId;

    private String customerName;

    private String currency;

    private String iban;

    private String branchName;

    private Integer branchId;

    private int balance;
}
