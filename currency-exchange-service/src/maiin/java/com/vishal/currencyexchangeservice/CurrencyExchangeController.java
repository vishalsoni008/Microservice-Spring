package com.vishal.currencyexchangeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vishal.currencyexchangeservice.bean.ExchangeValue;
import com.vishal.currencyexchangeservice.repo.ExchangeValueRepository;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeValueRepository exchangeValueRepo;
	
	  @GetMapping("/currency-exchange/from/{from}/to/{to}")
	  public ExchangeValue retriveExchangeValue(@PathVariable String from,@PathVariable String to) {
	  ExchangeValue exchangeValue= exchangeValueRepo.findByFromAndTo(from, to);
	  exchangeValue.setPort(Integer.parseInt(environment.getProperty(
	  "local.server.port"))); 
	  return exchangeValue;
	  
	  }
	 

}
