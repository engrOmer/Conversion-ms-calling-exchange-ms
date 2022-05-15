package com.example.microservice.currencyexchangemicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.env.Environment;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class CurrencyExchangeController {
    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange currencyExchange(@PathVariable String from, @PathVariable String to ){
    CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from,to);
        String property = environment.getProperty("local.server.port");
        currencyExchange.setEnvironement(property);
    return currencyExchange;
}


}