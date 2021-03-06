package com.dag.bankingsystem.controller;

import com.dag.bankingsystem.model.dto.CustomerDto;
import com.dag.bankingsystem.model.dto.InvestmentDto;
import com.dag.bankingsystem.model.dto.StockDto;
import com.dag.bankingsystem.model.entity.Investment;
import com.dag.bankingsystem.model.request.investment.UpdateCreateInvestmentRequest;
import com.dag.bankingsystem.service.InvestmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("investment")
@RequiredArgsConstructor
public class InvestmentController {
    private final InvestmentService investmentService;


    @GetMapping("{id}")
    public InvestmentDto getInvestment(@PathVariable int id){
        return investmentService.getInvestment(id);
    }

    @GetMapping("{id}/stocks")
    public List<StockDto> getStocks(@PathVariable int id){
        return investmentService.getStocks(id);
    }

    @GetMapping("{id}/customers")
    public List<CustomerDto> getCustomers(@PathVariable int id){
        return investmentService.getCustomers(id);
    }
    @PostMapping
    public InvestmentDto createInvestment(@Valid @RequestBody UpdateCreateInvestmentRequest updateCreateInvestmentRequest){
        return investmentService.createInvestment(updateCreateInvestmentRequest);
    }

    @PutMapping("{id}")
    public InvestmentDto updateInvestment(@PathVariable int id,@Valid @RequestBody UpdateCreateInvestmentRequest updateCreateInvestmentRequest){
        return investmentService.updateInvestment(id,updateCreateInvestmentRequest);
    }

    @PatchMapping("{id}/increment-fund")
    public InvestmentDto incrementFunc(@PathVariable int id,@RequestParam int fund){
        return investmentService.incrementFundOfInvestment(id,fund);
    }

    @DeleteMapping
    public void deleteInvestment(@RequestParam int id){
        investmentService.deleteInvestment(id);
    }

}
