package com.dag.bankingsystem.controller;


import com.dag.bankingsystem.model.dto.TransactionDto;
import com.dag.bankingsystem.model.request.transaction.CreateTransactionRequest;
import com.dag.bankingsystem.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("transaction")
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping("{id}")
    public TransactionDto getTransaction(@PathVariable int id){
        return transactionService.getTransaction(id);
    }

    @PostMapping
    public TransactionDto createTransaction(@RequestBody CreateTransactionRequest createTransactionRequest){
        return transactionService.createTransaction(createTransactionRequest);
    }

    @DeleteMapping
    public void deleteTransaction(@RequestParam int id){
        transactionService.deleteTransactionById(id);
    }

    @DeleteMapping("cancel-order")
    public TransactionDto cancelTransaction(@RequestParam int id){
        return transactionService.cancelOrder(id);
    }
}
