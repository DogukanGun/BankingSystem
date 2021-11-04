package com.dag.bankingsystem.model.request.employee;


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
public class CreateEmployeeRequest {

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    @Min(1)
    private Integer branchId;

    @NotNull
    @Min(1)
    private Integer accountId;

}
