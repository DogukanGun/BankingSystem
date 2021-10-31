package com.dag.bankingsystem.model.request.branch;


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
public class CreateBranchRequest {

    @NotBlank
    @NotNull
    private String name;

    @NotNull
    @Min(0)
    private Integer addressId;
}
