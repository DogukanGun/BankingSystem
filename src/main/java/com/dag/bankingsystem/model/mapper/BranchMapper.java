package com.dag.bankingsystem.model.mapper;

import com.dag.bankingsystem.model.dto.BranchDto;
import com.dag.bankingsystem.model.entity.Branch;
import com.dag.bankingsystem.model.request.branch.CreateBranchRequest;
import com.dag.bankingsystem.model.request.branch.UpdateBranchRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BranchMapper {

    BranchMapper BRANCH_MAPPER = Mappers.getMapper(BranchMapper.class);

    BranchDto convertToBranchDto(Branch branch);

    Branch createBranch(CreateBranchRequest createBranchRequest);

    void updateBranch(@MappingTarget Branch branch, UpdateBranchRequest updateBranchRequest);
}
