package com.dag.bankingsystem.service;

import com.dag.bankingsystem.model.dto.AccountDto;
import com.dag.bankingsystem.model.entity.Account;
import com.dag.bankingsystem.model.request.account.UpdateAccountRequest;
import com.dag.bankingsystem.repository.AccountRepository;
import org.checkerframework.checker.nullness.Opt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

    @InjectMocks
    private AccountService sut;

    @Mock
    private AccountRepository accountRepository;

    @Captor
    private ArgumentCaptor<Account> accountArgumentCaptor;

    private AccountDto accountDto;

    private UpdateAccountRequest updateAccountRequest;

    @BeforeEach
    void setup(){
        accountDto = AccountDto.builder()
                .id(any())
                .balance(200)
                .build();

        updateAccountRequest = UpdateAccountRequest.builder()
                .balance(200)
                .build();
    }

    @Test
    void it_should_update_account(){
        //Given
        when(accountRepository.findById(0)).thenReturn(
                Optional.of(
                        Account.builder()
                                .balance(100)
                                .build()
                )
        );
        when(accountRepository.save(accountArgumentCaptor.capture())).thenReturn(
                Account.builder()
                        .balance(200)
                        .build()
        );

        //Given
        AccountDto accountDtoFromRepo = sut.updateAccount(0,updateAccountRequest);

        //Then
        Assertions.assertEquals(accountDto.getBalance(),accountDtoFromRepo.getBalance());
    }

}
