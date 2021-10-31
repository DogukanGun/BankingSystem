package com.dag.bankingsystem.model.request.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateAccountRequest {

    @NotNull
    @Min(0)
    private Integer customerId;

    @NotBlank
    @NotNull
    private String currency;

    @NotBlank
    @NotNull
    private String name;

    @Min(0)
    @NotNull
    private Integer branchId;

}
