package com.dag.bankingsystem.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreditDto {
    private Integer id;

    private int instalmentCount;

    private Integer money;

    private Integer interestRate;

    private Integer customerId;

    private String customerName;

    private Integer branchId;

    private String branchName;
}
