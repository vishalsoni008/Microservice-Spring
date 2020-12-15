package com.vishal.microservices.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
//import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.vishal.microservices.currencyconversionservice.Bean.CurrencyConversionBean;

//@FeignClient(name = "currency-exchange-service",url = "localhost:8001")
@FeignClient(name = "currency-exchange-service")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeProxy {
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	  public CurrencyConversionBean retriveExchangeValue(@PathVariable("from") String from,@PathVariable("to") String to);

}
