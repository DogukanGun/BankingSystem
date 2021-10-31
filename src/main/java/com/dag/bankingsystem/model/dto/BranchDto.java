package com.dag.bankingsystem.model.dto;


import com.dag.bankingsystem.model.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BranchDto {
    private Integer id;

    private String name;

    private Address address;
}
