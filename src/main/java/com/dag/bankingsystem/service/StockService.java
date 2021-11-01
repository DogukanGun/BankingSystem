package com.dag.bankingsystem.service;


import com.dag.bankingsystem.model.dto.CustomerDto;
import com.dag.bankingsystem.model.dto.InvestmentDto;
import com.dag.bankingsystem.model.dto.StockDto;
import com.dag.bankingsystem.model.entity.Customer;
import com.dag.bankingsystem.model.entity.Stock;
import com.dag.bankingsystem.model.request.stock.CreateStockRequest;
import com.dag.bankingsystem.model.request.stock.UpdateStockRequest;
import com.dag.bankingsystem.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import static com.dag.bankingsystem.model.mapper.CustomerMapper.CUSTOMER_MAPPER;
import static com.dag.bankingsystem.model.mapper.InvestmentMapper.INVESTMENT_MAPPER;
import static com.dag.bankingsystem.model.mapper.StockMapper.STOCK_MAPPER;

@Service
@RequiredArgsConstructor
public class StockService {
    private final StockRepository stockRepository;

    public StockDto buyStock(CreateStockRequest createStockRequest){
        Stock stock = STOCK_MAPPER.createStock(createStockRequest);
        return STOCK_MAPPER.convertToStockDto(stockRepository.save(stock));
    }

    private Stock getStockById(int id){
        return stockRepository.findById(id).orElseThrow(()->new NotFoundException("Stock is not found"));
    }
    public StockDto getStock(int id){
        return STOCK_MAPPER.convertToStockDto(getStockById(id));
    }

    public StockDto getStockByCustomer(int customerId){
        return STOCK_MAPPER.convertToStockDto(stockRepository.findByCustomerId(customerId));
    }

    public StockDto sellStock(int id){
        Stock stock = getStockById(id);
        stock.setSold(true);
        return STOCK_MAPPER.convertToStockDto(stockRepository.save(stock));
    }

    public CustomerDto getCustomer(int id){
        Stock stock = getStockById(id);
        return CUSTOMER_MAPPER.convertToCustomerDto(stock.getCustomer());
    }

    public InvestmentDto getInvestment(int id){
        Stock stock = getStockById(id);
        return INVESTMENT_MAPPER.convertToInvestmentDto(stock.getInvestment());
    }
    public StockDto buyStockMore(int id, UpdateStockRequest updateStockRequest){
        Stock stock = getStockById(id);
        stock.setAmount(stock.getAmount()+updateStockRequest.getAmount());
        stock.setValue(stock.getValue()+updateStockRequest.getValue());
        return STOCK_MAPPER.convertToStockDto(stockRepository.save(stock));
    }

}

