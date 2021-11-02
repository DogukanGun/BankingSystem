package com.dag.bankingsystem.validation;

import com.dag.bankingsystem.outsource.model.Currency;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

//@RequiredArgsConstructor
public class AccountTypeValidator implements ConstraintValidator<AccountType,String> {
//    private final List<Currency> currencies;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        return false;
    }
}
