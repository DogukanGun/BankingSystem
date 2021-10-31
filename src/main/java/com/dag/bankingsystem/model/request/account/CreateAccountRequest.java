package com.dag.bankingsystem.model.request.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateAccountRequest {

    private Integer customerId;

    private String currency;

    private String name;

    private Integer branchId;

}
