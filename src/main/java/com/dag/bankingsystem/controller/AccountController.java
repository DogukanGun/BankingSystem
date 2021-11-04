package com.dag.bankingsystem.controller;


import com.dag.bankingsystem.model.dto.AccountDto;
import com.dag.bankingsystem.model.dto.BranchDto;
import com.dag.bankingsystem.model.dto.CustomerDto;
import com.dag.bankingsystem.model.dto.TransactionDto;
import com.dag.bankingsystem.model.request.account.CreateAccountRequest;
import com.dag.bankingsystem.model.request.account.UpdateAccountRequest;
import com.dag.bankingsystem.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping("{id}")
    public AccountDto getAccount(@PathVariable int id){
        return accountService.getAccount(id);
    }

    @GetMapping("{id}/branch")
    public BranchDto getBranch(@PathVariable int id){
        return accountService.getBranchInformation(id);
    }

    @GetMapping("{id}/customer")
    public CustomerDto getCustomer(@PathVariable int id){
        return accountService.getCustomerInformation(id);
    }

    @GetMapping("{id}/transactions/out")
    public List<TransactionDto> getOutTransactions(@PathVariable int id){
        return accountService.getOutTransactions(id);
    }

    @GetMapping("{id}/transactions/in")
    public List<TransactionDto> getInTransactions(@PathVariable int id){
        return accountService.getInTransactions(id);
    }

    @PostMapping
    public AccountDto createAccount(@Valid @RequestBody CreateAccountRequest createAccountRequest){
        return accountService.createAccount(createAccountRequest);
    }

    @DeleteMapping
    public void deleteAccount(@RequestParam int id){
        accountService.deleteAccount(id);
    }

    @PutMapping("{id}")
    public AccountDto updateAccount(@PathVariable int id,@Valid @RequestBody UpdateAccountRequest updateAccountRequest){
        return accountService.updateAccount(id,updateAccountRequest);
    }

    @PostMapping("{id}/withdraw-money")
    public AccountDto withdrawMoney(@PathVariable int id,@RequestParam int money){
        return accountService.withdrawMoney(id,money);
    }

    @PostMapping("{id}/deposit-money")
    public AccountDto depositMoney(@PathVariable int id,@RequestParam int money){
        return accountService.depositMoney(id,money);
    }
}
