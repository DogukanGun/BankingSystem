package com.dag.bankingsystem.controller;

import com.dag.bankingsystem.model.dto.StockDto;
import com.dag.bankingsystem.model.entity.Stock;
import com.dag.bankingsystem.model.request.stock.CreateStockRequest;
import com.dag.bankingsystem.model.request.stock.UpdateStockRequest;
import com.dag.bankingsystem.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("stock")
@RequiredArgsConstructor
public class StockController {
    private final StockService stockService;

    @GetMapping("{id}")
    public StockDto getStock(@PathVariable int id){
        return stockService.getStock(id);
    }

    @GetMapping("customer/{id}")
    public StockDto getStockByCustomer(@PathVariable int id){
        return stockService.getStockByCustomer(id);
    }

    @PostMapping
    public StockDto buyStock(@RequestBody CreateStockRequest createStockRequest){
        return stockService.buyStock(createStockRequest);
    }

    @PostMapping("{id}/sell-stock")
    public StockDto sellStock(@PathVariable int id){
        return stockService.sellStock(id);
    }

    @PutMapping("{id}/buy-stock-more")
    public StockDto buyStockMore(@PathVariable int id,@RequestBody UpdateStockRequest updateStockRequest){
        return stockService.buyStockMore(id,updateStockRequest);
    }
}
