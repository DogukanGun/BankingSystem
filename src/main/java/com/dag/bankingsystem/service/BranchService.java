package com.dag.bankingsystem.service;

import com.dag.bankingsystem.model.dto.BranchDto;
import com.dag.bankingsystem.model.entity.Branch;
import com.dag.bankingsystem.model.request.branch.CreateBranchRequest;
import com.dag.bankingsystem.model.request.branch.UpdateBranchRequest;
import com.dag.bankingsystem.repository.BranchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import static com.dag.bankingsystem.model.mapper.BranchMapper.BRANCH_MAPPER;

@Service
@RequiredArgsConstructor
public class BranchService {
    private final BranchRepository branchRepository;

    public BranchDto createBranch(CreateBranchRequest createBranchRequest){
        Branch branch = BRANCH_MAPPER.createBranch(createBranchRequest);
        return BRANCH_MAPPER.convertToBranchDto(branchRepository.save(branch));
    }

    public BranchDto updateBranch(int id,UpdateBranchRequest updateBranchRequest){
        Branch branch = getBranchById(id);
        BRANCH_MAPPER.updateBranch(branch,updateBranchRequest);
        return BRANCH_MAPPER.convertToBranchDto(branchRepository.save(branch));
    }
    private Branch getBranchById(int id){
        return branchRepository.findById(id).orElseThrow(()->new NotFoundException("Branch is not found"));
    }
    public void deleteBranch(int id){
        branchRepository.deleteById(id);
    }

    public BranchDto getBranch(int id){
        return BRANCH_MAPPER.convertToBranchDto(getBranchById(id));
    }

}
