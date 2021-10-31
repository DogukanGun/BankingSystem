package com.dag.bankingsystem.service;


import com.dag.bankingsystem.model.dto.AccountDto;
import com.dag.bankingsystem.model.entity.Account;
import com.dag.bankingsystem.model.request.account.CreateAccountRequest;
import com.dag.bankingsystem.model.request.account.UpdateAccountRequest;
import com.dag.bankingsystem.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import static com.dag.bankingsystem.model.mapper.AccountMapper.ACCOUNT_MAPPER;

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
        return accountRepository.findById(id).orElseThrow(()->new NotFoundException("Account is not found"));
    }

    public void deleteAccount(int id){
        accountRepository.deleteById(id);
    }

    public AccountDto getAccount(int id){
        return ACCOUNT_MAPPER.convertToAccountDto(getAccountBtId(id));
    }
}
