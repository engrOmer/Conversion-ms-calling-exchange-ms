package com.example.microservice.currencyexchangemicroservice;

import com.example.microservice.currencyexchangemicroservice.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange,Long> {
CurrencyExchange findByFromAndTo(String From, String To);

}
