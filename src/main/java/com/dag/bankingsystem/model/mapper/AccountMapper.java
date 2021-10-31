package com.dag.bankingsystem.model.mapper;


import com.dag.bankingsystem.model.dto.AccountDto;
import com.dag.bankingsystem.model.entity.Account;
import com.dag.bankingsystem.model.request.account.CreateAccountRequest;
import com.dag.bankingsystem.model.request.account.UpdateAccountRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")

public interface AccountMapper {

    AccountMapper ACCOUNT_MAPPER = Mappers.getMapper(AccountMapper.class);


    @Mapping(source = "customer.name",target = "customerName")
    @Mapping(source = "branch.name",target = "branchName")
    AccountDto convertToAccountDto(Account account);

    void updateAccount(@MappingTarget Account account, UpdateAccountRequest updateAccountRequest);

    Account createAccount(CreateAccountRequest createAccountRequest);



}
