package com.dag.bankingsystem.model.request.credit;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateCreditRequest {

    private int instalmentCount;

    private Integer money;

    private Integer interestRate;

    private Integer customerId;

    private Integer branchId;
}
