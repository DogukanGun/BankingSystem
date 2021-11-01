package com.dag.bankingsystem.model.mapper;


import com.dag.bankingsystem.model.dto.InvestmentDto;
import com.dag.bankingsystem.model.entity.Investment;
import com.dag.bankingsystem.model.request.investment.UpdateCreateInvestmentRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface InvestmentMapper {
    InvestmentMapper INVESTMENT_MAPPER = Mappers.getMapper(InvestmentMapper.class);


    InvestmentDto convertToInvestmentDto(Investment investment);

    Investment createInvestment(UpdateCreateInvestmentRequest updateCreateInvestmentRequest);

    void updateInvestment(@MappingTarget Investment investment,UpdateCreateInvestmentRequest updateCreateInvestmentRequest);
}
