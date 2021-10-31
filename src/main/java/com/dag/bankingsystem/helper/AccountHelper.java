package com.dag.bankingsystem.helper;

import org.iban4j.CountryCode;
import org.iban4j.Iban;
import org.springframework.stereotype.Component;


@Component
public class AccountHelper {

    public static Iban createRandomIban(CountryCode countryCode){
        return Iban.random(countryCode);
    }

    public static Iban createIbanFromString(String string){
        return Iban.valueOf(string);
    }
}
