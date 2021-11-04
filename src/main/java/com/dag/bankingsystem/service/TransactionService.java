package com.dag.bankingsystem.service;


import com.dag.bankingsystem.model.dto.TransactionDto;
import com.dag.bankingsystem.model.entity.Transaction;
import com.dag.bankingsystem.model.request.transaction.CreateTransactionRequest;
import com.dag.bankingsystem.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import static com.dag.bankingsystem.model.mapper.TransactionMapper.TRANSACTION_MAPPER;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionDto createTransaction(CreateTransactionRequest createTransactionRequest){
        Transaction transaction = TRANSACTION_MAPPER.createTransaction(createTransactionRequest);
        return TRANSACTION_MAPPER.convertToTransactionDto(transactionRepository.save(transaction));
    }

    public void deleteTransactionById(int id){
        transactionRepository.deleteById(id);
    }

    private Transaction getTransactionById(int id){
        return transactionRepository.findById(id).orElseThrow(()->new NotFoundException("Transaction cannot be found"));
    }

    public TransactionDto getTransaction(int id){
        return TRANSACTION_MAPPER.convertToTransactionDto(getTransactionById(id));
    }

    public TransactionDto cancelOrder(int id){
        Transaction transaction = getTransactionById(id);
        transaction.setCanceled(true);
        return TRANSACTION_MAPPER.convertToTransactionDto(transactionRepository.save(transaction));
    }
}
