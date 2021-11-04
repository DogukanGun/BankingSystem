package com.dag.bankingsystem.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDto {

    private Integer id;

    private String name;

    private String surname;

    private Integer branchId;

    private String branchName;

    private Integer accountId;

    private String salaryAccountIban;

    private boolean isFired;
}
