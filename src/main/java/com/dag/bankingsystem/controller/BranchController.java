package com.dag.bankingsystem.controller;


import com.dag.bankingsystem.model.dto.BranchDto;
import com.dag.bankingsystem.model.request.branch.CreateBranchRequest;
import com.dag.bankingsystem.model.request.branch.UpdateBranchRequest;
import com.dag.bankingsystem.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("branch")
@RequiredArgsConstructor
public class BranchController {
    private final BranchService branchService;

    @GetMapping("{id}")
    public BranchDto getBranch(@PathVariable int id){
        return branchService.getBranch(id);
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
