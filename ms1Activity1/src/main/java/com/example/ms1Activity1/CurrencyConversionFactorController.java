package com.example.ms1Activity1;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class CurrencyConversionFactorController {

	@Autowired
	private CurrencyRepository repository;
	 @Autowired
	  private Environment environment;
	@GetMapping("/currencyFactor/{country}")
	public String addConversionFactor(@PathVariable String country) {
		return ("Eneter the country and conversion factor for thr country");
	}

	@GetMapping("/currencyFactor")
		public String addConversionFactor() {
		return ("Eneter the currency code and conversion factor for thr country");
	}

	@GetMapping("/currencyFactor/{country}/{cfactor}")
	public String addConversionFactor(@PathVariable String country,@PathVariable String cfactor) {
		BigDecimal confactor = new BigDecimal(cfactor);
		
		ConversionFactor cf = new ConversionFactor(country,confactor);
		if (cf == null || cf.getCountryCode() == null) {
			return ("Enter the Country code and conversion factor");
		} else {
			repository.save(cf);
			return "Country code added with conversion factor successfully.";
		}

	}
	@GetMapping("/updateCurrencyFactor/{country}/{cfactor}")
	public String updateConversionFactor(@PathVariable String country,@PathVariable String cfactor) {
		BigDecimal confactor = null;
		
		ConversionFactor cf = new ConversionFactor(country,confactor);
		if (cf == null || cf.getCountryCode() == null) {
			return ("Enter the Country code or conversion factor to update");
		} else {
			repository.save(cf);
			return "Country code updated with conversion factor successfully.";
		}


	}


	@GetMapping("/getCurrencyFactor/{country}")
	@HystrixCommand(fallbackMethod = "myFallBack")
	public ConversionFactor getConversionFactor(@PathVariable String country) {
		Optional<ConversionFactor> ctry = repository.findById(country);
		int port =  Integer.parseInt(environment.getProperty("local.server.port"));
		
		if(ctry.isPresent()) {
			
			return new ConversionFactor(country, ctry.get().getConverionFactor(),port);
					//String.valueOf(ctry.get().getConverionFactor());
		}
		else {
			throw new RuntimeException();
		}
	
	}


	public ConversionFactor myFallBack(String country) { System.out.println("Circuit Breaker called");
	System.out.println("CircuitBreaker called ...something went wrong");
	return new ConversionFactor("US", new BigDecimal(1),8081);

	}


}
