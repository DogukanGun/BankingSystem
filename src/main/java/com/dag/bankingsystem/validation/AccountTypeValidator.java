package com.dag.bankingsystem.validation;

import com.dag.bankingsystem.outsource.model.Currency;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class AccountTypeValidator implements ConstraintValidator<AccountType,String> {
    private final List<Currency> currencies;

    @Override
    public boolean isValid(@NotNull String value, ConstraintValidatorContext context) {
        try {
            currencies.stream().filter(currency -> currency.getCc().equals(value)).findAny().orElseThrow(()->new IllegalArgumentException("Currency is not found"));
        }catch (IllegalArgumentException illegalArgumentException){
            return false;
        }catch (Exception e){
            log.error("Exception is found when currency is being checked. Message is:"+e.getLocalizedMessage());
        }
        return true;
    }
}
