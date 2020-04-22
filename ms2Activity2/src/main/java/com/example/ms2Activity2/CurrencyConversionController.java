package com.example.ms2Activity2;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	CurrencyExchangeProxy proxy;
	
	@GetMapping("/getConvertedAmount/{country}/{fromAmount}")
	@HystrixCommand(fallbackMethod = "myFallBack")
	public CurrencyConversionBean callGetConvertedAmount(@PathVariable String country,@PathVariable BigDecimal fromAmount) {
		System.out.println("inside=======================");
		ConversionFactor cf =  getConvertedAmount(country,fromAmount);
		System.out.println("cf=========="+cf.getCountryCode());
		System.out.println("port========"+cf.getPort());
		return new CurrencyConversionBean(cf.getCountryCode(),fromAmount,cf.getConverionFactor(),
				fromAmount.multiply(cf.getConverionFactor()),cf.getPort());
			
	}
public ConversionFactor getConvertedAmount(String country,BigDecimal fromAmount) {
		
	ConversionFactor bean = proxy.getConversionFactor(country) ;
	return bean;
		
	}
@GetMapping("/myFallback")
public CurrencyConversionBean myFallBack(String country) { System.out.println("Circuit Breaker called");
System.out.println("CircuitBreaker called ...something went wrong");
return new CurrencyConversionBean("US",new BigDecimal(0), new BigDecimal(0), new BigDecimal(0), 8080) ;
}


@GetMapping("/currencyFactor")
public String addConversionFactor() {
return ("Eneter the currency code and conversion factor for thr country");
}
}


