package com.dag.bankingsystem.service;


import com.dag.bankingsystem.exception.ApiException;
import com.dag.bankingsystem.model.dto.AccountDto;
import com.dag.bankingsystem.model.dto.BranchDto;
import com.dag.bankingsystem.model.dto.CustomerDto;
import com.dag.bankingsystem.model.dto.TransactionDto;
import com.dag.bankingsystem.model.entity.Account;
import com.dag.bankingsystem.model.entity.Branch;
import com.dag.bankingsystem.model.request.account.CreateAccountRequest;
import com.dag.bankingsystem.model.request.account.UpdateAccountRequest;
import com.dag.bankingsystem.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

import static com.dag.bankingsystem.model.mapper.AccountMapper.ACCOUNT_MAPPER;
import static com.dag.bankingsystem.model.mapper.BranchMapper.BRANCH_MAPPER;
import static com.dag.bankingsystem.model.mapper.CustomerMapper.CUSTOMER_MAPPER;
import static com.dag.bankingsystem.model.mapper.TransactionMapper.TRANSACTION_MAPPER;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountDto createAccount(CreateAccountRequest createAccountRequest){
        Account account = ACCOUNT_MAPPER.createAccount(createAccountRequest);
        return ACCOUNT_MAPPER.convertToAccountDto(accountRepository.save(account));
    }

    public AccountDto updateAccount(int id,UpdateAccountRequest updateAccountRequest){
        Account account = getAccountBtId(id);
        ACCOUNT_MAPPER.updateAccount(account,updateAccountRequest);
        return ACCOUNT_MAPPER.convertToAccountDto(accountRepository.save(account));
    }

    private Account getAccountBtId(int id) {
        return accountRepository.findById(id).orElseThrow(()->new NotFoundException("Account cannot be found"));
    }

    public AccountDto withdrawMoney(int id,int money){
        Account account = getAccountBtId(id);
        if (account.getBalance()<money){
            throw new ApiException("You don't have enough money to withdraw", HttpStatus.BAD_REQUEST);
        }
        account.setBalance(account.getBalance()-money);
        return ACCOUNT_MAPPER.convertToAccountDto(accountRepository.save(account));
    }

    public BranchDto getBranchInformation(int id){
        Account account = getAccountBtId(id);
        return BRANCH_MAPPER.convertToBranchDto(account.getBranch());
    }
    public CustomerDto getCustomerInformation(int id){
        Account account = getAccountBtId(id);
        return CUSTOMER_MAPPER.convertToCustomerDto(account.getCustomer());
    }
    public AccountDto depositMoney(int id,int money){
        Account account = getAccountBtId(id);
        account.setBalance(account.getBalance()+money);
        return ACCOUNT_MAPPER.convertToAccountDto(accountRepository.save(account));
    }

    public List<TransactionDto> getOutTransactions(int id){
        Account account = getAccountBtId(id);
        return TRANSACTION_MAPPER.convertToTransactionDtoList(account.getOutTransactions());
    }

    public List<TransactionDto> getInTransactions(int id){
        Account account = getAccountBtId(id);
        return TRANSACTION_MAPPER.convertToTransactionDtoList(account.getInTransactions());
    }
    public void deleteAccount(int id){
        accountRepository.deleteById(id);
    }

    public AccountDto getAccount(int id){
        return ACCOUNT_MAPPER.convertToAccountDto(getAccountBtId(id));
    }
}
