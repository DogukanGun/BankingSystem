package com.dag.bankingsystem.controller;


import com.dag.bankingsystem.model.dto.CreditDto;
import com.dag.bankingsystem.model.request.credit.CreateCreditRequest;
import com.dag.bankingsystem.model.request.credit.UpdateCreditRequest;
import com.dag.bankingsystem.service.CreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("credit")
@RequiredArgsConstructor
public class CreditController {
    private final CreditService creditService;

    @GetMapping("{id}")
    public CreditDto getCredit(@PathVariable int id){
        return creditService.getCredit(id);
    }

    @PutMapping("{id}")
    public CreditDto updateCredit(@PathVariable int id, @RequestBody UpdateCreditRequest updateCreditRequest){
        return creditService.updateCredit(id, updateCreditRequest);
    }

    @PostMapping
    public CreditDto createCredit(@RequestBody CreateCreditRequest createCreditRequest){
        return creditService.createCredit(createCreditRequest);
    }
}
