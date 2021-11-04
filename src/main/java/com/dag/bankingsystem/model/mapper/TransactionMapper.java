package com.dag.bankingsystem.model.mapper;


import com.dag.bankingsystem.model.dto.TransactionDto;
import com.dag.bankingsystem.model.entity.Transaction;
import com.dag.bankingsystem.model.request.transaction.CreateTransactionRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    TransactionMapper TRANSACTION_MAPPER = Mappers.getMapper(TransactionMapper.class);

    Transaction createTransaction(CreateTransactionRequest createTransactionRequest);

    @Mapping(source = "sourceAccount.iban",target = "sourceAccountIban")
    @Mapping(source = "targetAccount.iban",target = "targetAccountIban")
    TransactionDto convertToTransactionDto(Transaction transaction);

    List<TransactionDto> convertToTransactionDtoList(List<Transaction> transactions);
}
