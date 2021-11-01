package com.dag.bankingsystem.service;

import com.dag.bankingsystem.model.dto.InvestmentDto;
import com.dag.bankingsystem.model.entity.Investment;
import com.dag.bankingsystem.model.request.investment.UpdateCreateInvestmentRequest;
import com.dag.bankingsystem.repository.InvestmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import static com.dag.bankingsystem.model.mapper.InvestmentMapper.INVESTMENT_MAPPER;

@Service
@RequiredArgsConstructor
public class InvestmentService {

    private final InvestmentRepository investmentRepository;

    public InvestmentDto createInvestment(UpdateCreateInvestmentRequest updateCreateInvestmentRequest){
        Investment investment = INVESTMENT_MAPPER.createInvestment(updateCreateInvestmentRequest);
        return INVESTMENT_MAPPER.convertToInvestmentDto(investmentRepository.save(investment));
    }

    public void deleteInvestment(int id){
        investmentRepository.deleteById(id);
    }

    public InvestmentDto getInvestment(int id){
        return INVESTMENT_MAPPER.convertToInvestmentDto(getInvestmentById(id));
    }

    private Investment getInvestmentById(int id){
        return investmentRepository.findById(id).orElseThrow(()->new NotFoundException("Investment is not found"));
    }

    public InvestmentDto updateInvestment(int id,UpdateCreateInvestmentRequest updateCreateInvestmentRequest){
        Investment investment = getInvestmentById(id);
        INVESTMENT_MAPPER.updateInvestment(investment,updateCreateInvestmentRequest);
        return INVESTMENT_MAPPER.convertToInvestmentDto(investmentRepository.save(investment));

    }

    public InvestmentDto incrementFundOfInvestment(int id,int fund){
        Investment investment = getInvestmentById(id);
        investment.setFund(investment.getFund()+fund);
        return INVESTMENT_MAPPER.convertToInvestmentDto(investmentRepository.save(investment));
    }

}
