package com.example.ms2Activity2;


import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="currency-exchange-service")
@RibbonClient(name="currency-exchange-service",configuration = LocalRibbonClientConfiguration.class)
public interface CurrencyExchangeProxy {

	
	@GetMapping("/getCurrencyFactor/{country}")
	public ConversionFactor getConversionFactor(@PathVariable String country) ;
	
}
