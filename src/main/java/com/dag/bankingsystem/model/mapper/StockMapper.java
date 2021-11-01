package com.dag.bankingsystem.model.mapper;

import com.dag.bankingsystem.model.dto.StockDto;
import com.dag.bankingsystem.model.entity.Stock;
import com.dag.bankingsystem.model.request.stock.CreateStockRequest;
import com.dag.bankingsystem.model.request.stock.UpdateStockRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StockMapper {

    StockMapper STOCK_MAPPER = Mappers.getMapper(StockMapper.class);

    @Mapping(source = "customer.name",target = "customerName")
    StockDto convertToStockDto(Stock stock);

    Stock createStock(CreateStockRequest createStockRequest);

    void updateStock(@MappingTarget Stock stock, UpdateStockRequest updateStockRequest);
}
