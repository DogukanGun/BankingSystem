package com.dag.bankingsystem.controller;


import com.dag.bankingsystem.model.dto.AddressDto;
import com.dag.bankingsystem.model.dto.BranchDto;
import com.dag.bankingsystem.model.dto.CreditDto;
import com.dag.bankingsystem.model.entity.Credit;
import com.dag.bankingsystem.model.request.branch.CreateBranchRequest;
import com.dag.bankingsystem.model.request.branch.UpdateBranchRequest;
import com.dag.bankingsystem.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("branch")
@RequiredArgsConstructor
public class BranchController {
    private final BranchService branchService;

    @GetMapping("{id}")
    public BranchDto getBranch(@PathVariable int id){
        return branchService.getBranch(id);
    }

    @GetMapping("{id}/credits")
    public List<CreditDto> getCredits(@PathVariable int id){
        return branchService.getCredits(id);
    }

    @GetMapping("{id}/credits/{credit_id}")
    public CreditDto getCreditById(@PathVariable int id,@PathVariable int credit_id){
        return branchService.getCreditByCreditId(id,credit_id);
    }

    @GetMapping("{id}/address")
    public AddressDto getAddress(@PathVariable int id){
        return branchService.getAddress(id);
    }
    @PostMapping
    public BranchDto createBranch(@RequestBody CreateBranchRequest createBranchRequest){
        return branchService.createBranch(createBranchRequest);
    }

    @PutMapping("{id}")
    public BranchDto updateBranch(@PathVariable int id,@RequestBody UpdateBranchRequest updateBranchRequest){
        return branchService.updateBranch(id,updateBranchRequest);
    }

    @DeleteMapping
    public void deleteBranch(@RequestParam int id){
        branchService.deleteBranch(id);
    }
}
