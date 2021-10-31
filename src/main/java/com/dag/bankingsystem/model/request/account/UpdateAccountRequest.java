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
public class UpdateAccountRequest {
    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @Min(0)
    private int balance;
}
