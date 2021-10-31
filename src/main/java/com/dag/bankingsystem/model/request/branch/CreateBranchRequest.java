package com.dag.bankingsystem.model.request.branch;


import com.dag.bankingsystem.model.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateBranchRequest {
    private String name;

    private Address address;
}
