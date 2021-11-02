package com.dag.bankingsystem.configuration;

import com.dag.bankingsystem.outsource.data_generate.JsonToClass;
import com.dag.bankingsystem.outsource.model.Currency;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {
    private final JsonToClass jsonToClass;


    @Bean
    public List<Currency> getCurrencies(){
        return jsonToClass.parseJson();
    }
}
