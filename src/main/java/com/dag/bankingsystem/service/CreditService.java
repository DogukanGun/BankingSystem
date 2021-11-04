package com.dag.bankingsystem.service;


import com.dag.bankingsystem.model.dto.CreditDto;
import com.dag.bankingsystem.model.entity.Credit;
import com.dag.bankingsystem.model.request.credit.CreateCreditRequest;
import com.dag.bankingsystem.model.request.credit.UpdateCreditRequest;
import com.dag.bankingsystem.repository.CreditRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import static com.dag.bankingsystem.model.mapper.CreditMapper.CREDIT_MAPPER;

@Service
@RequiredArgsConstructor
public class CreditService {
    private final CreditRepository creditRepository;

    private Credit getCreditById(int id){
        return creditRepository.findById(id).orElseThrow(()->new NotFoundException("Credit cannot be found"));
    }

    public CreditDto createCredit(CreateCreditRequest createCreditRequest){
        Credit credit = CREDIT_MAPPER.createCredit(createCreditRequest);
        return CREDIT_MAPPER.convertToCreditDto(creditRepository.save(credit));
    }

    public CreditDto getCredit(int id){
        return CREDIT_MAPPER.convertToCreditDto(getCreditById(id));
    }

    public CreditDto updateCredit(int id,UpdateCreditRequest updateCreditRequest){
        Credit credit = getCreditById(id);
        CREDIT_MAPPER.updateCredit(credit,updateCreditRequest);
        return CREDIT_MAPPER.convertToCreditDto(creditRepository.save(credit));
    }

}
