package com.dag.bankingsystem.model.mapper;


import com.dag.bankingsystem.model.dto.CreditDto;
import com.dag.bankingsystem.model.entity.Credit;
import com.dag.bankingsystem.model.request.credit.CreateCreditRequest;
import com.dag.bankingsystem.model.request.credit.UpdateCreditRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CreditMapper {

    CreditMapper CREDIT_MAPPER = Mappers.getMapper(CreditMapper.class);

    @Mapping(source = "customer.name",target = "customerName")
    @Mapping(source = "branch.name",target = "branchName")
    CreditDto convertToCreditDto(Credit credit);

    List<CreditDto> convertToCreditDtoList(List<Credit>credits);
    Credit createCredit(CreateCreditRequest createCreditRequest);

    void updateCredit(@MappingTarget Credit credit, UpdateCreditRequest updateCreditRequest);
}
